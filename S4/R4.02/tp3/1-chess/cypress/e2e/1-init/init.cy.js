import { convertFileToString, game } from '../../support/e2e.js';

describe('Init the chessboard correctly', () => {
  beforeEach(() => {
    cy.visit('http://localhost:8090/web/');
  });

  // Check that the cells of the chessboard alternate in colors
  for (let i = 1; i <= 8; i++) {
    const color = i % 2 ? 'beige' : 'brown',
      colorRGB = i % 2 ? 'rgb(245, 245, 220)' : 'rgb(165, 42, 42)';

    it(`should be a ${color} cell at ${convertFileToString(i)}8`, () => {
      cy.get(`#chessboard .rank:first-child div:nth-child(${i}`).should(
        'have.css',
        'background-color',
        colorRGB
      );
    });
  }

  // Check that the white rook is correctly positionned at a1
  it('should contain a white rook at a1', () => {
    cy.get('#chessboard .rank:last-child div:first-child img')
      .should('exist')
      .invoke('attr', 'src')
      .should('eq', 'assets/img/icons/rook_white.png');
  });

  // Check that the white pawns are correctly positionned at rank 2
  for (let i = 1; i <= 8; i++) {
    it(`should contain a white pawn at ${convertFileToString(i)}2`, () => {
      cy.get(`#chessboard .rank:nth-child(7) div:nth-child(${i}) img`)
        .should('exist')
        .invoke('attr', 'src')
        .should('eq', 'assets/img/icons/pawn_white.png');
    });
  }
});
