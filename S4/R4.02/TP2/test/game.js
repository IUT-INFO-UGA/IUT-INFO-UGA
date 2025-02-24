import game from '../games/game.js';
import assert from 'assert';
import Color from '../src/color.js';
import Chessboard from '../src/chessboard.js';
import Pawn from '../src/pawn.js';

/**
 * From a file number, get the corresponding letter.
 * Rank are 1-indexed.
 * Letters are 97-indexed to get lower-alpha characters.
 * @param {number} file - the file in its number representation.
 * @return {string} returns the file in its string representation.
 */
const convertFileToString = function (file) {
	return String.fromCharCode(97 - 1 + file);
};

describe('Game', function () {
	let chessboard;

	before(function () {
		chessboard = new Chessboard();
		chessboard.init();
		console.log(chessboard);
	});

	describe('#move and #capture', function () {
		game.forEach(action => {
			let piece;
			it('piece should exist', () => {
				piece = chessboard.getPiece(action.from.rank, action.from.file);
				assert.notEqual(piece, null);
			});

			if (action.type === 'move') {
				it('piece should can move on new case', () => {
					assert.equal(piece.canMove(action.to.rank, action.to.file), true);
				});

				it('piece should mouve', () => {
					assert.equal(piece.move(action.to.rank, action.to.file), true);
				});
			} else {
			}
		});
	});
});
