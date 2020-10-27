class Taiyaki{
  constructor(nakami){
    this.nakami = nakami;
  }
  play(){
    console.log(`中身は${this.nakami}です`)
  }
}
let anko = new Taiyaki('あんこ');
let cream = new Taiyaki('クリーム');
let cheeze = new Taiyaki('チーズ');
anko.play();
cream.play();
cheeze.play();