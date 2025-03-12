/**
 * Classe EditableButton.
 * (Modèle représentant un bouton éditable de la calculatrice)
 */
export class EditableButton {
  /**
   * ID du bouton.
   * @type {string}
   */
  _id;

  /**
   * Valeur actuelle du bouton.
   * @type {string}
   */
  _value;

  /**
   * Constructeur de la classe EditableButton.
   * @param {string} id : ID du bouton
   * @param {string} value : Valeur initiale du bouton
   */
  constructor(id, value) {
    this._id = id;
    this._value = value;
  }

  /**
   * Retourne la valeur du bouton.
   * @returns {string} Valeur du bouton
   */
  getValue() {
    return this._value;
  }

  /**
   * Met à jour la valeur du bouton.
   * @param {string} value : Nouvelle valeur
   */
  setValue(value) {
    this._value = value;
  }
}
