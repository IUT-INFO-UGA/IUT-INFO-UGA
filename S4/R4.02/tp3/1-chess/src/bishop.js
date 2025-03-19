import Piece from './piece.js';

/**
 * Bishop class.
 * @extends Piece
 * @class
 */
export class Bishop extends Piece {
  /**
   * Bishop constructor.
   * @param {!Object} options - a non-null list of options.
   * @constructor
   */
  constructor(options) {
    super(options);
  }

  /**
   * Whether a bishop can move at a given rank and file.
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

    // Diagonal movement
    if (delta.rank !== delta.file) return false;

    return super.canMove(rank, file);
  }
}

export default Bishop;
