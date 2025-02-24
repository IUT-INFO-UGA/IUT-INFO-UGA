import assert from 'assert';
import Color from '../src/color.js';
import Chessboard from '../src/chessboard.js';
import Pawn from '../src/pawn.js';
import Rook from '../src/rook.js';
import Knight from '../src/knight.js';
import Bishop from '../src/bishop.js';
import Queen from '../src/queen.js';
import King from '../src/king.js';

describe('Chessboard', function () {
	let chessboard;

	describe('#init', function () {
		beforeEach(function () {
			chessboard = new Chessboard();
			chessboard.init();
		});

		for (let file = 1; file <= 8; file++) {
			// We convert the numerical form of the file into a alphabetical form
			const fileStr = String.fromCharCode(97 - 1 + file);
			// After init, the central part of the board should be empty
			for (let rank = 3; rank <= 6; rank++) {
				it(`No piece should be present at (${rank}, ${fileStr})`, function () {
					const piece = chessboard.getPiece(rank, file),
						oracle = null;

					assert.equal(piece, oracle);
				});
			}

			// After init, rank 2 should only contain white pawns
			it(`White pawns should be present at (2, ${fileStr})`, function () {
				const piece = chessboard.getPiece(2, file),
					oracle = {
						correctInstance: true,
						correctColor: Color.WHITE
					};

				assert.equal(piece.color, oracle.correctColor);
				assert.equal(piece instanceof Pawn, oracle.correctInstance);
			});

			// After init, rank 7 should only contain black pawns
			it(`Black pawns should be present at (7, ${fileStr})`, function () {
				const piece = chessboard.getPiece(7, file),
					oracle = {
						correctInstance: true,
						correctColor: Color.BLACK
					};

				assert.equal(piece.color, oracle.correctColor);
				assert.equal(piece instanceof Pawn, oracle.correctInstance);
			});
		}

		/**
		 * Objective: Write automated tests to verify the presence of the main pieces
		 * in ranks 1 and 8 and ensure they are of the correct color.
		 *
		 * For example, to verify the presence of the black queen at position
		 * (1, d) (where d = 4), we can write the following code:
		 *
		 * const piece = chessboard.getPiece(1, 4),
		 *  isQueen = piece instanceof Queen;
		 */

		// To automate the tests, the table below is provided
		const Constructors = [Rook, Knight, Bishop, Queen, King, Bishop, Knight, Rook];

		Constructors.forEach((Constructor, i) => {
			// This loop iterates over all the constructors representing
			// each piece in the order they appear in a rank:
			// rank 1 for the white player
			// rank 8 for the black player

			// i represents the index of the constructor in the array of constructors
			// The column (file) on the chessboard can be obtained as follows
			const file = i + 1,
				fileStr = String.fromCharCode(97 - 1 + file);

			// To check the present of white pieces at rank 1:
			it.skip(`White piece ${Constructor.prototype.constructor.name} should be present at (1, ${fileStr})`, function () {
				const rank = 1,
					piece = chessboard.getPiece(rank, file),
					isCorrectInstance = piece instanceof Constructor;

				// To complete
			});
		});
	});
});
