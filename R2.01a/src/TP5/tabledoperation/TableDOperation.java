package TP5.tabledoperation;

import java.util.ArrayList;
import java.util.logging.Logger;

import TP5.TestLogging;

public class TableDOperation {
	private static Logger LOGGER = Logger.getLogger(TestLogging.class.getPackageName());
	final short NUMBER_OF_OPERATIONS = 5;
	private operationEnum typeOperation;
	private final ArrayList<Operation> operations = new ArrayList<>();

	public TableDOperation(operationEnum typeOperation) {
		this.typeOperation = typeOperation;
		initialisation();
	}

	private void initialisation() {
		for (int i = 0; i < NUMBER_OF_OPERATIONS; i++) {
			final double terme1 = (Math.round((Math.random() * 10) * 100)) / 100;
			final double terme2 = (Math.round((Math.random() * 10) * 100)) / 100;
			if (typeOperation == operationEnum.ADDITION) {
				LOGGER.info("Type d'operation : Addition");
				operations.add(new Addition(terme1, terme2));
			} else if (typeOperation == operationEnum.SOUSTRACTION) {
				LOGGER.info("Type d'operation : Soustraction");
				operations.add(new Soustraction(terme1, terme2));
			} else if (typeOperation == operationEnum.MULTIPLICATION) {
				LOGGER.info("Type d'operation : Multiplication");
				operations.add(new Multiplication(terme1, terme2));
			}
			LOGGER.info("Terme 1 : " + terme1 + " Terme 2 : " + terme2);
		}

	}

	public int getNombreReponsesJustes() {
		int nbTrue = 0;
		for (Operation operation : operations) {
			if (operation.isReponseJuste()) {
				LOGGER.info("Reponse juste");
				nbTrue++;
			} else {
				LOGGER.info("Reponse fausse");

			}
		}
		return nbTrue;
	}

	public int getNombreDOperations() {
		return operations.size();
	}

	public Operation getOperation(int index) {
		return operations.get(index);
	}
}
