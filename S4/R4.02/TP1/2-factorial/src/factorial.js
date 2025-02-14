/**
 * Return the factorial of i.
 * @param {number} i - an integer number.
 * @return {number} the factorial of i.
 */
export const factorial = function (i) {
  if (i && typeof i == "number" && i % 1 == 0 && i >= 0) {
    if (i < 2) return 1;
    return i * factorial(i - 1);
  } else {
    if (i == 0) {
      return 1;
    }
    throw "error";
  }
};

export default factorial;
