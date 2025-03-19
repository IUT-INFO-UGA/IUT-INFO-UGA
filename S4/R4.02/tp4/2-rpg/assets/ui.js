(function () {
  /**
   * Nombre de tuiles distribuées horizontalement et verticalement
   * @type {number}
   */
  const tileNb = 17;

  /**
   * Taille d'une tuile en px.
   * @type {number}
   */
  const tileW = 32;

  /**
   * Carte du monde.
   * @type {Map}
   */
  const map = new rpg.Map();

  /**
   * Élément DOM de la carte du monde.
   * @type {HTMLDivElement}
   */
  const mapContainer = document.getElementById('map');

  /**
   * Personnage.
   * @type {Character}
   */
  const character = new rpg.Character({
    row: 2,
    col: 1
  });

  // Ajout du personnage à la carte
  map.character = character;

  /**
   * Élément DOM du personnage.
   * @type {HTMLDivElement}
   */
  const characterElement = document.getElementById('character');

  /**
   * Filtre placée sous une fenêtre modale obscurant le reste de la page.
   * @type {HTMLDivElement}
   */
  const overlay = document.getElementById('overlay');

  /**
   * Fenêtre modale affichant les crédits.
   * @type {HTMLDivElement}
   */
  const creditModal = document.getElementById('credit-modal');

  /**
   * Bouton d'ouverture de la fenêtre modale affichant les crédits.
   * @type {HTMLButtonElement}
   */
  const creditBtn = document.getElementById('credit-btn');

  /**
   * Fenêtre modale affichant l'édition de nom.
   * @type {HTMLDivElement}
   */
  const editModal = document.getElementById('edit-modal');

  /**
   * Bouton d'ouverture de la fenêtre modale affichant l'édition de nom.
   * @type {HTMLButtonElement}
   */
  const editBtn = document.getElementById('edit-btn');

  /**
   * Bouton de sauvegarde de l'édition de nom.
   * @type {HTMLButtonElement}
   */
  const saveBtn = document.getElementById('save-btn');

  /**
   * Champ de texte permettant l'édition du nom dans la fenêtre modale
   * @type {HTMLInputElement}
   */
  const nameInput = document.getElementById('name-input');

  /**
   * Champ permettant l'affichage du nom dans la vue principale.
   * @type {HTMLOutputElement}
   */
  const nameOutput = document.getElementById('name-output');

  /**
   * Champ affichant le nombre restant de points dans la vue principale.
   * @type {HTMLOutputElement}
   */
  const pointsOutput = document.getElementById('points-output');

  // On initialise les valeurs par défaut du nom du personnage
  nameInput.value = character.name;
  nameOutput.innerText = character.name;

  /********************************
   * GESTION DES FENÊTRES MODALES *
   ********************************/

  /**
   * Permet l'ouverture d'une fenêtre modale passée en paramètre.
   * @param {HTMLDivElement} modal - la fenêtre modale à ouvrir.
   */
  const openModal = function (modal) {
    overlay.classList.remove('hide');
    modal.classList.remove('hide');
  };

  /**
   * Permet la fermeture d'une fenêtre modale passée en paramètre.
   * Si aucune fenêtre n'est passée en paramètre, tente de fermeture
   * toutes les fenêtres modales encore ouvertes.
   * @param {HTMLDivElement} modal - la fenêtre modale à fermer.
   */
  const closeModal = function (modal) {
    overlay.classList.add('hide');
    if (modal) {
      modal.classList.add('hide');
    }
  };

  // Pour chaque fenêtre modal, au clic sur le bouton de fermeture, fermer
  // la fenêtre modale correspondante
  document.querySelectorAll('.modal').forEach((modal) => {
    modal.querySelector('.close').addEventListener('click', (e) => {
      e.preventDefault();
      closeModal(e.currentTarget.parentNode);
    });
  });

  // Au clic sur le filtre à l'arrière d'une fenêtre modale, fermer la
  // fenêtre modale courante
  document.getElementById('overlay').addEventListener('click', (e) => {
    e.preventDefault();
    closeModal(document.querySelector('.modal:not(.hide)'));
  });

  // Au clic sur le bouton de crédit, ouvrir la fenêtre modale correspondante
  creditBtn.addEventListener('click', (e) => {
    e.preventDefault();
    openModal(creditModal);
  });

  // Au clic sur le bouton d'édition de nom, ouvrir la fenêtre modale correspondante
  editBtn.addEventListener('click', (e) => {
    e.preventDefault();
    openModal(editModal);
    nameInput.focus(); // Donne le focus sur le champ texte
    nameInput.select(); // Sélectionne le contenu
    // Désactive le bouton tant qu'aucune modification n'ait été faite
    saveBtn.setAttribute('disabled', 'disabled');
  });

  /*******************************
   * GESTION DE L'ÉDITION DU NOM *
   *******************************/

  // Au clic sur le bouton de sauverage du nom, le modifier
  saveBtn.addEventListener('click', (e) => {
    e.preventDefault();

    // Affiche le nom dans la vue principale
    nameOutput.innerText = nameInput.value;

    // Enregistre la référence dans le personnage
    character.name = nameInput.value;

    // Désactive le bouton tant qu'aucune nouvelle modification n'ait été faite
    saveBtn.setAttribute('disabled', 'disabled');
  });

  // Dès qu'une modification du nom intervient, vérification de la valeur.
  // et désactivation du bouton de sauverage si la valeur est inchangée ou vide.
  // activation du bouton de sauverage dans le cas contraire.
  nameInput.addEventListener('input', (e) => {
    const value = e.currentTarget.value;
    if (value === '' || value === character.name) {
      saveBtn.setAttribute('disabled', 'disabled');
    } else {
      saveBtn.removeAttribute('disabled');
    }
  });

  /******************************************
   * GESTION DES POINTS DE CARACTÉRISTIQUES *
   ******************************************/

  /**
   * Permet de remettre un point dans le total des points non utilisés.
   * Lorsqu'un point est remis dans le total des points, activer les boutons + de
   * chaque caractéristique du personnage afin de permettre de réattribuer ce point.
   */
  const addPointToTotal = function () {
    const points = parseInt(pointsOutput.innerText);
    pointsOutput.innerText = points + 1;
    document
      .getElementById('points-container')
      .querySelectorAll('div.point button:last-of-type')
      .forEach((addBtn) => addBtn.removeAttribute('disabled'));
  };

  /**
   * Permet de retirer un point du le total des points non utilisés.
   * Cette fonction ne fait rien s'il n'y a plus de point disponible.
   * Si le total des points tombe à 0 après avoir retiré, désactiver
   * les boutons + de chaque caractéristique du personnage.
   */
  const removePointFromTotal = function () {
    const points = parseInt(pointsOutput.innerText);

    if (points === 0) return;

    pointsOutput.innerText = points - 1;

    if (points - 1 === 0) {
      document
        .getElementById('points-container')
        .querySelectorAll('div.point button:last-of-type')
        .forEach((addBtn) => addBtn.setAttribute('disabled', 'disabled'));
    }
  };

  // Gestion des boutons + et - pour attribuer / désattribuer les points
  // aux caractéristiques du personnage
  document
    .getElementById('points-container')
    .querySelectorAll('div.point')
    .forEach((container) => {
      const removeBtn = container.querySelector('button:first-of-type'),
        addBtn = container.querySelector('button:last-of-type');

      removeBtn.setAttribute('disabled', 'disabled');
      addBtn.removeAttribute('disabled');

      const output = container.querySelector('output');

      removeBtn.addEventListener('click', (e) => {
        output.innerText = parseInt(output.innerText) - 1;
        addBtn.removeAttribute('disabled');
        addPointToTotal();

        if (parseInt(output.innerText) === 0) {
          removeBtn.setAttribute('disabled', 'disabled');
        }
      });

      addBtn.addEventListener('click', (e) => {
        output.innerText = parseInt(output.innerText) + 1;
        removeBtn.removeAttribute('disabled');
        removePointFromTotal();
      });
    });

  /******************************************
   * GESTION DES POINTS DE CARACTÉRISTIQUES *
   ******************************************/

  /**
   * Permet de positionner le personnage à un emplacement sur la carte.
   * Oriente le personnage selon la direction suivie.
   * Une animation CSS permet de simuler le mouvement du personnage.
   * @param {number} row - rangée sur la carte (indexée à partir de 1).
   * @param {number} col - colonne sur la carte (indexée à partir de 1).
   */
  const put = function (row, col) {
    const x = mapContainer.offsetLeft + tileW * (col - 1),
      y = mapContainer.offsetTop + tileW * (row - 1);

    const currentRow = character.row,
      currentCol = character.col;

    if (row < currentRow) {
      // up
      characterElement.classList.add('up');
      characterElement.classList.remove('down');
      characterElement.classList.remove('left');
      characterElement.classList.remove('right');
    } else if (row > currentRow) {
      // down
      characterElement.classList.remove('up');
      characterElement.classList.add('down');
      characterElement.classList.remove('left');
      characterElement.classList.remove('right');
    } else if (col < currentCol) {
      // left
      characterElement.classList.remove('up');
      characterElement.classList.remove('down');
      characterElement.classList.add('left');
      characterElement.classList.remove('right');
    } else if (col > currentCol) {
      // right
      characterElement.classList.remove('up');
      characterElement.classList.remove('down');
      characterElement.classList.remove('left');
      characterElement.classList.add('right');
    }

    characterElement.style.left = x + 'px';
    characterElement.style.top = y + 'px';

    character.row = row;
    character.col = col;
  };

  /**
   * Permet de déplacer le personnage suivant un chemin prédéfini.
   * @param {Array.<Object>} path - un chemin composé de différents segments verticaux et horizontaux.
   */
  const move = function (path) {
    if (Array.isArray(path)) {
      if (!path.length) {
        characterElement.classList.remove('running');
        mapContainer.classList.remove('frozen');
      } else {
        characterElement.classList.add('running');
        mapContainer.classList.add('frozen');
        // Get the first movement
        const p = path.shift();

        move(p);
        setTimeout(() => {
          move(path);
        }, 100);
      }
    } else {
      put(path.row, path.col);
    }
  };

  /**
   * Permet de calculer le plus court chemin jusqu'à une tuile particulière.
   * Cette fonction s'appuie sur l'algorithme de Dijkstra.
   * @param {HTMLDivElement} tile - élément DOM représentant une tuile de la carte.
   * @return {Array.<Object>} un tableau potentiellement vide de déplacements.
   */
  const computeShortestPathToTile = function (tile) {
    const row = tile.getAttribute('data-row'),
      col = tile.getAttribute('data-col');

    return map.computeShortestPathTo(row, col);
  };

  /**
   * Fonction de callback lorsqu'une tuile a été sélectionnée par le joueur.
   * @param {MouseEvent} e - événement souris ayant sélectionné une tuile
   */
  const onTileSelected = function (e) {
    // Récupération de la tuile sélectionnée
    const tile = e.currentTarget;

    // Calcul du chemin
    const path = computeShortestPathToTile(tile);

    // Si on ne peut pas se déplacer
    if (!path.length) {
      return;
    }

    // Sinon, on se déplace
    move(path);
  };

  // Récupération des données et création de la carte.
  Promise.all([
    fetch('./data/maps/grass.json'), // fichier contenant les tuiles
    fetch('./data/maps/reachability.json'), // fichier contenant les accès
    fetch('./data/maps/decorations.json') // fichier contenant les décorations
  ]).then((data) => {
    Promise.all([data[0].json(), data[1].json(), data[2].json()]).then(
      (data) => {
        const tiles = data[0],
          reachability = data[1],
          decorations = data[2];

        // Permet d'appeler Dijkstra
        map.computeGraph(reachability);

        // Création du DOM de la carte
        for (let i = 0; i < tileNb; i++) {
          // Création d'une rangée
          const row = document.createElement('div');
          row.classList.add('row');
          mapContainer.appendChild(row);

          for (let j = 0; j < tileNb; j++) {
            const tile = document.createElement('div'),
              decoration = decorations[i][j].trim();

            tile.classList.add('tile');
            tile.setAttribute('data-row', i + 1);
            tile.setAttribute('data-col', j + 1);

            // Si la tuile est accessible
            if (reachability[i][j] > 0) {
              tile.setAttribute('reachable', reachability[i][j]);

              tile.addEventListener('click', onTileSelected);
            }

            if (decoration.length) {
              tile.setAttribute('decoration', decoration);
            }

            if (tiles[i][j]) {
              const name = tiles[i][j].trim();

              tile.classList.add(name);

              // Certaines tuiles sont animées
              ['water', 'sand', 'cliff', 'quaye'].forEach((t) => {
                if (name.includes(t)) {
                  tile.classList.add('animated');
                }
              });
              if (name.includes('waterf')) {
                tile.classList.add('fast');
              }
            }
            row.appendChild(tile);
          }
        }

        // Place le personnage sur la première case
        put(character.row, character.col);
      }
    );
  });
})();
