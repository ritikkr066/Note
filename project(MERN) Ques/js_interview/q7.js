//find max
    // The spread operator in JavaScript is used to expand (or "spread out") the elements of an iterable (like an array) into individual elements.
    // Spreads the array elements individually (e.g., [1, 2, 3] → 1, 2, 3)


const findMax=(arr)=>{
    console.log(...arr);
    return Math.min(...arr);
}

console.log(findMax([1,2,-3,-4,10]));