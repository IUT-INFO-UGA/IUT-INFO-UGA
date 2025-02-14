import assert from "assert";
import factorial from "../src/factorial.js";

describe("factorial", function () {
  it("4! should give 24", function () {
    assert.equal(factorial(4), 24);
  });

  it("3! should give 6", function () {
    assert.equal(factorial(3), 6);
  });

  it("0! should give 1", function () {
    assert.equal(factorial(0), 1);
  });

  it("An negative number should throw an exception", function () {
    assert.throws(function () {
      factorial(-1);
    });
  });

  it("Any invalid input should throw an exception", function () {
    assert.throws(function () {
      factorial(1.2);
    });
    assert.throws(function () {
      factorial();
    });
    assert.throws(function () {
      factorial(null);
    });
    assert.throws(function () {
      factorial("hello world");
    });
  });
});
