package sanitas.poc.calculadora.dtos;

import lombok.Data;

/**
 * DTO de salida para las operaciones de suma y resta de la API.
 */
@Data
public class OperacionOutputDto {
    /**
     * Atributo que representa el resultado de la operación de suma o resta.
     */
    private Number resultado;

    /**
     * Constructor con 1 parámetro de entrada.
     * @param resultadoParam Resultado de la operación de suma o resta.
     */
    public OperacionOutputDto(Number resultadoParam) {
        this.resultado = resultadoParam;
    }
}
