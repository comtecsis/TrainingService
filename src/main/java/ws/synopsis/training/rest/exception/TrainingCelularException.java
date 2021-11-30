package ws.synopsis.training.rest.exception;

public class TrainingCelularException extends Exception {
	
	public TrainingCelularException() {
	}
	

    public TrainingCelularException(String message) {
        super(message);
    }

    public TrainingCelularException(String message, Throwable cause) {
        super(message, cause);
    }

    public TrainingCelularException(Throwable cause) {
        super(cause);
    }
}
