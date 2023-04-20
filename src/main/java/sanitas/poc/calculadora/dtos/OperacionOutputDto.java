package sanitas.poc.calculadora.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * DTO de salida para las operaciones de suma y resta de la API.
 */
@Data
@ApiModel(value = "DTO de salida para calculadora", description = "DTO de salida para las operaciones de suma y resta")
public class OperacionOutputDto {
    /**
     * Atributo que representa el resultado de la operación de suma o resta.
     */
    @ApiModelProperty("Resultado de la operación aritmética realizada")
    private Number resultado;

    /**
     * Constructor con 1 parámetro de entrada.
     * @param resultadoParam Resultado de la operación de suma o resta.
     */
    public OperacionOutputDto(Number resultadoParam) {
        this.resultado = resultadoParam;
    }
}
