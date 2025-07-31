//find avg

const findAvg=(arr)=>{
    // let total=arr.reduce((accum,currElem)=>accum+currElem,0);
    let total = arr.reduce((accum, currElem) => {
        return accum + currElem;
    }, 0);
    return total/arr.length;
}

console.log(findAvg([6,8,4,9,2]));