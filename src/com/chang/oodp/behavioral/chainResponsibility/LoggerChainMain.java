package com.chang.oodp.behavioral.chainResponsibility;

// http://www.tutorialspoint.com/design_pattern/chain_of_responsibility_pattern.htm
public class LoggerChainMain {
	private static AbstractLogger getChainOfLoggers() {

		AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
		AbstractLogger debugLogger = new DebugLogger(AbstractLogger.DEBUG);
		AbstractLogger infoLogger = new InfoLogger(AbstractLogger.INFO);

		errorLogger.setNextLogger(debugLogger);
		debugLogger.setNextLogger(infoLogger);

		return errorLogger;
	}

	public static void main(String[] args) {
		AbstractLogger loggerChain = getChainOfLoggers();

		System.out.println("INFO Logger===");
		loggerChain.logMessage(AbstractLogger.INFO, "This is an information.");

		System.out.println("DEBUG Logger===");
		loggerChain.logMessage(AbstractLogger.DEBUG,
				"This is an debug level information.");

		System.out.println("ERROR Logger===");
		loggerChain.logMessage(AbstractLogger.ERROR,
				"This is an error information.");
	}
}

class DebugLogger extends AbstractLogger {

	public DebugLogger(int level) {
		this.level = level;
	}

	@Override
	protected void write(String message) {
		System.out.println("Debug::Logger: " + message);
	}
}

class ErrorLogger extends AbstractLogger {

	public ErrorLogger(int level) {
		this.level = level;
	}

	@Override
	protected void write(String message) {
		System.out.println("Error::Logger: " + message);
	}
}

class InfoLogger extends AbstractLogger {

	public InfoLogger(int level) {
		this.level = level;
	}

	@Override
	protected void write(String message) {
		System.out.println("Info::Logger: " + message);
	}
}

abstract class AbstractLogger {
	public static int INFO = 1;		// Console
	public static int DEBUG = 2;	// file
	public static int ERROR = 3;	// Error

	protected int level;

	// next element in chain or responsibility
	protected AbstractLogger nextLogger;

	public void setNextLogger(AbstractLogger nextLogger) {
		this.nextLogger = nextLogger;
	}

	public void logMessage(int level, String message) {
		//System.out.println(this.level + "," + level);
		if (this.level <= level) {
			write(message);
		} 
		if (nextLogger != null) {
			//System.out.println(this.level + "," + level+", next");
			nextLogger.logMessage(level, message);
		}
	}

	abstract protected void write(String message);

}