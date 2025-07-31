// Hash tag generator

//key point
    // .map() is a method in JavaScript that:
        // Takes a function and applies it to every element in the array.
        // Returns a new array with the transformed elements.

const generateHash=(str)=>{
    str = str.split(" ");

    str = str.map((currElem)=>
        //  currElem.replace(currElem[0],currElem[0].toUpperCase())
        currElem.charAt(0).toUpperCase() + currElem.slice(1)
    );

    str = `#${str.join("")}`
    return str
    
}


console.log(generateHash("my name is ritik kumar singh"));