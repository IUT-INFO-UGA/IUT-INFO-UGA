/**
 * Arc d'un graphe.
 * @param {?Object} options - un objet de configuration potentiellement vide.
 * @constructor
 */
const Arc = function (options) {
  options = options || {};

  /**
   * Nom de l'arc.
   * @type {string}
   */
  this.name = options.name;

  /**
   * Noeuds source de cet arc.
   * @type {Node}
   */
  this.source = options.source;

  /**
   * Noeuds cible de cet arc.
   * @type {Node}
   */
  this.target = options.target;

  /**
   * Le poids de l'arc.
   * Par défaut, tous les arcs ont un poids de 1.
   * @type {number}
   * @default 1
   */
  this.weight = options.weight || 1;
};

module.exports = Arc;
