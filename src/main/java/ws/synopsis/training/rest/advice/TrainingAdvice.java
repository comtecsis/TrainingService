package ws.synopsis.training.rest.advice;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ws.synopsis.training.rest.bean.response.TrainingResponse;
import ws.synopsis.training.rest.bean.response.base.GenResponse;
import ws.synopsis.training.rest.enumeration.StatusEnum;
import ws.synopsis.training.rest.exception.TrainingCelularException;
import ws.synopsis.training.rest.exception.TrainingFieldException;
import ws.synopsis.training.rest.exception.TrainingIdException;
import ws.synopsis.training.rest.exception.TrainingPhoneNotExists;

@ControllerAdvice
public class TrainingAdvice {

    private static final Logger logger = LoggerFactory.getLogger(TrainingAdvice.class);

    @ExceptionHandler({DataIntegrityViolationException.class})
    public ResponseEntity<?> fieldDuplicated(DataIntegrityViolationException e) {
        logger.error(e.getMessage(), e);
        TrainingResponse resp = TrainingResponse.builder().message(e.getMessage()).build();
        return ResponseEntity.internalServerError().body(
                GenResponse.<TrainingResponse>builder()
                        .status(StatusEnum.FIELD_DUPLICATED.getStatus())
                        .build()
        );
    }

    @ExceptionHandler({TrainingFieldException.class})
    public ResponseEntity<?> field(TrainingFieldException e){
        logger.error(e.getMessage(), e);
        TrainingResponse resp = TrainingResponse.builder().message(e.getMessage()).build();
        return ResponseEntity.internalServerError().body(
                GenResponse.<TrainingResponse>builder()
                        .status(StatusEnum.FIELD_EMPTY.getStatus())
                        .data(resp)
                        .build()
        );
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<?> general(Exception e){
        logger.error(e.getMessage(), e);
        TrainingResponse resp = TrainingResponse.builder().message(e.getMessage()).build();
        return ResponseEntity.internalServerError().body(
                GenResponse.<TrainingResponse>builder()
                        .status(StatusEnum.UNEXPECTED_ERROR.getStatus())
                        .data(resp)
                        .build()
        );
    }
    
    @ExceptionHandler({TrainingIdException.class})
    public ResponseEntity<?> field(TrainingIdException e){
        logger.error(e.getMessage(), e);
        TrainingResponse resp = TrainingResponse.builder().message(e.getMessage()).build();
        return ResponseEntity.internalServerError().body(
                GenResponse.<TrainingResponse>builder()
                        .status(StatusEnum.ID_NOT_FOUND.getStatus())
                        .data(resp)
                        .build()
        );
    }
    
    @ExceptionHandler({TrainingCelularException.class})
    public ResponseEntity<?> field(TrainingCelularException e){
        logger.error(e.getMessage(), e);
        TrainingResponse resp = TrainingResponse.builder().message(e.getMessage()).build();
        return ResponseEntity.internalServerError().body(
                GenResponse.<TrainingResponse>builder()
                        .status(StatusEnum.CELULAR_REGISTRADO.getStatus())
                        .data(resp)
                        .build()
        );
    }
    
    @ExceptionHandler({TrainingPhoneNotExists.class})
    public ResponseEntity<?> field(TrainingPhoneNotExists e){
        logger.error(e.getMessage(), e);
        TrainingResponse resp = TrainingResponse.builder().message(e.getMessage()).build();
        return ResponseEntity.internalServerError().body(
                GenResponse.<TrainingResponse>builder()
                        .status(StatusEnum.PHONE_NOT_EXISTS.getStatus())
                        .data(resp)
                        .build()
        );
    }

}
