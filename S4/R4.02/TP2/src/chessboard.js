import Color from './color.js';
import Queen from './queen.js';
import King from './king.js';
import Pawn from './pawn.js';
import Bishop from './bishop.js';
import Knight from './knight.js';
import Rook from './rook.js';

class Chessboard {
	/**
	 * Chessboard constructor.
	 * @constructor
	 */
	constructor() {
		/**
		 * An array containing the different pieces that have not been captured yet.
		 * @type {Array.<Piece>}
		 * @public
		 */
		this.pieces = [];
	}

	/**
	 * Initialize the chessboard.
	 * This function will create the pieces and put them to their corresponding positions.
	 * White pieces are located at the lowest ranks.
	 * Black pieces are located at the uppest ranks.
	 * The queen always starts on a cell corresponding to its color.
	 */
	init() {
		// Empty the array from previous games.
		this.pieces = [];

		const chessPackage = {
			Queen: Queen,
			King: King,
			Bishop: Bishop,
			Rook: Rook,
			Knight: Knight,
			Pawn: Pawn
		};

		// Each piece has a uniq numerical id.
		let id = 0;

		// Initialize the board.
		for (let i = 1; i <= 8; i++) {
			// Put the black pawns on the 7th rank
			const blackPawn = new Pawn({
				rank: 7,
				file: i,
				id: ++id,
				chessboard: this,
				color: Color.BLACK
			});

			this.pieces.push(blackPawn);

			// Put the white pawns on the 2nd rank
			const whitePawn = new Pawn({
				rank: 2,
				file: i,
				id: ++id,
				chessboard: this,
				color: Color.WHITE
			});

			this.pieces.push(whitePawn);
		}

		// Put the other pieces
		[
			{ rank: 1, color: Color.WHITE },
			{ rank: 8, color: Color.BLACK }
		].forEach(data => {
			const { rank, color } = data;

			['Rook', 'Knight', 'Bishop', 'Queen', 'King', 'Bishop', 'Knight', 'Rook'].forEach((Piece, file) => {
				this.pieces.push(
					new chessPackage[Piece]({
						chessboard: this,
						rank: rank,
						id: ++id,
						file: file + 1,
						color: color
					})
				);
			});
		});
	}

	/**
	 * Retrieve a piece at a given rank and file.
	 * @param {number} rank - the rank of the piece.
	 * @param {number} file - the file of the piece.
	 * @return {?Piece} Returns the piece (if any) or <code>null</code> if
	 * no piece is located at the given rank and file.
	 *
	 * @example
	 * // After initializing the board, returns the white rook located at (1, a)
	 * let chessboard = new Chessboard();
	 * chessboard.init();
	 * let piece = this.getPiece(1, 1);
	 */
	getPiece(rank, file) {
		for (let i = 0; i < this.pieces.length; i++) {
			const p = this.pieces[i];
			if (p.rank === rank && p.file === file) {
				return p;
			}
		}
		return null;
	}
}

export default Chessboard;
