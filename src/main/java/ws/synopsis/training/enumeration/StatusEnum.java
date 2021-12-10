package ws.synopsis.training.enumeration;

import lombok.Getter;
import ws.synopsis.training.bean.response.base.Status;

@Getter
public enum StatusEnum {

    OK("0000", "Proceso exitoso."),
    UNEXPECTED_ERROR("9000", "Error inesperado."),
    FIELD_EMPTY("9001", "Campo est\u00E1 vac\u00EDo."),
	ID_NOT_FOUND("9002","Id de cliente no encontrado"),
    FIELD_DUPLICATED("9003", "Campo duplicado."),
	CELULAR_REGISTRADO("9003","El celular ya se encuentra registrado en el sistema"),
	PHONE_NOT_EXISTS("9004", "El celular ingresado no existe en la BD"),
    LOGIN_ERROR("9005", "Credenciales inv\u00E1lidas."),
	LASTNAME_NOT_EXISTS("9010","Ningun cliente con ese apellido");

    private final Status status;

    StatusEnum(String code, String message) {
        this.status = new Status(code, message);
    }

}