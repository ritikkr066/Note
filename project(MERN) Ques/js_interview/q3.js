//count occcurrence of character

const countChar=(word,char)=>{
    word= word.toLowerCase();
    char = char.toLowerCase();

     return totalCount=word.split("").reduce((accum,currChar)=>{
        if(currChar==char)accum++;

        return accum;
    },0);
    // console.log(totalCount)
    // return totalCount;
}

console.log(countChar("MissIssipi","I"));