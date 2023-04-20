package sanitas.poc.calculadora.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import sanitas.poc.calculadora.dtos.OperacionOutputDto;
import sanitas.poc.calculadora.services.CalculadoraService;
import sanitas.poc.calculadora.utils.CalculadoraUtils;

/**
 * Controlador principal de la API.
 */
@Slf4j
@Api(tags = {"Operaciones aritméticas"}, value = "Conjunto de operaciones aritméticas de la API")
@RestController
public class calculadoraController {

    /**
     * Instancia del servicio de la API.
     */
    @Autowired
    private CalculadoraService calculadoraService;

    /**
     * Instancia de la clase de utilidades de la API.
     */
    @Autowired
    private CalculadoraUtils utils;

    /**
     * Endpoint para la operación de sumar.
     *
     * @param a Primer número a sumar.
     * @param b Segundo número a sumar.
     * @return La suma de los dos números proporcionados.
     */
    @PostMapping("/sumar")
    @ApiOperation("Operación aritmética de suma. La operación será: a + b")
    public ResponseEntity<OperacionOutputDto> sumar(@RequestParam @ApiParam(name = "a", value = "Primer parámetro de entrada para la operación de suma") String a,
                                                    @RequestParam @ApiParam(name = "b", value = "Segundo parámetro de entrada para la operación de suma") String b) {
        log.debug("Se ha recibido una llamada al servicio /sumar con los siguientes parámetros de entrada: [a:" + a +", b:" + b + "]");
        return calculadoraService.sumar(a, b);
    }

    /**
     * Endpoint para la operación de restar.
     *
     * @param a Primer número a restar.
     * @param b Segundo número a restar.
     * @return La resta de los dos números proporcionados.
     */
    @PostMapping("/restar")
    @ApiOperation("Operación aritmética de resta. La operación será: a - b")
    public ResponseEntity<OperacionOutputDto> restar(@RequestParam @ApiParam(name = "a", value = "Primer parámetro de entrada para la operación de resta") String a,
                                                     @RequestParam @ApiParam(name = "b", value = "Segundo parámetro de entrada para la operación de resta") String b) {
        log.debug("Se ha recibido una llamada al servicio /restar con los siguientes parámetros de entrada: [a:" + a +", b:" + b + "]");
        return calculadoraService.sumar(a, utils.invertNumber(b));
    }

}
