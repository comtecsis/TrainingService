package ws.synopsis.training.exception;

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
