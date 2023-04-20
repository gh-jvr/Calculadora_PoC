package sanitas.poc.calculadora.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import sanitas.poc.calculadora.exceptions.CustomError;
import sanitas.poc.calculadora.exceptions.LogicaNegocioException;

/**
 * Controlador para el control personalizado de las excepciones.
 */
@ControllerAdvice
public class CustomControllerAdvice {

    /**
     * Controlador de las excepciones de tipo LogicaNegocioException.
     * @param e Excepción capturada.
     * @return Respuesta personalizada para el tipo de excepción capturada.
     */
    @ExceptionHandler(LogicaNegocioException.class)
    public ResponseEntity<CustomError> handleLogicaNegocioException(LogicaNegocioException e) {
        return new ResponseEntity<>(e.getCustomError(), e.getCustomError().getStatus());
    }

    /**
     * Controlador del resto de excepciones de la API.
     * @param e Excepción capturada.
     * @return Respuesta personalizada para el tipo de excepción capturada.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomError> handleLogicaNegocioException(Exception e) {
        String sb = "Error general: " + e.getMessage();
        CustomError error = new CustomError(sb, 0);
        return new ResponseEntity<>(error, error.getStatus());
    }
}
