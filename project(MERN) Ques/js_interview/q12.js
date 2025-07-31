// remove duplicate

const removeDuplicate=(arr)=>{
    let newArr =[...new Set(arr)];

    return newArr;
}


console.log(removeDuplicate([1,2,3,2,1,4]));

