package forum.hub.api.domain;

public class DataValidationException extends RuntimeException {
    public DataValidationException( String message) {
        super( message);
    }
}