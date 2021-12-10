package ws.synopsis.training.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ws.synopsis.training.bean.response.TrainingResponse;
import ws.synopsis.training.bean.response.base.GenResponse;
import ws.synopsis.training.enumeration.StatusEnum;
import ws.synopsis.training.exception.*;

@ControllerAdvice
public class TrainingAdvice {

    private static final Logger logger = LoggerFactory.getLogger(TrainingAdvice.class);

    @ExceptionHandler({TrainingLogicException.class})
    public ResponseEntity<?> logic(TrainingLogicException e) {
        logger.error(e.getMessage(), e);
        return ResponseEntity.internalServerError().body(
                GenResponse.<TrainingResponse>builder()
                        .status(e.getStatus().getStatus())
                        .build()
        );
    }

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