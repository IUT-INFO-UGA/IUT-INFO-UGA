import { convertFileToString, game } from '../../support/e2e.js';

describe('Move a piece on the chessboard', () => {
	beforeEach(() => {
		cy.visit('http://localhost:8090/web/');
	});

	it('move a white pawn from c7 to c6', function () {
		cy.get('#chessboard .rank:nth-child(2) div:nth-child(3)').click();

		cy.get('#chessboard .rank:nth-child(2) div:nth-child(3)').should('have.class', 'active');

		cy.get('#chessboard .rank:nth-child(3) div:nth-child(3)').click();

		cy.get('#chessboard .rank:nth-child(2) div:nth-child(3)').should('not.have.class', 'active');
	});
});
