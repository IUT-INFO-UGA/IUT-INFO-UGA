(function(f){if(typeof exports==="object"&&typeof module!=="undefined"){module.exports=f()}else if(typeof define==="function"&&define.amd){define([],f)}else{var g;if(typeof window!=="undefined"){g=window}else if(typeof global!=="undefined"){g=global}else if(typeof self!=="undefined"){g=self}else{g=this}g.rpg = f()}})(function(){var define,module,exports;return (function(){function r(e,n,t){function o(i,f){if(!n[i]){if(!e[i]){var c="function"==typeof require&&require;if(!f&&c)return c(i,!0);if(u)return u(i,!0);var a=new Error("Cannot find module '"+i+"'");throw a.code="MODULE_NOT_FOUND",a}var p=n[i]={exports:{}};e[i][0].call(p.exports,function(r){var n=e[i][1][r];return o(n||r)},p,p.exports,r,e,n,t)}return n[i].exports}for(var u="function"==typeof require&&require,i=0;i<t.length;i++)o(t[i]);return o}return r})()({1:[function(require,module,exports){
const Map = require('./src/map.js');
const Character = require('./src/character.js');

const rpg = {
  Map: Map,
  Character: Character
};

module.exports = rpg;

},{"./src/character.js":2,"./src/map.js":7}],2:[function(require,module,exports){
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

},{}],3:[function(require,module,exports){
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

},{}],4:[function(require,module,exports){
/**
 * Fonction permettant d'initialiser le graph initial.
 * @param {Graph} g - le graph initial.
 * @param {Node} start - le noeud de départ.
 * @private
 */
const init = function (g, start) {
  g.nodes // Pour tous les noeuds
    .filter((n) => n !== start) // à l'exception du noeud initial
    .forEach((n) => {
      n.distance = Infinity; // Initialise la distance à infinie
      n.predecessor = null; // Si on a déjà invoqué Dijkstra une première fois, on vide le cache
    });

  start.distance = 0; // La distance du noeud de départ est nulle
  start.predecessor = null; // Si on a déjà invoqué Dijkstra une première fois, on vide le cache
};

/**
 * Cette fonction recherche le noeud dont la distance est minimale et le retourne.
 * @param {Array.<Node>} nodes - un tableau de noeuds.
 * @return {Node} le noeud ayant la plus petite distance.
 * @private
 */
const findMin = function (nodes) {
  // On classe les noeuds selon leur distance et on retourne le premier noeud
  return nodes.sort((n1, n2) => {
    if (n1.distance === n2.distance && n1.distance === Infinity) {
      return 0;
    }
    return n1.distance > n2.distance ? 1 : -1;
  })[0];
};

/**
 * Cette fonction met à jour la distance entre un noeud n et son voisin.
 * @param {Node} n - le noeud source.
 * @param {Node} neighbour - le voisin du noeud source.
 * @param {Arc} arc - l'arc reliant le noeud souce et son voisin.
 * @private
 */
const updateDistance = function (n, neighbour, arc) {
  if (neighbour.distance > n.distance + arc.weight) {
    // Si la distance de neighbour est supérieure à celle de n et du poids de l'arc
    neighbour.distance = n.distance + arc.weight; // On prend ce nouveau chemin qui est plus court
    neighbour.predecessor = n; // On note par où on passe.
  }
};

/**
 * Fonction principale de dijkstra.
 * Commence par initialiser le graph g, puis parcourt les noeuds par ordre de distance et recalcule la distance de chaque noeud.
 * @private
 */
const dijkstra = function (g, start) {
  init(g, start); // Initialisation des distances

  const nodes = g.nodes.slice(0); // Ensemble de tous les noeuds.
  // La fonction slice permet de faire une copie du tableau (et non une référence vers ce tableau, sinon on risque de vider le graphe G de ses noeuds)

  while (nodes.length) {
    const n = findMin(nodes); // Recherche du noeud de plus faible distance
    nodes.splice(nodes.indexOf(n), 1); // On retire le noeud du tableau

    n.arcs.forEach((arc) => {
      // Pour chaque arc
      // On récupère le voisin de n
      const neighbour = arc.source === n ? arc.target : arc.source;
      // On met si besoin à jour la valeur de la distance du voisin
      updateDistance(n, neighbour, arc);
    });
  }

  return g;
};

/**
 * Calcule le plus court chemin à partir d'un noeud start pour atteindre un noeud end.
 * Si le noeud end n'est pas atteingable depuis le noeud start, retourne un chemin vide.
 * @param {Graph} g - le graph sur lequele le plus court chemin est calculé.
 * @param {Node} start - le noeud de départ.
 * @param {Node} end - le noeud d'arrivée.
 * @return {Array.<Node>} un chemin non vide si le noeud end est atteignable depuis start, vide s'il ne l'est pas.
 */
const computeShortestPath = function (g, start, end) {
  dijkstra(g, start); // Invocation de la fonction de dijkstra pour calculer les distances sur chaque noeud

  const shortestPath = []; // Initialisation du plus court chemin à un tableau vide

  if (!end.predecessor) return shortestPath; // Si on a pas de possibilité de trouver un pedécesseur à end, alors cela signifie que le noeud end n'est pas atteignable depuis le noeud start. Dans ce cas-là, on retourne le tableau vide.

  let node = end; // on enregistre la référence du noeud final

  do {
    shortestPath.unshift(node);
    node = node.predecessor;
  } while (node !== start); // tant que ce noeud est différent du noeud initial

  return shortestPath;
};

module.exports = computeShortestPath;

},{}],5:[function(require,module,exports){
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

},{}],6:[function(require,module,exports){
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

},{}],7:[function(require,module,exports){
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

},{"./dijkstra/arc.js":3,"./dijkstra/dijkstra.js":4,"./dijkstra/graph.js":5,"./dijkstra/node.js":6}]},{},[1])(1)
});
