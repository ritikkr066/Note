
// Longest word in string

// key point
    // .reduce() – reduces the array to a single value.
    // accum – short for "accumulator"; it keeps track of the longest word found so far.
    // "" – initial value of accum, an empty string.

const findLongestWord=(str)=>{
    if(str.trim().length===0){
        return false;
    }

    let words=str.split(" ");
    // words=words.sort((a,b)=>a.length-b.length); // on basis on unicode

     // console.log(words)
    // return words.at(-1);

    return words.reduce((accum,currWord)=>(currWord.length>accum.length?currWord: accum),"");
}

console.log(
    findLongestWord("Watch Thapa Technical lkwefjkwhfjkwhejk course on youtube")
)