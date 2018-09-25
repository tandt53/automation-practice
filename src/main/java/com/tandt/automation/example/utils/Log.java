package com.tandt.automation.example.utils;

import org.apache.log4j.Logger;
import org.testng.ITestResult;

/**
 * Created by thetan.do on 12/28/2016.
 */
public class Log {

	public Logger Log;

	public Log(Class<?> clazz) {
		Log = Logger.getLogger(clazz);
	}

	public void info(String message) {
		Log.info(message);
	}

	public void warn(String message) {
		Log.warn(message);
	}

	public void error(String message) {
		Log.error(message);
	}

	public void fatal(String message) {
		Log.fatal(message);
	}

	public void debug(String message) {
		Log.debug(message);
	}
	
	public void error(String[] messages) {
		for (String msg : messages) {
			Log.error(msg.toString());
		}
	}

}