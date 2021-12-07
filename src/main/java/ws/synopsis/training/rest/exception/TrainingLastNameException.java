package ws.synopsis.training.rest.exception;

public class TrainingLastNameException extends Exception {

	public TrainingLastNameException() {
		
	}
	
	public TrainingLastNameException(String message) {
        super(message);
    }

    public TrainingLastNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public TrainingLastNameException(Throwable cause) {
        super(cause);
    }
}
