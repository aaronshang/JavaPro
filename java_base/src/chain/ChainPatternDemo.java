/*
 * 
 * 责任链模式
 * 
 * 
 * 
 * 
 * 
 * */


package chain;

public class ChainPatternDemo {
	
	private static AbstractLogger getChainOfLoggers(){
		AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
		AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
		AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);
		errorLogger.setNextLogger(fileLogger);
		fileLogger.setNextLogger(consoleLogger);
		return errorLogger;
	}
	
	public static void main(String[] args){
		
		System.out.println("ChainPatternDemo");
		AbstractLogger logChain = getChainOfLoggers();
		logChain.logMessage(AbstractLogger.INFO,  "Info");
		logChain.logMessage(AbstractLogger.DEBUG, "Debug");
		logChain.logMessage(AbstractLogger.ERROR, "Error");
	}
}
