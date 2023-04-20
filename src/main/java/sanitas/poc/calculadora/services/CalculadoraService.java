package sanitas.poc.calculadora.services;

import org.springframework.http.ResponseEntity;
import sanitas.poc.calculadora.dtos.OperacionOutputDto;

/**
 * Servicio de la API. Define las operaciones que pueden ser consumidas.
 */
public interface CalculadoraService {

    /**
     * Suma aritmética de dos números.
     * @param a Primer número a sumar.
     * @param b Segundo número a sumar.
     * @return La suma de los 2 números.
     */
    ResponseEntity<OperacionOutputDto> sumar(String a, String b);
}
