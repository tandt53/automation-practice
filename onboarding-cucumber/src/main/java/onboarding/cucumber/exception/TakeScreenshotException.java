package onboarding.cucumber.exception;

public class TakeScreenshotException extends RuntimeException{

    public TakeScreenshotException(String message) {
        super(message);
    }

    public TakeScreenshotException(String message, Throwable cause) {
        super(message, cause);
    }
}
