package sanitas.poc.calculadora.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Excepción propia de la API que representa un error de negocio.
 */
@Getter
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class LogicaNegocioException extends RuntimeException {

    /**
     * Atributo que representa el error producido con toda la información necesaria.
     */
    private final CustomError customError;

    /**
     * Constructor con 1 parámetro de entrada.
     * @param error Objeto de error personalizado con toda la información necesaria para gestionar el error.
     */
    public LogicaNegocioException(CustomError error) {
        super(error.getMessage());
        this.customError = error;
    }
}
