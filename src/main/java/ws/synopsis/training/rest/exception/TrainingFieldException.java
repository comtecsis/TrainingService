package ws.synopsis.training.rest.exception;

public class TrainingFieldException extends Exception {

    public TrainingFieldException() {
    }

    public TrainingFieldException(String message) {
        super(message);
    }

    public TrainingFieldException(String message, Throwable cause) {
        super(message, cause);
    }

    public TrainingFieldException(Throwable cause) {
        super(cause);
    }
}
