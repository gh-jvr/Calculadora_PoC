package sanitas.poc.calculadora.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * Bean para la definición de errores propios de la API.
 */
@Getter
@Setter
public class CustomError {

    /**
     * Atributo que representa el momento en el que se ha producido el error.
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    /**
     * Atributo que representa el estado HTTP del error.
     */
    private HttpStatus status;

    /**
     * Atributo que representa el mensaje del error.
     */
    private String message;

    /**
     * Atributo que representa el código interno del error.
     */
    private int errorCode;

    /**
     * Constructor por defecto.
     */
    public CustomError(){
        this.timestamp = LocalDateTime.now();
        this.status = HttpStatus.BAD_REQUEST;
        this.message = "Error general";
        this.errorCode = 1;
    }

    /**
     * Constructor con 2 parámetros.
     * @param message Mensaje del error a mostrar.
     * @param errorCode Código interno del error.
     */
    public CustomError(String message, int errorCode) {
        this.timestamp = LocalDateTime.now();
        this.status = HttpStatus.BAD_REQUEST;
        this.message = message;
        this.errorCode = errorCode;
    }
}
