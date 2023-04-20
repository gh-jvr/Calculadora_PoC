package sanitas.poc.calculadora.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sanitas.poc.calculadora.dtos.OperacionOutputDto;

/**
 * Implementación del servicio de la API.
 */
@Service(value = "calculadoraService")
public class CalculadoraServiceImpl implements CalculadoraService {

    /**
     * Operación de suma de la API Calculadora.
     * @param a Primer número a sumar.
     * @param b Segundo número a sumar.
     * @return El resultado de la suma de los 2 números pasados como parámetros de entrada.
     */
    @Override
    public ResponseEntity<OperacionOutputDto> sumar(String a, String b) {

        // Realizamos la operación (Código temporal)
        Number resultNumber = 1;

        // Devolvemos el resultado con estado HTTP 200.
        return new ResponseEntity<>(new OperacionOutputDto(resultNumber), HttpStatus.OK);
    }

}
