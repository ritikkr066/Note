//sum of digit

// const sumOfDigit=(num)=>{
//     let arr=Array.from(String(num),Number)

//     return arr.reduce((accum,currVal)=>accum+=currVal,0);
// }

// console.log(sumOfDigit(1234));



const sumOfDigit = (num) => {
    let sum = 0;

    while (num > 0) {
        sum += num % 10;     // get the last digit
        num = Math.floor(num / 10);  // remove the last digit
    }

    return sum;
}

console.log(sumOfDigit(1234)); // Output: 10
