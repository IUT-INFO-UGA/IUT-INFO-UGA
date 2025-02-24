class Rectangle {
  constructor() {
    this.a = 4;
  }

  truc() {
    (() => {
      console.log(this.a);
    })();

    function truc() {
      console.log(this.a);
    }
    truc();
  }
}

const rec = new Rectangle();
