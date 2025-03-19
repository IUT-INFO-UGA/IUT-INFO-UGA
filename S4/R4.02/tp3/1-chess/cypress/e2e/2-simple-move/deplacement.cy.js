import game from '../../../games/game';

describe('Move a piece on all chessboard', () => {
	beforeEach(() => {
		cy.visit('http://localhost:8090/web/');
	});

	describe('#move and #capture', function () {
		it('piece should exist', () => {
			game.forEach(action => {
				if (action.type === 'move') {
					cy.get(
						`#chessboard .rank:nth-child(${9 - action.from.rank}) div:nth-child(${action.from.file})`
					).click();
					cy.get(
						`#chessboard .rank:nth-child(${9 - action.to.rank}) div:nth-child(${action.to.file})`
					).click();
					cy.get(
						`#chessboard .rank:nth-child(${9 - action.to.rank}) div:nth-child(${action.to.file})`
					).should('not.have.class', 'active');
				} else {
				}
			});
		});
	});
});
