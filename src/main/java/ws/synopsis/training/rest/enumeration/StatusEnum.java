package ws.synopsis.training.rest.enumeration;

import lombok.Getter;
import ws.synopsis.training.rest.bean.response.base.Status;

@Getter
public enum StatusEnum {

    OK("0000", "Proceso exitoso."),
    UNEXPECTED_ERROR("9000", "Error inesperado."),
    FIELD_EMPTY("9001", "Campo est\u00E1 vac\u00EDo."),
	ID_NOT_FOUND("9002","Id de cliente no encontrado"),
	CELULAR_REGISTRADO("9003","El celular ya se encuentra registrado en el sistema");

    private final Status status;

    StatusEnum(String code, String message) {
        this.status = new Status(code, message);
    }

}
