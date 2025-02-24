// ### Script à débugger ###

// ### Section 1 ###
document
  .querySelector("html body section#section1 button")
  ?.addEventListener("click", () => {
    let textS2 = document.querySelector("#section1 p").textContent;
    // On remplace "PHP" par "Node.js" (affiché en gras)
    textS2 = textS2.replace("PHP", "<b>Node.js</b>");

    document.querySelector("#section1 p").textContent = textS2;
  });

// Section1-Q1 : Est-ce que l'évènement se déclenche bien au clic ?
// Section1-Q2 : Pourquoi ce code ne fonctionne pas ?
// => Corriger ce code pour que ça fonctionne comme attendu

// ### Section 2 ###
/**
 * Convertit les degrés Celsius en degrés Fahrenheit.
 * (En tout cas, c'est ce qu'elle devrait faire...)
 * @param {numeric} celsius : Degrés Celsius
 * @returns {numeric} Degrés Fahrenheit
 */
let celsiusToFahrenheit = (celsius) => {
  return (celsius * 9) / 5 + 32;
};

document
  .querySelector("#section2 > button:nth-child(4)")
  ?.addEventListener("click", () => {
    let degC = document.querySelector(
      "#section2 > label:nth-child(3) > input:nth-child(1)"
    ).value;
    let degF = celsiusToFahrenheit(parseFloat(degC));
    console.log(degF);

    document.querySelector(
      "#section2 > p:nth-child(5) > strong:nth-child(1)"
    ).textContent = degF;
  });

// Section2-Q1 : Est-ce que l'évènement se déclenche bien au clic ?
// Section2-Q2 : Pourquoi ce code ne fonctionne pas ?
// => Corriger ce code pour que ça fonctionne comme attendu

/* Pour information :
    - 0°C = 32°F
    - 2°C = 35.6°F
    - 15°C = 59°F
    - 21°C = 69.8°F
*/
