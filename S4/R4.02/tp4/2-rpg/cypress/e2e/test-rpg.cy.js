describe('test-rpg', () => {
	beforeEach(() => {
		cy.visit('http://localhost:8090/');
	});

	it('TF1 : le personnage doit se trouver sur la tuile (2, 1)', function () {
		cy.get('#character').then(character => {
			// On introduit manuellement un délai
			cy.wait(200);

			// On récupère la tuile positionnée à la rangée 2 et colonne 1, puis
			cy.get('#map .row:nth-child(2) .tile:nth-child(1)').then(tile => {
				// On vérifie que la position du personnage correspond exactement
				// à la position de la tuile
				expect(character[0].getBoundingClientRect()).deep.equal(tile[0].getBoundingClientRect());
			});
		});
	});

	it('TF2 : Édition du nom du personnage', () => {
		cy.get('#edit-btn').click();
		cy.wait(200); //wait annimation
		cy.get('#edit-modal').should('be.visible');
		cy.get('#name-input').type('new name');
		cy.get('#save-btn').click();
		cy.get('#edit-modal > .close').click();
		cy.wait(200); //wait annimation
		cy.get('#edit-modal').should('have.class', 'hide');
		cy.get('#name-output').should('have.value', 'new name');
	});

	it('TF3 : (Dés-)attribution de points', () => {
		cy.get('#attack > .borderless-left').click();
		cy.get('#attack-output').should('have.value', 1);
		cy.get('#points-output').should('have.value', 4);
		cy.get('#attack > .borderless-right').click();
		cy.get('#attack-output').should('have.value', 0);
		cy.get('#points-output').should('have.value', 5);
	});

	it('TF4 : Attribution de points au delà de la limite', () => {
		for (let i = 0; i < 5; i++) {
			cy.get('#attack > .borderless-left').click();
		}
		cy.get('#speed > .borderless-left').should('have.attr', 'disabled');
		cy.get('#agility > .borderless-left').should('have.attr', 'disabled');
	});

	it('Déplacement du personnage', () => {
		cy.get('.br-path').click();
		cy.wait(600); //wait annimation
		cy.get('#character').then(character => {
			cy.get('.br-path').then(tile => {
				expect(character[0].getBoundingClientRect()).deep.equal(tile[0].getBoundingClientRect());
			});
		});
	});

	it("TF6 : (non-)déplacement du personnage dans l'océan", () => {
		cy.get(':nth-child(12) > [data-col="5"]').click();
		cy.wait(200);
		cy.get('#character').then(character => {
			cy.get(':nth-child(2) > [data-col="1"]').then(tile => {
				expect(character[0].getBoundingClientRect()).deep.equal(tile[0].getBoundingClientRect());
			});
		});
	});

	it('TF7 : (non-)déplacement du personnage sur une tuile prairie non accessible', () => {
		cy.get(':nth-child(6) > [data-col="1"]').click();
		cy.wait(200);
		cy.get('#character').then(character => {
			cy.get(':nth-child(2) > [data-col="1"]').then(tile => {
				expect(character[0].getBoundingClientRect()).deep.equal(tile[0].getBoundingClientRect());
			});
		});
	});
});
