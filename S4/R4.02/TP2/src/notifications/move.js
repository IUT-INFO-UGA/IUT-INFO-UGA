import Notification from './notification.js';

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

export default MoveNotification;
