const Graph = require('./dijkstra/graph.js');
const Node = require('./dijkstra/node.js');
const Arc = require('./dijkstra/arc.js');
const computeShortestPath = require('./dijkstra/dijkstra.js');

/**
 * Carte du monde.
 * @constructor
 */
const Map = function () {
  /**
   * Représentation de la carte sous la forme d'un graphe non orienté.
   * Cette représentation est nécessaire pour le calcul du plus court chemin entre un point et un autre.
   * @type {Graph}
   */
  this.graph = null;

  /**
   * Ensemble de noeuds du graphe sous la forme d'un tableau à deux dimensions.
   * @type {Array.<Array.<Node>>}
   */
  this.nodes = null;
};

/**
 * Construit un graphe non orienté à partir d'un tableau deux dimensions représentants les tuiles accessibles
 * et non accessibles de la carte.
 * Cette fonction prend en paramètre un tableau deux dimensions de même taille que le tableau de tuiles. Chaque
 * donnée du tableau est un entier positif ou nul. Une valeur nulle indique que la tuile n'est pas accessible.
 * Une valeur non-nulle indique le nombre de mouvements nécessaires pour accéder à une tuile à partir d'une tuile
 * voisine.
 * @param {Array.<Array.<number>>} data - tableau de données.
 */
Map.prototype.computeGraph = function (data) {
  // Création du graphe nécessaire à l'algorithme de Dijkstra
  const graph = new Graph();

  // Création d'un tableau deux-dimensions pour facilement récupérer les références des noeuds
  // Ce tableau est nécessaire pour la création des arcs.
  const nodes = [];

  // Création des noeuds
  for (let i = 0; i < data.length; i++) {
    const row = data[i];

    nodes.push([]);

    for (let j = 0; j < row.length; j++) {
      // Création du noeud
      const node = new Node({
        name: 'node-' + (i + 1) + '-' + (j + 1),
        row: i + 1,
        col: j + 1
      });

      // Ajout du noeud dans le graphe
      graph.nodes.push(node);

      // Enregistrement de la référence du noeud pour créer les arcs ultérieurement
      nodes[i].push(node);
    }
  }

  // Création des arcs
  for (let i = 0; i < data.length; i++) {
    const row = data[i];

    for (let j = 0; j < row.length; j++) {
      if (row[j] === 0) {
        // le noeud n'est pas atteignable
        continue;
      }

      // Récupération de la référence du noeud
      const node = nodes[i][j];

      // Pour chaque voisin (4 au total) du noeud, on créé un arc
      [
        [-1, 0], // Offset du noeud voisin haut
        [0, 1], // Offset du noeud voisin droite
        [1, 0], // Offset du noeud voisin bas
        [0, -1] // Offset du noeud voisin gauche
      ].forEach((offset) => {
        const k = i + offset[0],
          l = j + offset[1];

        if (k < 0 || l < 0) return;

        if (k >= data.length || l >= data[i].length) return;

        // Le noeud voisin n'est pas atteignable
        if (data[k][l] === 0) {
          return;
        }

        // Récupération du voisin
        const neighbour = nodes[i + offset[0]][j + offset[1]];

        // Recherche d'un arc avec ce même nom
        const match = node.arcs.filter((arc) => {
          return (
            (arc.source === node && arc.target === neighbour) ||
            (arc.target === node && arc.source === neighbour)
          );
        });
        if (match.length) {
          // On ne recréé par un doublon
          return;
        }

        // Création de l'arc.
        // Le poids correspond à la plus grande valeur pour accéder au noeud ou à son voisin.
        const arc = new Arc({
          name: `arc-between-${i + 1}-${j + 1}-and-${k + 1}-${l + 1}`,
          weight: Math.max(row[j], data[k][l]),
          source: node,
          target: neighbour
        });

        node.arcs.push(arc);
        neighbour.arcs.push(arc);

        // Ajout du arc dans le graphe
        graph.arcs.push(arc);
      });
    }
  }

  this.graph = graph;
  this.nodes = nodes;
};

/**
 * Calcule le plus court chemin pour déplacer le personnage de la tuile actuelle vers la tuile définie par
 * les paramètres row et col. Cette function retourne un tableau potentiellement vide si le mouvement n'est
 * pas possible. Si le tableau est non-vide, il contient un ensemble de mouvement atomique.
 * @param {number} row - la rangée sur la carte.
 * @param {number} col - la colonne sur la carte.
 * @return {Array.<Object>} un chemin composé de différents segments verticaux et horizontaux.
 */
Map.prototype.computeShortestPathTo = function (row, col) {
  // Récupère le noeud initial
  const start = this.nodes[this.character.row - 1][this.character.col - 1];

  // Récupère le noeud final
  const end = this.nodes[row - 1][col - 1];

  // Exécute l'algorithme de Dijkstra et retourne le résultat
  return computeShortestPath(this.graph, start, end);
};

module.exports = Map;
