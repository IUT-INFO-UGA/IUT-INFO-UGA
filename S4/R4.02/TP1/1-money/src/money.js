export class Money {
  /**
   * Create a money object in a specific currency.
   * @param {number} amount - the amount.
   * @param {string} currency - the currency.
   * @constructor
   */
  constructor(amount, currency) {
    this.amount = amount ?? 0.0;
    this.currency = currency ?? 'EUR';
  }

  /**
   * Add up the amount passed as parameter to this one.
   * @param {Money} m2 - the money to add up.
   * @private
   */
  add(m2) {
    if (m2.currency === this.currency) {
      this.amount += m2.amount;
    } else if (m2.currency === 'USD') {
      this.amount += m2.amount / 2;
    } else {
      throw 'Unknown currency';
    }
  }
}

export default Money;
