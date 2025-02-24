import Piece from './piece.js';

/**
 * King class.
 * @class
 * @extends Piece
 */
class King extends Piece {
  /**
   * King constructor. A king can move in any direction but only one case.
   * @param {!Object} options - a non-null list of options.
   * @constructor
   */
  constructor(options) {
    super(options);
  }

  /**
   * Whether a king can move at a given rank and file.
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

    if (delta.rank > 1 || delta.file > 1) return false;

    return super.canMove(rank, file);
  }
}

export default King;
