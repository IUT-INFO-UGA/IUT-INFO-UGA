(function () {
  'use strict';

  /**
   * Email regular expression
   * @type {Regex}
   */
  const emailRegex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

  /**
   * Password regular expression
   * @type {Regex}
   */
  const passwordRegex = /^[a-z0-9]+$/;

  /**
   * Signup form
   * @type {HTMLFormElement}
   */
  const loginForm = document.forms[0];

  /**
   * The different fields.
   * @type {HTMLInputElement}
   */
  const inputs = loginForm.querySelectorAll('input'),
    emailField = document.getElementById('email-field'),
    passwordField = document.getElementById('password-field'),
    loginBtn = document.getElementById('login-btn');

  /**
   * Remove the "invalid" class of elements and add the "valid" one.
   * @param {Array.<HTMLElement>} elements - an array of elements.
   */
  const validate = function (...elements) {
    elements.forEach((element) => {
      element.classList.remove('invalid');
      element.classList.add('valid');
      element.classList.remove('info');
    });
  };

  /**
   * Remove the "valid" class of elements and add the "invalid" one.
   * @param {Array.<HTMLElement>} elements - an array of elements.
   */
  const invalidate = function (...elements) {
    elements.forEach((element) => {
      element.classList.add('invalid');
      element.classList.remove('valid');
      element.classList.remove('info');
    });
  };

  /**
   * Remove both the "valid" and "invalid" classes of elements.
   * @param {Array.<HTMLElement>} elements - an array of elements.
   */
  const unset = function (...elements) {
    elements.forEach((element) => {
      element.classList.remove('invalid');
      element.classList.remove('valid');
      element.classList.remove('info');
    });
  };

  /**
   * Check email formatting.
   * @return {boolean} true if the validation is correct, false otherwise.
   */
  const checkEmail = function () {
    const value = emailField.value,
      validation = document.getElementById('validation-email');

    if (!emailRegex.test(value)) {
      validation.innerText = 'Wrong email format';
      invalidate(validation, emailField);
      return false;
    } else {
      validate(validation, emailField);
      validation.innerText = 'Correct email format';
      return true;
    }
  };

  /**
   * Check password formatting.
   * @return {boolean} true if the validation is correct, false otherwise.
   */
  const checkPassword = function () {
    const value = passwordField.value,
      validation = document.getElementById('validation-password');

    if (value.length < 5) {
      validation.innerText = 'Password too short (5 characters or more)';
      invalidate(validation, passwordField);
      return false;
    } else {
      validate(validation, passwordField);
      validation.innerText = 'Password okay';
      return true;
    }
  };


  /**
   * Check if the form is valid.
   * If the form is valid, then the sign up button is no longer disabled.
   * @return {boolean} true if the validation is correct, false otherwise.
   */
  const checkForm = async function () {
    const hasErrors =
      (emailField.value === '' || !checkEmail()) |
      (passwordField.value === '' || !checkPassword())
;

    if (hasErrors === 0) {
      loginBtn.removeAttribute('disabled');
    } else {
      loginBtn.setAttribute('disabled', 'disabled');
    }

    return hasErrors === 0;
  };

  /**
   * Login.
   * @param {Event} e - the form event when submitting the form.
   */
  const login = async function (e) {
    e.preventDefault();
    if (!(await checkForm())) {
      alert('some errors found.');
    } else {
      fetch('./verification').then(data => data.json()).then(data => {
        document.getElementById('login-modal').classList.add('hide');
        if (!data.trusted) {
          document.getElementById('confirm-modal').classList.remove('hide');
          window.buildConfirmDialog(data);
        } else {
          document.getElementById('welcome-modal').classList.remove('hide');
        }
      });
    }
  };

  inputs.forEach((input) => {
    input.addEventListener('input', checkForm);
  });

  emailField.addEventListener('input', checkEmail);

  loginForm.addEventListener('submit', login);

  // Check the form if some data are already present (e.g., after pressing F5)
  checkForm();
})();
