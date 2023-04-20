package sanitas.poc.calculadora.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import sanitas.poc.calculadora.exceptions.CustomError;

/**
 * Constructor de entidades de respuesta.
 */
@Slf4j
public class ResponseEntityBuilder {

    /**
     * Método encargado de construir la respuesta en caso de error interno gestionado por la API.
     * @param customError Información del error producido.
     * @return Respuesta con la información del error.
     */
    public static ResponseEntity<Object> build(CustomError customError) {
        log.debug("se va a devolver una respuesta de error con el código de error [" + customError.getErrorCode() + "] y el mensaje [" + customError.getMessage() + "].");
        return new ResponseEntity<>(customError, customError.getStatus());
    }
}
