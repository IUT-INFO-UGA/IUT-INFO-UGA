import Piece from './piece.js';

/**
 * Knight class.
 * @class
 * @extends Piece
 */
class Knight extends Piece {
  /**
   * Knight constructor. A knight can leap other pieces.
   * @param {!Object} options - a non-null list of options.
   * @constructor
   */
  constructor(options) {
    options.canLeap = true;
    super(options);
  }

  /**
   * Whether a knight can move at a given rank and file.
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

    // Only L-shape movements are possible
    if (
      (delta.rank === 1 && delta.file === 2) ||
      (delta.rank === 2 && delta.file === 1)
    ) {
      return super.canMove(rank, file);
    }

    return false;
  }
}

export default Knight;
