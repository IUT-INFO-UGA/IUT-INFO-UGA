describe('test-login', () => {
	beforeEach(() => {
		cy.clock();
		cy.visit('http://localhost:8090/');
	});

	it('TF1 : it is possible to log in', () => {
		cy.get('#email-field').type('John.Doe@exemple.com');
		cy.get('#password-field').type('Ab1!5sd');
		cy.get('#login-btn').should('not.have.attr', 'disabled');
	});

	it('TF2 : a confirmation code is required', () => {
		cy.intercept('GET', 'http://localhost:8090/verification', {
			statusCode: 200,
			body: {
				trusted: false,
				ip: '192.168.1.43',
				email: 'John.Doe@exemple.com',
				name: 'John Doe'
			}
		});

		cy.get('#email-field').type('John.Doe@exemple.com');
		cy.get('#password-field').type('Ab1!5sd');
		cy.get('#login-btn').click();
		cy.get('#confirm-modal').should('be.visible');
	});

	it('TF3 : a confirmation code is incorrectly entered', () => {
		cy.intercept('GET', 'http://localhost:8090/verification', {
			statusCode: 200,
			body: {
				trusted: false,
				ip: '192.168.1.43',
				email: 'John.Doe@exemple.com',
				name: 'John Doe'
			}
		});

		cy.get('#email-field').type('John.Doe@exemple.com');
		cy.get('#password-field').type('Ab1!5sd');
		cy.get('#login-btn').click();
		for (let i = 1; i <= 5; i++) {
			cy.get(`#code-group > :nth-child(${i})`).type('aaaa').blur();
			cy.get(`#code-group > :nth-child(${i})`).should('have.value', '');
		}
	});

	it('TF4 : a confirmation code is correctly entered', () => {
		cy.intercept('GET', 'http://localhost:8090/verification', {
			statusCode: 200,
			body: {
				trusted: false,
				ip: '192.168.1.43',
				email: 'John.Doe@exemple.com',
				name: 'John Doe'
			}
		});

		cy.get('#email-field').type('John.Doe@exemple.com');
		cy.get('#password-field').type('Ab1!5sd');
		cy.get('#login-btn').click();
		for (let i = 1; i <= 5; i++) {
			cy.get(`#code-group > :nth-child(${i})`).type('1');
			cy.get(`#code-group > :nth-child(${i})`).should('have.value', '1');
			if (i != 5) cy.get(`#code-group > :nth-child(${i + 1})`).should('have.focus');
		}
		cy.get('#confirm-btn').should('not.have.attr', 'disabled');
	});

	it.only('TF5 : no confirmation e-mail has been received', () => {
		cy.intercept('GET', 'http://localhost:8090/verification', {
			statusCode: 200,
			body: {
				trusted: false,
				ip: '192.168.1.43',
				email: 'John.Doe@exemple.com',
				name: 'John Doe'
			}
		});

		cy.get('#email-field').type('John.Doe@exemple.com');
		cy.get('#password-field').type('Ab1!5sd');
		cy.get('#login-btn').click();
		cy.tick(55_000);
		cy.get('#send-again-btn').should('not.be.disabled');
	});

	it.only('TF6 : a confirmation code has been sent again', () => {
		cy.intercept('GET', 'http://localhost:8090/verification', {
			statusCode: 200,
			body: {
				trusted: false,
				ip: '192.168.1.43',
				email: 'John.Doe@exemple.com',
				name: 'John Doe'
			}
		});

		cy.get('#email-field').type('John.Doe@exemple.com');
		cy.get('#password-field').type('Ab1!5sd');
		cy.get('#login-btn').click();
		cy.get(`#code-group > :nth-child(2)`).type('7');
		cy.tick(55_000);
		cy.get('#send-again-btn').click();
		cy.get('#send-again-btn').should('be.disabled');
		cy.get('#send-again-btn').should('have.text', 'Renvoyer le code reçu (50 secondes)');
		for (let i = 1; i <= 5; i++) {
			cy.get(`#code-group > :nth-child(${i})`).should('have.value', '');
		}
	});
});
