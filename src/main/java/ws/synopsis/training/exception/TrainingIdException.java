package ws.synopsis.training.exception;

public class TrainingIdException extends Exception {

	public TrainingIdException() {
    }

    public TrainingIdException(String message) {
        super(message);
    }

    public TrainingIdException(String message, Throwable cause) {
        super(message, cause);
    }

    public TrainingIdException(Throwable cause) {
        super(cause);
    }
}
