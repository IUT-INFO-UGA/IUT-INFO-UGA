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
