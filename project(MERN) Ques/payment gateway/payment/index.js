const express=require("express");
const axios = require('axios');
const uniqid = require('uniqid');
const port=3002;
const app=express();
const sha256 = require('sha256');

//etsting phonepe
const PHONE_PE_HOST_URL="https://api-preprod.phonepe.com/apis/pg-sandbox"
// const merchantId = "PGTESTPAYUAT"
const merchantId="PGTESTPAYUAT86";
const SALT_INDEX=1;
// const SALT_KEY="099eb0cd-02cf-4e2a-8aca-3e6c6aff0399";
const SALT_KEY="96434309-7796-489d-8924-ab56988a6076"
app.get("/",(req,res)=>{
    res.send("phonepe is working");
})

app.get("/pay",(req,res)=>{
    const payEndpoint="/pg/v1/pay";
    const merchantTransactionId=uniqid();
    const userId=123;
    const payload={
        merchantId: merchantId,
        merchantTransactionId: merchantTransactionId,
        merchantUserId:userId,
        amount: 10000,
        redirectUrl: `http://localhost:3002/redirect-url/${merchantTransactionId}`,
        redirectMode: "REDIRECT",
        // "callbackUrl": "https://webhook.site/callback-url",
        mobileNumber: "9999999999",
        paymentInstrument: {
            type: "PAY_PAGE"
        }
    }
    // SHA256(base64 encoded payload + “/pg/v1/pay” + salt key) + ### + salt index
    const bufferObj=Buffer.from(JSON.stringify(payload),'utf8');
    const base63EncodedPayload= bufferObj.toString("base64")
    const xVerify= sha256(base63EncodedPayload+payEndpoint+SALT_KEY)+"###"+SALT_INDEX;

    const options = {
        method: 'post',
        url: `${PHONE_PE_HOST_URL}${payEndpoint}`,
        headers:{
              accept: 'application/json',
              'Content-Type': 'application/json',
              'X-VERIFY':xVerify,
            },
      data: {
        request:base63EncodedPayload,
      }
      };
      axios
        .request(options)
            .then(function (response) {
            console.log(response.data);
            const url=response.data.data.instrumentResponse.redirectInfo.url;
            res.redirect(url);
            // res.send({url});
        })
        .catch(function (error) {
          console.error(error);
        });
})

app.get("/redirect-url/:merchantTransactionId",(req,res)=>{
    const {merchantTransactionId}=req.params;
    console.log("merchantTransactionId",merchantTransactionId);
    if(merchantTransactionId){
        // res.send({merchantTransactionId})
        const xVerify=sha256(`/pg/v1/status/${merchantId}/${merchantTransactionId}`+SALT_KEY)+"###"+SALT_INDEX
        // SHA256(“/pg/v1/status/{merchantId}/{merchantTransactionId}” + saltKey) + “###” + saltIndex
        const options = {
            method: 'get',
            url: `${PHONE_PE_HOST_URL}/pg/v1/status/${merchantId}/${merchantTransactionId}`,
            headers: {
                  accept: 'application/json',
                  'Content-Type': 'application/json',
                  'X-VERIFY':xVerify,
                  'X-MERCHANT-ID':merchantTransactionId
                          },
          
          };
          axios
            .request(options)
                .then(function (response) {
                console.log(response.data);
                if(response.data.code==='PAYMENT_SUCCESS'){
                    //redirect succrss page
                }else if(response.data.code==='PAYMENT_ERROR'){
                    //redirect fail page
                }else{
                    //pending page
                }
                res.send(response.data);
            })
            .catch(function (error) {
              console.error(error);
            });
    }else{
        res.send({error:"Error"})
    }
})

app.listen(port,()=>{
    console.log(` App is running on ${port}`)
})