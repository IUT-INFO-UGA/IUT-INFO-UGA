// Import des modules nécessaires
import { Calculator } from './modelCalculator.js';
import { view } from './view.js';

// ### Initialisation du modèle ###
// (à partir du contenu des boutons éditables)
const editableBtnsInfos = {
	libre1: '%',
	libre2: '',
	libre3: '',
	libre4: '',
	libre5: '',
	libre6: ''
};
let calculator = new Calculator(editableBtnsInfos);
calculator.retrieveStateFromClient();

/* (La vue est un objet importé du module view.js) */

// ### Initialisation de l'affichage des boutons éditables ###
for (let key of calculator.getIdsEditablesButtons()) {
	// La clé de l'objet correspond à un ID de bouton dans la page
	let btnElt = document.getElementById(key);
	// Si le bouton existe bien, on met à jour sa valeur affichée
	if (btnElt) {
		btnElt.value = calculator.getValueEditableButton(key);
	}
}

// ### Initialisation des listeners ###
// - Gestion de la saisie au clavier
view.calcInput.addEventListener('keyup', evt => {
	// Informe le modèle du changement
	calculator.setInput(evt.target.value);
	// (La vue n'a pas besoin d'être mis à jour ici)
});

// - Gestion du bouton CE
// (qui vide la champ de la calculatrice)
view.ceBtn.addEventListener('click', function () {
	// Informe le modèle du changement
	calculator.clearInput();
	// Mise à jour de l'affichage
	view.calcInput.value = calculator.getInput();
});

view.backBtn.addEventListener('click', () => {
	calculator.setInput(calculator.getInput().slice(0, -1));
	view.calcInput.value = calculator.getInput();
});

view.numberButtons.forEach(el => {
	el.addEventListener('click', evt => {
		view.calcInput.value += evt.target.value;
		calculator.setInput(view.calcInput.value);
	});
});

view.inverseButton.addEventListener('click', () => {
	if (view.calcInput.value[0] == '-') {
		view.calcInput.value = view.calcInput.value.slice(1, view.calcInput.value.lengh);
	} else {
		view.calcInput.value = '-' + view.calcInput.value;
	}
	//update calculator
	calculator.setInput(view.calcInput.value);
});

view.evalBtn.addEventListener('click', () => {
	// view.calcInput.value = view.calcInput.value.replace(/\b0+(\d+)/g, "$1");
	// view.calcInput.value = new Function(`return ${view.calcInput.value}`)();
	view.calcInput.value = eval(view.calcInput.value);
	calculator.setInput(view.calcInput.value);
});

view.mcBtn.addEventListener('click', () => {
	calculator.clearMemory();
	calculator.saveStateToClient();
});

view.msBtn.addEventListener('click', () => {
	calculator.setMemory(view.calcInput.value);
	calculator.saveStateToClient();
});

view.mrBtn.addEventListener('click', () => {
	view.calcInput.value += calculator.recallMemory();
});

view.isEditable.addEventListener('click', () => {
	view.editableBtn.forEach(e => {
		e.type = view.isEditable.checked ? 'text' : 'button';
	});
});

view.editableBtn.forEach(el => {
	el.addEventListener('click', evt => {
		view.calcInput.value += evt.target.value;
		calculator.setInput(view.calcInput.value);
	});

	el.addEventListener('keyup', evt => {
		calculator.setValueEditableButton(evt.target.id, evt.target.value);
	});
	calculator.saveStateToClient();
});
