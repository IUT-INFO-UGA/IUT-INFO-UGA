/**
 * Personnage d'un RPG.
 * @constructor
 * @param {?Object} options - un objet de configuration potentiellement vide.
 */
const Character = function (options) {
  options = options || {};

  /**
   * Nom du caractère.
   * @type {string}
   */
  this.name = options.name || 'John doe';

  /**
   * Genre du caractère : 'male' ou 'female'.
   * @type {string}
   */
  this.gender = options.gender || 'male';

  /**
   * Rangée sur la carte sur laquelle réside le personnage.
   * Les rangées sont indexées à partir de la valeur 1.
   * @type {number}
   */
  this.row = options.row || 1;

  /**
   * Colonne sur la carte sur laquelle réside le personnage.
   * Les colonnes sont indexées à partir de la valeur 1.
   * @type {number}
   */
  this.col = options.col || 1;
};

module.exports = Character;
