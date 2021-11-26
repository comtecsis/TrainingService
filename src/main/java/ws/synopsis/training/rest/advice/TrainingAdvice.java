package ws.synopsis.training.rest.advice;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ws.synopsis.training.rest.bean.response.TrainingResponse;
import ws.synopsis.training.rest.exception.TrainingFieldException;

@ControllerAdvice
public class TrainingAdvice {

    @ExceptionHandler({TrainingFieldException.class})
    public ResponseEntity<TrainingResponse> general(TrainingFieldException e){
        return ResponseEntity.internalServerError().body(TrainingResponse.builder().message(e.getMessage()).build());
    }

}
