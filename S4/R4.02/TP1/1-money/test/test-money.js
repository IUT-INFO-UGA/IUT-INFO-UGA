import Money from "../src/money.js";
import { assert } from "chai";

describe("Money", function () {
  describe("#add()", function () {
    let m1;
    beforeEach(() => {
      m1 = new Money(10.0, "EUR");
    });
    it("should correctly add two moneys with the same currency", function () {
      let m2 = new Money(10.0, "EUR");

      m1.add(m2); // Add the amount of m2 up to the amount of m1. m1 est updated.

      let newAmount = m1.amount, // Retrieve the new amount
        oracle = 30.0; // Comparison to the expected result

      assert.equal(
        newAmount,
        oracle,
        `m1 vaut ${newAmount}€ alors qu'il devrait valoir ${oracle}€`
      );
    });

    it("should correctly add two moneys with different currencies", function () {
      let m2 = new Money(20.0, "USD");

      m1.add(m2); // Add the amount of m2 up to the amount of m1. m1 est updated.

      let newAmount = m1.amount, // Retrieve the new amount
        oracle = 20.0; // Comparison to the expected result

      assert.equal(newAmount, oracle); // Assertion for comparison
    });

    it("should throw an exception when the currency is neither EUR nor USD", function () {
      let m2 = new Money(20.0, "BRL"); // BZR : Brazilian real

      assert.throws(function () {
        // Catch the exception
        m1.add(m2);
      });
    });
  });
});
