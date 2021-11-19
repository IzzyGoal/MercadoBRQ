package com.mercadobrq.www.mercadobrq.entrypoint.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProdutoModelResponseShort {
    private Long id;
    private String nome;
    private String marca;
    private Integer quantidade;
    private BigDecimal preco;
    private Boolean ofertado;
    private Integer porcentagem;
}
