(function () {
    'use strict';

    /**
     * Confirmation form
     * @type {HTMLFormElement}
     */
    const confirmForm = document.forms[1];

    /**
     * The different fields.
     * @type {HTMLInputElement}
     */
    const inputs = confirmForm.querySelectorAll('input'),
        codeGroup = document.getElementById('code-group'),
        confirmBtn = document.getElementById('confirm-btn'),
        sendAgainBtn = document.getElementById('send-again-btn');

    /**
     * The other fields.
     * @type {HTMLInputElement}
     */
    const ipOutput = document.getElementById('ip-output'),
        emailOutput = document.getElementById('email-output'),
        nameOutput = document.getElementById('name-output'),
        remainingSecondsOutput = document.getElementById('remaining-seconds-output');


    codeGroup.querySelectorAll('input').forEach(input => {
        input.addEventListener('keyup', (e) => {
            const { value } = input;
            if (!/[0-9]/.test(value)) {
                input.value = '';
            }
            else if (input.nextElementSibling) {
                input.nextElementSibling.focus();
            }
        });
    });

    /**
   * Check if the form is valid.
   * If the form is valid, then the sign up button is no longer disabled.
   * @return {boolean} true if the validation is correct, false otherwise.
   */
    const checkForm = async function () {
        let hasErrors = 0;

        codeGroup.querySelectorAll('input').forEach(input => {
            const { value } = input;
            if (!/[0-9]/.test(value)) {
                hasErrors++;
            }
        });


        if (hasErrors === 0) {
            confirmBtn.removeAttribute('disabled');
        } else {
            confirmBtn.setAttribute('disabled', 'disabled');
        }

        return hasErrors === 0;
    };

    /**
     * Confirm.
     * @param {Event} e - the form event when submitting the form.
     */
    const confirm = async function (e) {
        e.preventDefault();
        if (!(await checkForm())) {
            alert('some errors found.');
        } else {
            alert('confirmation in progress, please wait...');
        }
    };

    inputs.forEach((input) => {
        input.addEventListener('input', checkForm);
    });

    confirmForm.addEventListener('submit', confirm);

    confirmForm.addEventListener('reset', () => {
        buildConfirmDialog();
    });

    setInterval(() => {
        const value = parseInt(remainingSecondsOutput.innerText);
        if (value > 0) {
            remainingSecondsOutput.innerText = value - 1;
        }
        else {
            sendAgainBtn.removeAttribute('disabled');
        }
    }, 1000);

    const buildConfirmDialog = function (data = {}) {
        console.log("test");
        if (data.ip) {
            ipOutput.innerText = data.ip;
        }
        if (data.email) {
            emailOutput.innerText = data.email;
        }
        if (data.name) {
            nameOutput.innerText = data.name;
        }
        sendAgainBtn.setAttribute('disabled', 'disabled');
        confirmBtn.setAttribute('disabled', 'disabled');
        remainingSecondsOutput.innerText = 50;
        inputs.forEach((input) => { input.value = ''; });
        inputs[0].focus();
    };

    window.buildConfirmDialog = buildConfirmDialog;

})();  