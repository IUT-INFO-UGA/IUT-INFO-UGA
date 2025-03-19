/**
 * Noeud d'un graphe.
 * @param {?Object} options - un objet de configuration potentiellement vide.
 * @constructor
 */
const Node = function (options) {
  options = options || {};

  /**
   * Nom du noeud.
   * @type {string}
   */
  this.name = options.name;

  /**
   * Ensemble d'arcs accessibles à partir de ce noeud.
   * @type {Array.<Arc>}
   */
  this.arcs = options.arcs || [];

  /**
   * Rangée du noeud dans la carte.
   * La valeur est indexéee à 1.
   * @type {number}
   */
  this.row = options.row || 0;

  /**
   * Colonne du noeud dans la carte.
   * La valeur est indexéee à 1.
   * @type {number}
   */
  this.col = options.col || 0;

  /**
   * Paramètre utilisé pour le calcul de la distance de Dijkstra.
   * La distance à la somme des poids des arcs empruntés.
   * Par défault, la valeur est l'infinité.
   * @type {number}
   */
  this.distance = options.distance || Infinity;
};

module.exports = Node;
