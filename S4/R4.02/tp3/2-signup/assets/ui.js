(function () {
  'use strict';

  /**
   * Email regular expression
   * @type {Regex}
   */
  const emailRegex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

  /**
   * First and last name regular expression
   * @type {Regex}
   */
  const nameRegex = /^[a-zA-Z]{2,}$/;

  /**
   * Operand of the additive capcha.
   * @type number
   */
  let op1 = 2,
    op2 = 6;

  /**
   * Signup form
   * @type {HTMLFormElement}
   */
  const signupForm = document.forms[0];

  /**
   * The different fields.
   * @type {HTMLInputElement}
   */
  const inputs = signupForm.querySelectorAll('input'),
    firstNameField = document.getElementById('first-name-field'),
    lastNameField = document.getElementById('last-name-field'),
    emailField = document.getElementById('email-field'),
    capchaField = document.getElementById('capcha-field'),
    signupBtn = document.getElementById('signup-btn');

  /**
   * The language list field (ul tag)
   * @type {HTMLUListElement}
   */
  const languageList = document.getElementById('language-list');

  /**
   * The first element of the list.
   * At the start, it only contains the placeholder
   * @type {HTMLLIElement}
   */
  const placeholder = languageList.querySelector('li.placeholder');

  // Set the value of the placeholder equal to its data attribute
  placeholder.innerText = placeholder.getAttribute('data-placeholder-content');

  /**
   * Remove the "invalid" class of elements and add the "valid" one.
   * @param {Array.<HTMLElement>} elements - an array of elements.
   */
  const validate = function (...elements) {
    elements.forEach((element) => {
      element.classList.remove('invalid');
      element.classList.add('valid');
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
    });
  };

  /**
   * When the language list is focused.
   * @param {FocusEvent} e - the focus event.
   */
  const onLanguageListFocus = function (e) {
    const li = e.target,
      value = li.innerText.trim(),
      isPlaceholder = li.classList.contains('placeholder'),
      isEmpty =
        value == '' ||
        (isPlaceholder &&
          value === li.getAttribute('data-placeholder-content'));

    if (isEmpty) li.innerHTML = '&nbsp;';
  };

  /**
   * When the language list loses focus.
   * @param {FocusEvent} e - the focus event.
   */
  const onLanguageListBlur = function (e) {
    const li = e.target,
      value = li.innerText.trim(),
      isPlaceholder = li.classList.contains('placeholder');

    if (value) {
      createBadge(li);
      checkLanguageList();
    } else if (isPlaceholder) {
      placeholder.innerText = placeholder.getAttribute(
        'data-placeholder-content'
      );
      checkLanguageList();
    }
  };

  /**
   * When something is input in the language list.
   * @param {InputEvent} e - the input event.
   */
  const onLanguageListInput = (e) => {
    const li = e.target,
      value = li.innerText.trim();

    // This is triggered when <enter> is pressed
    if (e.inputType === 'insertParagraph') {
      createBadge(li);
    }
    // The code below is a workaround for firefox bug of adding <br> in empty <li>
    else if (value === '') {
      li.innerHTML = '&nbsp;';
    }
  };

  /**
   * Create a badge from a <li> element.
   * @param {HTMLLIElement} element - the li element in which a new
   * programming language have been type.
   */
  const createBadge = function (element) {
    // Save the element
    element.removeAttribute('contenteditable');
    element.classList.add('badge');
    element.innerText = element.innerText.trim().toLowerCase();
    element.removeEventListener('focus', onLanguageListFocus);
    element.removeEventListener('blur', onLanguageListBlur);
    element.removeEventListener('input', onLanguageListInput);

    // Create a new empty <li> element
    const li = document.createElement('li');
    li.setAttribute('contenteditable', true);
    element.parentNode.append(li);
    li.addEventListener('focus', onLanguageListFocus);
    li.addEventListener('blur', onLanguageListBlur);
    li.addEventListener('input', onLanguageListInput);

    // Focus on the newly created element
    li.focus();
  };

  /**
   * Check the formatting of the first or last name.
   * @param {string} value - the first or last name.
   * @return {boolean} true if the formatting is correct, false otherwise.
   */
  const checkNameValue = function (value) {
    return value !== '' && nameRegex.test(value);
  };

  /**
   * Check the correct input of the first or last name.
   * @param {(InputEvent|FocusEvent)} e - the event triggering the function.
   * @return {boolean} true if the validation is correct, false otherwise.
   */
  const checkName = function (e) {
    const input = e.target,
      value = input.value,
      validation = document.getElementById('validation-name');

    // If the formatting is incorrect
    if (!nameRegex.test(value)) {
      validation.innerText =
        'At least two characters needed, only letters, spaces, and dashes';
      invalidate(validation, input);
      return false;
      // If the formatting is correct, with check the other field as well.
      // if Both are correct.
    } else if (
      checkNameValue(firstNameField.value) &&
      checkNameValue(lastNameField.value)
    ) {
      validation.innerText = `Welcome ${firstNameField.value} ${lastNameField.value}!`;
      validate(validation, input);
      return true;
      // If one is correct and the other not
    } else if (!validation.classList.contains('unset')) {
      validation.innerText = '';
      validate(input);
      unset(validation);
      return true;
    }
  };

  /**
   * Check first name.
   * @return {boolean} true if the validation is correct, false otherwise.
   */
  const checkFirstName = function () {
    return checkName({ target: firstNameField });
  };

  /**
   * Check last name.
   * @return {boolean} true if the validation is correct, false otherwise.
   */
  const checkLastName = function () {
    return checkName({ target: lastNameField });
  };

  /**
   * Check if the email already exists. It fetches the server to see if the email is correct or not.
   * @param {String} email - the email value.
   * @return {Promise} a promise that will be resolved upon the server reply.
   */
  const checkIfEmailAlreadyExists = async function (email) {
    const url = `/email?email=${email}`;

    return fetch(url, { method: 'GET' });
  };

  /**
   * Check email formatting and existence.
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
   * Check the email existence when the input loses focus.
   * This function is different than checkIfEmailAlreadyExists as it does not return a Promise.
   * Instead, this function updates the state of the email field and validation message.
   * @TODO: the names of the function is confusing. It should be improved.
   */
  const checkEmailExistence = function () {
    const value = emailField.value,
      validation = document.getElementById('validation-email');

    if (!checkEmail()) return false;

    checkIfEmailAlreadyExists(value)
      .then((data) => {
        return data.json();
      })
      .then((data) => {
        validation.innerText = data.msg;
        if (data.presentInDatabase) {
          invalidate(validation, emailField);
          validation.innerText = 'This email has already been used';
        } else {
          validate(validation, emailField);
          validation.innerText = 'This email has not already been used';
        }
      });
  };

  /**
   * Check if the Capcha is valid.
   * @return {boolean} true if the validation is correct, false otherwise.
   */
  const checkCapcha = function () {
    const value = parseInt(capchaField.value),
      validation = document.getElementById('validation-capcha');

    const oracle = op1 + op2,
      result = oracle === value;

    if (result) {
      validation.innerText = 'Nice work!';
      validate(validation, capchaField);
    } else {
      validation.innerText = 'The result is incorrect. Are you a robot?';
      invalidate(validation, capchaField);
    }

    return result;
  };

  /**
   * Return the list of <li> elements containing languages.
   * @return {Array.<HTMLLIElement>} an array of <li> elements.
   */
  const getPickedLanguages = function () {
    const languageElements = [];
    languageList.querySelectorAll('li').forEach((li) => {
      const isPlaceholder = li.classList.contains('placeholder'),
        value = li.innerText.trim(),
        isEmpty =
          value == '' ||
          (isPlaceholder &&
            value === li.getAttribute('data-placeholder-content'));

      if (!isEmpty) {
        languageElements.push(li);
      }
    });
    return languageElements;
  };

  /**
   * Check whether at least three programming languages have been proposed.
   * @return {boolean} true if the validation is correct, false otherwise.
   */
  const checkLanguageList = function () {
    const languages = getPickedLanguages(),
      l = languages.length,
      validation = document.getElementById('validation-languages');

    if (l < 3) {
      validation.innerText = `${3 - l} remaining.`;
      invalidate(validation, languageList);
      return false;
    } else {
      validate(languageList);
      validation.innerText = ``;
      validate(validation);
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
      (emailField.value === '' || !(await checkEmail())) |
      (firstNameField.value === '' || !checkFirstName()) |
      (lastNameField.value === '' || !checkLastName()) |
      (emailField.value === '' || !checkEmail()) |
      (capchaField.value === '' || !checkCapcha()) |
      (getPickedLanguages().length < 3);

    if (hasErrors === 0) {
      signupBtn.removeAttribute('disabled');
    } else {
      signupBtn.setAttribute('disabled', 'disabled');
    }

    return hasErrors === 0;
  };

  /**
   * Draw an operand in the corresponding Canvas element for the additive Capcha.
   * @param {HTMLCanvasElement} canvas - the canvas containing the operand of the addition.
   * @param {number} value - the number to display in the Canvas.
   */
  const fillCapchaOperand = function (canvas, value) {
    canvas.height = '47';
    canvas.width = '100';

    const ctx = canvas.getContext('2d');
    ctx.save();
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    ctx.translate(canvas.width * 0.5, canvas.height * 0.5);
    ctx.rotate(-1 * Math.random() + 1 * Math.random());
    ctx.font = '36px serif';
    ctx.textAlign = 'center';
    ctx.fillText(value, 0, 11);
    ctx.restore();
  };

  /**
   * Generate a new Capcha.
   */
  const generateCaphca = function () {
    fetch('/capcha')
      .then((data) => {
        return data.json();
      })
      .then((data) => {
        op1 = data.op1;
        op2 = data.op2;
        const canvasOp1 = document.getElementById('op1'),
          canvasOp2 = document.getElementById('op2');

        fillCapchaOperand(canvasOp1, op1);
        fillCapchaOperand(canvasOp2, op2);
      });
  };

  /**
   * Signing up.
   * @param {Event} e - the form event when submitting the form.
   */
  const signup = async function (e) {
    e.preventDefault();
    if (!(await checkForm())) {
      alert('some errors found.');
    } else {
      alert('submission in progress, please wait...');
    }
  };

  // Event binding is done below
  placeholder.addEventListener('focus', onLanguageListFocus);
  placeholder.addEventListener('blur', onLanguageListBlur);
  placeholder.addEventListener('input', onLanguageListInput);

  inputs.forEach((input) => {
    input.addEventListener('input', checkForm);
  });

  firstNameField.addEventListener('input', checkName);
  firstNameField.addEventListener('blur', checkName);
  lastNameField.addEventListener('input', checkName);
  lastNameField.addEventListener('blur', checkName);
  emailField.addEventListener('input', checkEmail);
  emailField.addEventListener('blur', checkEmailExistence);
  capchaField.addEventListener('input', checkCapcha);
  capchaField.addEventListener('blur', checkCapcha);

  document
    .getElementById('reload-btn')
    .addEventListener('click', generateCaphca);

  signupForm.addEventListener('submit', signup);

  // Generate a capcha at the start
  generateCaphca();

  // Check the form if some data are already present (e.g., after pressing F5)
  checkForm();
})();
