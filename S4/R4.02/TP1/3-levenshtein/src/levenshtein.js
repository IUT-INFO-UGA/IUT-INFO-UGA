/**
 * Prepare une matrice à deux dimensions et remplit la matrice
 * avec des 0.
 * @param {Number} lineNumber - le nombre de lignes.
 * @param {Number} columnNumber - le nombre de colonnes.
 * @return {Array.<Array.<Number>>} la matrice créee
 */
const prepareMatrix = function (lineNumber, columnNumber) {
  const arr = new Array(lineNumber);
  for (let i = 0; i < arr.length; i++) {
    arr[i] = new Array(columnNumber).fill(0);
  }
  return arr;
};

/**
 * Initialise la matrice D.
 * @param {Array.<Array.<Number>>} d - la matrice d.
 */
const initD = function (d) {
  // On remplit la première colonne
  console.log(d);
  for (let i = 0; i < d.length; i++) {
    d[i][0] = i;
  }

  // On remplit la premiere ligne
  for (let i = 0; i < d[0].length; i++) {
    d[0][i] = i;
  }
  console.log(d);
};

/**
 * Initialise la matrice Cout.
 * @param {Array.<Array.<Number>>} cout - la matrice Cout.
 * @param {string} str1 - première chaîne.
 * @param {string} str2 - seconde chaîne.
 */
const initCout = function (cout, str1, str2) {
  // Pour chaque ligne
  for (let i = 0; i < cout.length; i++) {
    // Pour chaque colonne
    for (let j = 0; j < cout[i].length; j++) {
      if (str1.charAt(i) === str2.charAt(j)) {
        cout[i][j] = 0;
      } else {
        cout[i][j] = 1;
      }
    }
  }
};

/**
 * Remplit la matrice D à partir des informations de la matrice Cout.
 * @param {Array.<Array.<Number>>} d - la matrice D.
 * @param {Array.<Array.<Number>>} cout - la matrice Cout.
 */
const fillD = function (d, cout) {
  // Pour chaque ligne
  for (let i = 1; i < d.length; i++) {
    // Pour chaque colonne
    for (let j = 1; j < d[i].length; j++) {
      const deletionValue = d[i - 1][j] + 1,
        insertionValue = d[i][j - 1] + 1,
        substitutionValue = d[i - 1][j - 1] + cout[i - 1][j - 1];

      const minValue = Math.min(
        deletionValue,
        insertionValue,
        substitutionValue
      );

      d[i][j] = minValue;
    }
  }
};

/**
 * Calcule la distance entre deux chaînes de caractères.
 * @param {string} str1 - première chaîne.
 * @param {string} str2 - seconde chaîne.
 * @return {Object} un objet contenant la distance calculée ainsi que diverses autres informations.
 */
const levenshtein = function (str1, str2) {
  const n = str1.length; // Soit n la longueur de la chaine1,
  const m = str2.length; // Soit m la longueur de la chaine2,

  const d = prepareMatrix(n + 1, m + 1), // Soit une matrice D
    cout = prepareMatrix(n, m); // Soit une matrice Cout

  initD(d);
  initCout(cout, str1, str2);
  fillD(d, cout);

  return {
    d: d,
    cout: cout,
    distance: d[str1.length][str2.length],
  };
};

export default levenshtein;
