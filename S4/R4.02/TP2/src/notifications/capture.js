import Notification from './notification.js';

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

export default CaptureNotification;
