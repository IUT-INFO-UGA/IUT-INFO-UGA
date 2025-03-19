import Color from './color.js';
import CaptureNotification from './notifications/capture.js';
import MoveNotification from './notifications/move.js';

/**
 * Piece class.
 * @extends Piece
 * @class
 */
export class Piece {
  /**
   * Piece constructor.
   * @param {!Object} options - a non-null list of options.
   * It should contain at least the two following fields: chessboard and id.
   * @abstract
   * @constructor
   */
  constructor(options) {
    /**
     * The chessboard on which the piece is placed.
     * @type {Chessboard}
     */
    this.chessboard = options.chessboard;

    /**
     * A uniq ID used to represent the piece..
     * @type {number}
     */
    this.id = options.id;

    /**
     * The rank (i.e., the row on the chessboard) of the piece.
     * Ranks are 1-indexed.
     * @type {number}
     * @default 1
     */
    this.rank = options.rank || 1;

    /**
     * The file (i.e., the column on the chessboard) of the piece.
     * Files are 1-indexed.
     * @type {number}
     * @default 1
     */
    this.file = options.file || 1;

    /**
     * The color (white or black) of the piece.
     * @type {Color}
     * @default Color.WHITE
     */
    this.color = options.color || Color.WHITE;

    /**
     * Whether the piece can leap other pieces.
     * Only the knight can leap in chess.
     * @type {boolean}
     * @default false
     */
    this.canLeap = options.canLeap || false;

    /**
     * An array of observers that will be notify on any change
     * in the piece state. Supported notifications are so far:
     * any movement or capture of the piece.
     * @type {Array.<Object>}
     * @default empty array
     */
    this.observers = [];
  }

  /**
   * Move a piece at a specific rank and file. Prior to moving,
   * this method calls the <code>canMove</code> method.
   * Yelds move and capture notifications if necessary.
   * @param {number} rank - the target rank.
   * @param {number} file - the target file.
   */
  move(rank, file) {
    if (this.canMove(rank, file)) {
      // Before moving, we check if we can capture a piece
      if (this.canCapture(rank, file)) {
        // If the answer is yes, get a ref to the captured piece and its index.
        const captured = this.chessboard.getPiece(rank, file),
          index = this.chessboard.pieces.indexOf(captured);

        // Remove the piece from the chessboard
        this.chessboard.pieces.splice(index, 1);
        captured.isCaptured = true;
        captured.rank = -1;
        captured.file = -1;

        // Notify observers that the piece has been captured
        captured.update(
          new CaptureNotification({
            pos: {
              rank: rank,
              file: file
            }
          })
        );
      }

      // Store the previous position of the piece to move
      const oldPosition = {
        rank: this.rank,
        file: this.file
      };

      // Store the new position of the piece to move
      const newPosition = {
        rank: rank,
        file: file
      };

      // Actually move the piece
      this.rank = rank;
      this.file = file;

      // Notify observers that the piece have been moved
      this.update(
        new MoveNotification({
          oldPosition: oldPosition,
          newPosition: newPosition
        })
      );
    }
  }

  /* istanbul ignore next : tired of writing some tests */
  /**
   * Subscribe an observer to listen to state changes.
   * This design follows the Observer design pattern.
   * The observer must have a <code>notify(context, notification)</code> callback function.
   * @param {Object} observer - the subscribed observer.
   *
   */
  subscribe(observer) {
    this.observers.push(observer);
  }

  /* istanbul ignore next : tired of writing some tests */
  /**
   * Unsubscribe a previously subscrtibed observer.
   * This design follows the Observer design pattern.
   * @param {Object} observer - the observer to unsubscribe.
   *
   */
  unsubscribe(observer) {
    const index = this.observers.indexOf(observer);
    this.observers.splice(index, 1);
  }

  /* istanbul ignore next : tired of writing some tests */
  /**
   * Notify all observers of any state change.
   * This design follows the Observer design pattern.
   * @param {Notification} notification - the notification to send to the observers.
   *
   */
  update(notification) {
    this.observers.forEach((obs) => obs.notify(this, notification));
  }

  /**
   * Whether a piece can land on a specific cell. A piece can land whether the target cell is free.
   * @param {number} rank - the rank on the chessboard.
   * @param {number} file - the file on the chessboard.
   * @return {boolean} <code>true</code> if the piece can land, <code>false</code> otherwise.
   */
  canLand(rank, file) {
    const piece = this.chessboard.getPiece(rank, file);
    return piece === null;
  }

  /**
   * Whether a piece can capture on a specific cell. A piece can capture whether the target cell is occupied by an opponent piece.
   * @param {number} rank - the rank on the chessboard.
   * @param {number} file - the file on the chessboard.
   * @return {boolean} <code>true</code> if the piece can capture, <code>false</code> otherwise.
   */
  canCapture(rank, file) {
    const piece = this.chessboard.getPiece(rank, file);
    if (piece === null) return false;

    return piece.color !== this.color;
  }

  /**
   * Whether a piece can move at a given rank and file.
   * This method checks general rules applicable to every piece in chess.
   *
   * This method shall be subclassed by concrete pieces to account for their specific movements.
   *
   * @param {number} rank - the rank on the chessboard.
   * @param {number} file - the file on the chessboard.
   * @return {boolean} <code>true</code> if the piece can move, <code>false</code> otherwise.
   */
  canMove(rank, file) {
    // A piece cannot move outside of the chessboard
    if (rank < 1 || rank > 8) return false;
    if (file < 1 || file > 8) return false;

    // If a piece can leap other pieces, then it facilitates the computation.
    if (this.canLeap) {
      return this.canLand(rank, file) || this.canCapture(rank, file);
    }

    // Difference between the current and target locations
    const delta = {
      rank: rank - this.rank,
      file: file - this.file
    };

    // Compute the direction of the movement :
    // +1 to rank (resp. file) means going up (resp. right)
    // -1 to rank (resp. file) means going down (resp. left)
    const direction = {
      rank: delta.rank === 0 ? 0 : delta.rank / Math.abs(delta.rank),
      file: delta.file === 0 ? 0 : delta.file / Math.abs(delta.file)
    };

    // Micro-step of the movement following the direction
    const p = {
      rank: this.rank + direction.rank,
      file: this.file + direction.file
    };

    // If we cannot land nor capture a piece, we cannot move
    if (!this.canLand(rank, file) && !this.canCapture(rank, file)) return false;

    // If the movement is neither vertical, horizontal or diagonal, we cannot move (that does not affect the knight that can leap).
    if (
      !(delta.rank === 0 && delta.file !== 0) && // Vertical
      !(delta.rank !== 0 && delta.file === 0) && // Horizontal
      !(Math.abs(delta.rank) === Math.abs(delta.file)) // Diagonal
    ) {
      return false;
    }

    // As long as the movement is not finished, simulate it by micro-steps. If at some points can no longer land, then stop here.
    while (p.rank !== rank || p.file !== file) {
      if (!this.canLand(p.rank, p.file)) return false;
      p.rank += direction.rank;
      p.file += direction.file;
    }

    return true;
  }
}

export default Piece;
