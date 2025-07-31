// find fictorial

// const factorial=(num)=>{
//     let fact=1;

//     for(let i=1;i<=num;i++){
//         fact*=i;
//     }
//     return fact;
// }

// console.log(factorial(5));


const factorial = (num) => {
    if (num === 0 || num === 1) {
        return 1;
    }
    return num * factorial(num - 1);
}

console.log(factorial(6)); // Output: 720
