import Piece from './piece.js';

/**
 * Queen class.
 * @class
 * @extends Piece
 */
class Queen extends Piece {
  /**
   * Queen constructor. A queen can move in any direction.
   * @param {!Object} options - a non-null list of options.
   * @constructor
   */
  constructor(options) {
    super(options);
  }

  /**
   * Whether a queen can move at a given rank and file.
   *
   * @override
   * @param {number} rank - the rank on the chessboard.
   * @param {number} file - the file on the chessboard.
   * @return {boolean} <code>true</code> if the piece can move, <code>false</code> otherwise.
   */
  canMove(rank, file) {
    const delta = {
      rank: Math.abs(this.rank - rank),
      file: Math.abs(this.file - file)
    };

    // Moving horizontally, vertically, or diagonally
    if (
      (delta.rank === 0 && delta.file !== 0) || // Vertical
      (delta.rank !== 0 && delta.file === 0) || // Horizontal
      delta.rank === delta.file // Diagonal
    ) {
      return super.canMove(rank, file);
    }

    return false;
  }
}

export default Queen;
