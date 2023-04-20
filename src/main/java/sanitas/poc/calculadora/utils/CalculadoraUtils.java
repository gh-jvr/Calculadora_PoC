package sanitas.poc.calculadora.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.NumberUtils;
import sanitas.poc.calculadora.exceptions.CustomError;
import sanitas.poc.calculadora.exceptions.LogicaNegocioException;

/**
 * Clase de utilidades para la API Calculadora.
 */
@Slf4j
@Component("calculadoraUtils")
public class CalculadoraUtils {
    /**
     * Método encargado de parsear un número de tipo String al tipo Number.
     *
     * @param number Número a formatear.
     * @return Objeto Number que representa el número insertado como String.
     */
    public Number ParseToNumber(String number) {
        // Sustituimos las comas por puntos en caso de que el usuario las haya insertado
        // para poder hacer el casting correctamente.
        number = number.replaceAll(",", ".");
        // Hacemos el casting.
        try {
            return NumberUtils.parseNumber(number, Number.class);
        } catch (NumberFormatException e) {
            log.error("Se ha producido un error al intentar convertir el String [" + number + "] en un objeto de tipo Number.");
            throw new LogicaNegocioException(new CustomError("Los parámetros de entrada no son válidos. Deben ser valores numéricos.", 3));
        }
    }

    /**
     * Método encargado de comprobar si los Strings de entrada que representan números tienen un formato correcto.
     *
     * @param a Primer número.
     * @param b Segundo número.
     */
    public void checkInputParams(String a, String b) {
        checkIfNullOrEmpty(a, "a");
        checkIfNullOrEmpty(b, "b");
    }

    /**
     * Método encargado de comprobar si un String es nulo o está vacío.
     * @param param String a procesar.
     * @param name Nombre del parámetro para mostrar en caso de error.
     */
    private void checkIfNullOrEmpty(String param, String name) {
        if (param == null || param.isBlank()) {
            log.error("Se ha recibido un parámetro de entrada con nombre [" + name + "] que es nulo o vacío.");
            throw new LogicaNegocioException(new CustomError("El parámetro de entrada '" + name + "' es nulo o está vacío", 2));
        }
    }

    /**
     * Método encargado de invertir un número. Si es positivo, lo convertirá en negativo, y viceversa.
     * @param b String que representa el número a invertir.
     * @return String que representa el número invertido.
     */
    public String invertNumber(String b) {
        checkIfNullOrEmpty(b, "b");
        StringBuilder sb = new StringBuilder(b.trim());
        if (sb.indexOf("-") == 0) {
            sb.replace(0, 1, "");
        } else {
            sb.insert(0,"-");
        }
        log.debug("se ha convertido el número [" + b + "] en [" + sb.toString() + "].");
        return sb.toString();
    }
}
