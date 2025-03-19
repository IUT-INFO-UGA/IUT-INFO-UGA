// Les variables ci-dessous peuvent être utilisées pour vous aider
// dans l'écriture de vos tests
const tomato = 'rgb(255, 99, 71)',
	green = 'rgb(0, 128, 0)';

describe('test-signup', () => {
	beforeEach(() => {
		cy.visit('http://localhost:8090/');
	});

	it('TF1 : "John Doe" is a valid name', () => {
		cy.get('#first-name-field').type('John');
		cy.get('#last-name-field').type('Doe');
		cy.get('#last-name-field').should('have.class', 'valid');
	});

	it('TF2 : "00ab" is an invalid first name', () => {
		cy.get('#first-name-field').type('00ab');
		cy.get('#first-name-field').should('have.class', 'invalid');
	});

	it('TF3: "abc@provider." is an invalid e-mail address', () => {
		cy.get('#email-field').type('abc@provider.');
		cy.get('#email-field').should('have.class', 'invalid');
	});

	it('TF4: a valid field has a green border color and the validation message is green', () => {
		cy.get('#first-name-field').type('John');
		cy.get('#last-name-field').type('Doe');
		cy.get('#last-name-field').should('have.css', 'border-color', green);
		cy.get('#validation-name').should('have.css', 'color', green);
	});

	it('TF5: an invalid field has a tomato border color and the validation message is tomato', () => {
		cy.get('#first-name-field').type('00');
		cy.get('#last-name-field').type('00');
		cy.get('#last-name-field').should('have.css', 'border-color', tomato);
		cy.get('#validation-name').should('have.css', 'color', tomato);
	});

	it('TF6 : an email that has not already been used displays a success message', () => {
		cy.get('#email-field').type('John.Doe@iut.fr');
		cy.get('#email-field').should('have.class', 'valid');
		cy.get('#email-field').should('have.css', 'border-color', green);
		cy.get('#validation-email').should('have.css', 'color', green);
	});

	it('TF7 : an email that has already been used displays an error message', () => {
		cy.intercept('GET', '/email?*', {
			statusCode: 200,
			body: {
				presentInDatabase: true,
				msg: 'This email has already been used'
			}
		});
		cy.get('#email-field').type('existing.email@domain.com');
		cy.get('#email-field').should('have.css', 'border-color', tomato);
		cy.get('#validation-email').should('have.css', 'color', tomato);
	});

	it('TF8 : entering a wrong Capcha displays an error message', () => {
		cy.intercept('GET', '/capcha', {
			statusCode: 200,
			body: { op1: 7, op2: 9 }
		});
		cy.get('#reload-btn').click();
		cy.get('#capcha-field').type('42');
		cy.get('#capcha-field').should('have.css', 'border-color', tomato);
		cy.get('#validation-capcha').should('have.text', 'The result is incorrect. Are you a robot?');
	});

	it('TF9 : entering a correct Capcha displays a success message', () => {
		cy.intercept('GET', '/capcha', {
			statusCode: 200,
			body: { op1: 7, op2: 9 }
		});
		cy.get('#reload-btn').click();
		cy.get('#capcha-field').type('16');
		cy.get('#capcha-field').should('have.css', 'border-color', green);
		cy.get('#validation-capcha').should('have.text', 'Nice work!');
	});

	it('TF10 : adding a programming language creates a new badge', () => {
		cy.get('#language-list').type('TypeScript');
		cy.get('[contenteditable="true"]').blur();
		cy.get('.placeholder').should('exist');
	});

	it('TF11 : entering less than three programming languages displays an error message', () => {
		['TypeScript', 'react'].forEach(el => {
			cy.get('#language-list').type(el);
			cy.get('[contenteditable="true"]').blur();
		});
		cy.get('#language-list').should('have.css', 'border-color', tomato);
		cy.get('#validation-languages').should('have.text', '1 remaining.');
	});

	it('TF12 : entering three or more programming languages is valid', () => {
		['TypeScript', 'react', 'c++'].forEach(el => {
			cy.get('#language-list').type(el);
			cy.get('[contenteditable="true"]').blur();
		});
		cy.get('#language-list').should('have.css', 'border-color', green);
	});

	it.only('TF13 : the signup form can be validated upon completing all fields', () => {
		cy.get('#first-name-field').type('John');
		cy.get('#last-name-field').type('Doe');
		cy.get('#email-field').type('John.Doe@iut.fr');

		cy.intercept('GET', '/capcha', {
			statusCode: 200,
			body: { op1: 7, op2: 9 }
		});
		cy.get('#reload-btn').click();
		cy.get('#capcha-field').type('16');
		['TypeScript', 'react', 'c++'].forEach(el => {
			cy.get('#language-list').type(el);
			cy.get('[contenteditable="true"]').blur();
		});
	});
});
