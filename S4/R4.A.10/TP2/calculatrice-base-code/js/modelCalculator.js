// Import des boutons éditables
import { EditableButton } from "./modelEditableButton.js";

/**
 * Classe Calculator.
 * (Modèle représentant la calculatrice)
 */
export class Calculator {
  /**
   * Expression actuelle de la calculatrice.
   * @type {string}
   */
  _input;

  /**
   * Mémoire de la calculatrice.
   * @type {{string|null}}
   */
  _memory;

  /**
   * Objet littéral contenant les boutons éditables de la calculatrice.
   * (Clé = ID du bouton, Valeur = Objet EditableButton associé)
   * @type {Object}
   */
  _editableButtons;

  /**
   * Constructeur de la classe Calculator.
   * @param {Object} editableBtns : Informations sur les boutons éditables.
   */
  constructor(editableBtns) {
    this._input = "";
    this._memory = null;

    // Initialisation des boutons éditables
    // (avec un ID qui commence par "libre" suivi d'un chiffre)
    this._editableButtons = {};
    for (let key in editableBtns) {
      let btn = new EditableButton(key, editableBtns[key]);
      this._editableButtons[key] = btn;
    }
  }

  /**
   * Retourne l'expression actuelle de la calculatrice.
   * @returns {string}
   */
  getInput() {
    return this._input;
  }

  /**
   * Met à jour l'expression actuelle de la calculatrice.
   * @param {string} expr : Nouvelle expression
   */
  setInput(expr) {
    this._input = expr;
  }

  /**
   * Vide l'entrée de la calculatrice.
   */
  clearInput() {
    this._input = "";
  }

  /**
   * Retourne la liste des IDs des boutons éditables.
   * @returns {Array} La liste des IDs des boutons éditables (une liste de chaînes de caractères).
   */
  getIdsEditablesButtons() {
    return Object.keys(this._editableButtons);
  }

  /**
   * Retourne la valeur d'un bouton éditable.
   * @param {string} idBtn : ID du bouton éditable.
   * @returns {string} La valeur du bouton éditable (ou null, si le bouton n'existe pas).
   */
  getValueEditableButton(idBtn) {
    if (this._editableButtons[idBtn]) {
      return this._editableButtons[idBtn].getValue();
    } else {
      return null;
    }
  }

  clearMemory() {
    this._memory = null;
  }

  recallMemory() {
    return this._memory;
  }

  setMemory(val) {
    this._memory = val;
  }
}
