package TP4.tabledemultiplication;

import java.util.ArrayList;

public class TableDeMultiplication {
	private final int nombreTable;
	private final ArrayList<Multiplication> multiplications = new ArrayList<>();

	public TableDeMultiplication(int nombreTable, boolean estMelange) {
		this.nombreTable = nombreTable;
		initialisation(false);
		if (estMelange) {
			melanger();
		}
	}

	public TableDeMultiplication(int nombreTable, boolean estMelange, boolean noError) {
		this.nombreTable = nombreTable;
		initialisation(noError);
		if (estMelange) {
			melanger();
		}
	}

	private void initialisation(boolean noError) {
		for (int i = 1; i <= this.nombreTable; i++) {
			multiplications.add(new Multiplication(nombreTable, i, noError));
		}
	}

	private void melanger() {
		for (int i = 0; i < multiplications.size() / 2; i++) {
			int index = (int) (Math.random() * multiplications.size());
			Multiplication temp = multiplications.get(i);
			multiplications.set(i, multiplications.get(index));
			multiplications.set(index, temp);
		}
	}

	public int getNombreReponsesJustes() {
		int nombreReponsesJustes = 0;
		for (Multiplication multiplication : multiplications) {
			if (multiplication.isReponseJuste()) {
				nombreReponsesJustes++;
			}
		}
		return nombreReponsesJustes;
	}

	public int getNombreDeMultiplications() {
		return multiplications.size();
	}

	public Multiplication getMultiplication(int index) {
		return multiplications.get(index);
	}
}
