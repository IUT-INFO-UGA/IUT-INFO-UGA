package TP5.tabledoperation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import TP5.TestLogging;

public class TestTableDOperation {
	private static Logger LOGGER = Logger.getLogger(TestLogging.class.getPackageName());
	private static final LogManager logManager = LogManager.getLogManager();
	// Configuration du logger
	// EditConfiguration > Modify options > add VM options :
	// -Djava.util.logging.config.file=conf/debug-logging.properties
	static {
		try {
			logManager.readConfiguration(new FileInputStream("conf/debug-logging.properties"));
		} catch (IOException exception) {
			LOGGER.log(Level.SEVERE, "Cannot read configuration file", exception);
		}
	}

	public static void main(String[] args) {

		final Scanner in = new Scanner(System.in);
		System.out.println("Addition 1 ou Soustraction 2 ou Multiplication 3 ?");
		int response = 0;
		while (response < 1 || response > 3) {
			System.out.println("𝗠𝗲𝗿𝗰𝗶 𝗱𝗲 𝗿é𝗽𝗼𝗻𝗱𝗿𝗲 𝗽𝗮𝗿 1 𝗼𝘂 2 𝗼𝘂 3 ?");
			response = in.nextInt();
		}
		System.out.println("mode sans echec ? 1 ou mode normal ? 2");
		int mode = 0;
		while (mode < 1 || mode > 2) {
			System.out.println("mode sans echec ? 1 ou mode normal ? 2");
			mode = in.nextInt();
		}
		LOGGER.info("mode : " + (mode == 2 ? "sans echec" : "normal"));
		System.out.println("Donner les réponses aux opérations :");
		TableDOperation table = new TableDOperation(operationEnum.values()[response - 1]);
		for (int i = 0; i < table.getNombreDOperations(); i++) {
			System.out.print(table.getOperation(i));
			double reponse = in.nextDouble();
			boolean juste = false;
			while (juste || mode == 2) {
				try {
					table.getOperation(i).setReponseUtilisateur(reponse);
					juste = true;
				} catch (ErreurOperationException e) {
					System.out.println("Erreur, recommencez");
					reponse = in.nextDouble();
					juste = false;
				}
			}
		}

		System.out.println("Nombre de réponses justes : " + table.getNombreReponsesJustes());
		in.close();
	}
}
