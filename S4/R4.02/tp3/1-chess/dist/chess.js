/**
 * Piece color.
 * @enum
 */
const Color = {
  WHITE: 'white',
  BLACK: 'black'
};

/**
 * Notification namespace.
 * @namespace notification
 */

/**
 * Notification class.
 * @class
 */
class Notification {
  /**
   * Notification constructor.
   * @abstract
   * @memberof notification
   * @constructor
   */
  constructor() {}
}

/**
 * CaptureNotification class.
 * @extends Notification
 * @class
 */
class CaptureNotification extends Notification {
  /**
   * CaptureNotification constructor.
   * @param {?Object} options - an optional list of options.
   * @memberof notification
   * @constructor
   */
  constructor(options) {
    options = options || {};
    super(options);

    /**
     * The position of the piece being captured.
     * @type {Object}
     */
    this.pos = options.pos || {
      rank: 1,
      file: 1
    };
  }
}

/**
 * MoveNotification class.
 * @extends Notification
 * @class
 */
class MoveNotification extends Notification {
  /**
   * MoveNotification constructor.
   * @memberof notification
   * @param {?Object} options - an optional list of options.
   * @constructor
   */
  constructor(options) {
    options = options || {};
    super(options);

    /**
     * The piece position before moving.
     * @type {Object}
     */
    this.oldPosition = options.oldPosition || {
      rank: 1,
      file: 1
    };

    /**
     * The piece position after moving.
     * @type {Object}
     */
    this.newPosition = options.newPosition || {
      rank: 1,
      file: 1
    };
  }
}

/**
 * Piece class.
 * @extends Piece
 * @class
 */
class Piece {
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

/**
 * Pawn class.
 * @class
 * @extends Piece
 */
class Pawn extends Piece {
  /**
   * Pawn constructor. A pawn ahs specific movement.
   * @param {!Object} options - a non-null list of options.
   * @constructor
   */
  constructor(options) {
    super(options);
  }

  /**
   * Check if the pawn is located at its initial position.
   * @return {boolean} <code>true</code> if the pawn is in its initial position, <code>false</code> otherwise.
   */
  isInInitialPosition() {
    return (
      (this.color === Color.WHITE && this.rank === 2) ||
      (this.color === Color.BLACK && this.rank === 7)
    );
  }

  /**
   * Whether a pawn can move at a given rank and file.
   *
   * @override
   * @param {number} rank - the rank on the chessboard.
   * @param {number} file - the file on the chessboard.
   * @return {boolean} <code>true</code> if the piece can move, <code>false</code> otherwise.
   */
  canMove(rank, file) {
    if (!super.canMove(rank, file)) {
      return false;
    }

    const delta = {
      rank: Math.abs(this.rank - rank),
      file: Math.abs(this.file - file)
    };

    const isGoingUp = rank - this.rank > 0;

    // In any case a pawn cannot move more than 2 cases vertically
    // and one case horizontally
    if (delta.rank > 2 || delta.file > 1) {
      return false;
    }

    // A pawn can move forward two cells
    // if it lies in its initial position
    if (delta.rank === 2 && !this.isInInitialPosition()) {
      return false;
    }

    // A white pawn "goes up" the chessboard
    if (this.color === Color.WHITE && !isGoingUp) {
      return false;
    }

    // A black pawn "goes down" the chessboard
    if (this.color === Color.BLACK && isGoingUp) {
      return false;
    }

    // A pawn only goes diagonally when it captures an opponnent piece
    if (
      (delta.rank === delta.file && !this.canCapture(rank, file)) ||
      (delta.file === 0 && this.canCapture(rank, file))
    ) {
      return false;
    }

    return true;
  }
}

/**
 * Bishop class.
 * @extends Piece
 * @class
 */
class Bishop extends Piece {
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

/**
 * Rook class.
 * @class
 * @extends Piece
 */
class Rook extends Piece {
  /**
   * Rook constructor. A rook can move horizontally or diagonally.
   * @param {!Object} options - a non-null list of options.
   * @constructor
   */
  constructor(options) {
    super(options);
  }

  /**
   * Whether a rook can move at a given rank and file.
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

    // Moving horizontally or vertically
    if (
      (delta.rank === 0 && delta.file !== 0) || // Vertical
      (delta.rank !== 0 && delta.file === 0) // Horizontal
    ) {
      return super.canMove(rank, file);
    }

    return false;
  }
}

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
    ].forEach((data) => {
      const { rank, color } = data;

      [
        'Rook',
        'Knight',
        'Bishop',
        'Queen',
        'King',
        'Bishop',
        'Knight',
        'Rook'
      ].forEach((Piece, file) => {
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

var index = {
  Color: Color,
  Queen: Queen,
  King: King,
  Pawn: Pawn,
  Bishop: Bishop,
  Knight: Knight,
  Rook: Rook,
  notifications: {
    CaptureNotification: CaptureNotification,
    MoveNotification: MoveNotification
  },
  Chessboard: Chessboard
};

export { index as default };
