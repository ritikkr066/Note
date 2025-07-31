



const numbers=[1,2,2,3,1,4,2];
let counts={};

for(let ele of numbers){
    counts[ele] = (counts[ele] || 0)+1;
}

console.log(counts);
