package onboarding.cucumber.exception;

public class PageNotFoundException extends RuntimeException{
    public PageNotFoundException() {
        super();
    }

    public PageNotFoundException(String message) {
        super(message);
    }

    public PageNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PageNotFoundException(Throwable cause) {
        super(cause);
    }

    protected PageNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
