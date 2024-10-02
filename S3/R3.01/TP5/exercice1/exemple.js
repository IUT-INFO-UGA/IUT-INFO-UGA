const input = document.querySelector("input");
input.addEventListener("change", updateValue);

function updateValue(e) {
  val = e.target.value;
  for (let i = 0; i < 10; i++) {
    console.log(`${i} * ${val} = ${i * val}`);
  }
}
