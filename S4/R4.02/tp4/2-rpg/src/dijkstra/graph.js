/**
 * Graphe sous la forme de noeuds et d'arcs connectant les noeuds.
 * @constructor
 */
const Graph = function () {
  /**
   * Tableau de noeuds du graphe.
   * @type {Array.<Node>}
   */
  this.nodes = [];

  /**
   * Tableau d'arcs du graphe.
   * @type {Array.<Arc>}
   */
  this.arcs = [];
};

module.exports = Graph;
