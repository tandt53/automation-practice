package onboarding.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by tandt53 on 12/28/2016.
 */
public class Log {

	public Logger Log;

	public Log(Class<?> clazz) {
		Log = LogManager.getLogger(clazz);
	}

	public void info(String message) {
		Log.info(message);
	}

	public void info(String message, String extra){
		Log.info(message, extra);
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
			Log.error(msg);
		}
	}

}