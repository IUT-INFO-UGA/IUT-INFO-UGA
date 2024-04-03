package TP5;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class TestLogging {
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
		LOGGER.log(Level.INFO, "my first log");
		LOGGER.log(Level.WARNING, " a divided by 0 is posible");
		final int dividend = (int) (Math.random() * 9);
		final int divisor = (int) (Math.random() * 2);
		try {
			final int quotient = divise(dividend, divisor);
			Object[] data = { dividend, divisor, quotient };
			LOGGER.log(Level.INFO, "dividend = {0}, divisor = {1}, quotient = {2}", data);
		} catch (ArithmeticException e) {
			LOGGER.log(Level.SEVERE, "divide by zero ", e);
		}

	}

	private static int divise(final int dividend, final int divisor) throws ArithmeticException {
		return dividend / divisor;
	}
}
