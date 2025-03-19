import Color from './src/color.js';
import Queen from './src/queen.js';
import King from './src/king.js';
import Pawn from './src/pawn.js';
import Bishop from './src/bishop.js';
import Knight from './src/knight.js';
import Rook from './src/rook.js';
import CaptureNotification from './src/notifications/capture.js';
import MoveNotification from './src/notifications/move.js';
import Chessboard from './src/chessboard.js';

export default {
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
