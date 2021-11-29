package ws.synopsis.training.rest.enumeration;

import lombok.Getter;
import ws.synopsis.training.rest.bean.response.base.Status;

@Getter
public enum StatusEnum {

    OK("0000", "Proceso exitoso."),
    UNEXPECTED_ERROR("9000", "Error inesperado."),
    FIELD_EMPTY("9001", "Campo est\u00E1 vac\u00EDo.");

    private final Status status;

    StatusEnum(String code, String message) {
        this.status = new Status(code, message);
    }

}
