package ws.synopsis.training.rest.exception;

public class TrainingPhoneNotExists extends Exception{
	
	public TrainingPhoneNotExists() {
	}
	

    public TrainingPhoneNotExists(String message) {
        super(message);
    }

    public TrainingPhoneNotExists(String message, Throwable cause) {
        super(message, cause);
    }

    public TrainingPhoneNotExists(Throwable cause) {
        super(cause);
    }
}
