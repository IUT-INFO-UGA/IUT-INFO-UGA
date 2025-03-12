/**
 * Objet constant représentant la vue.
 */
export const view = {
	// Champ de la calculatrice
	calcInput: document.getElementById('zone_affichage'),

	// Bouton CE
	ceBtn: document.querySelector("input[value='CE']"),
	backBtn: document.querySelector('#backspace'),
	parenthesisOpen: document.querySelector('div.ligne_boutons:nth-child(3) > input:nth-child(2)'),
	parenthesisClose: document.querySelector('div.ligne_boutons:nth-child(3) > input:nth-child(3)'),
	division: document.querySelector('div.ligne_boutons:nth-child(3) > input:nth-child(4)'),
	numberButtons: document.querySelectorAll('.bouton_simple'),
	inverseButton: document.querySelector('#plusMinus'),
	evalBtn: document.querySelector("input[value='=']"),
	mcBtn: document.querySelector("input[value='MC']"),
	mrBtn: document.querySelector("input[value='MR']"),
	msBtn: document.querySelector("input[value='MS']"),
	editableBtn: document.querySelectorAll('.bouton_libre'),
	isEditable: document.querySelector('#editionCheckbox')
};
