let scores = [10,15,20,25];
let i = 0;
while(i < scores.length){
  if (scores[i] % 2 ==0){
    console.log(`${scores[i]}は偶数です`);
  }
  i++
}

let car = {gas: 20.5, num: 1234};
console.log(`ガソリンは${car.gas}`);
console.log(`ナンバーは${car.num}`);