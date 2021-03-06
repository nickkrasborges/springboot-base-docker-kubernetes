package br.com.springboot.base.feature.transporte.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Builder
@Getter
@Setter
@ToString
public class ConsultaVeiculosResponse implements Serializable {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Veiculos> content;

    @Builder
    @Getter
    @Setter
    public static final class Veiculos{
        private String id;
        private Integer tipoVeiculo;
        private BigDecimal fatorMultiplicador;
        private String descricaoVeiculo;

    }
}
