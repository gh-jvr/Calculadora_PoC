package sanitas.poc.calculadora.services;

import io.corp.calculator.TracerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sanitas.poc.calculadora.dtos.OperacionOutputDto;
import sanitas.poc.calculadora.utils.CalculadoraUtils;

/**
 * Implementación del servicio de la API.
 */
@Service(value = "calculadoraService")
public class CalculadoraServiceImpl implements CalculadoraService {

    @Autowired
    CalculadoraUtils utils;

    /**
     * Operación de suma de la API Calculadora.
     * @param a Primer número a sumar.
     * @param b Segundo número a sumar.
     * @return El resultado de la suma de los 2 números pasados como parámetros de entrada.
     */
    @Override
    public ResponseEntity<OperacionOutputDto> sumar(String a, String b) {

        // Comprobamos que los datos de entrada no son nulos ni vacíos.
        utils.checkInputParams(a,b);

        // Parseamos los parámetros de entrada a números.
        Number aNumber = utils.ParseToNumber(a);
        Number bNumber = utils.ParseToNumber(b);

        // Realizamos la operación
        Number resultNumber = aNumber.doubleValue() + bNumber.doubleValue();

        // Devolvemos el resultado con estado HTTP 200.
        TracerImpl tracer = new TracerImpl();
        tracer.trace(resultNumber);
        return new ResponseEntity<>(new OperacionOutputDto(resultNumber), HttpStatus.OK);
    }

}
