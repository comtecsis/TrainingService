package ws.synopsis.training.rest.exception;

import lombok.Getter;
import lombok.ToString;
import ws.synopsis.training.rest.enumeration.StatusEnum;

@Getter
@ToString
public class TrainingLogicException extends Exception {

    private final StatusEnum status;

    public TrainingLogicException(StatusEnum status) {
        super(status.getStatus().getMessage());
        this.status = status;
    }

    public TrainingLogicException(StatusEnum status, Throwable cause) {
        super(status.getStatus().getMessage(), cause);
        this.status = status;
    }

}
