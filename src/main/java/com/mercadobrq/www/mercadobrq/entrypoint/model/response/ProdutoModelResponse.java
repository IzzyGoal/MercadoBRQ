package com.mercadobrq.www.mercadobrq.entrypoint.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Classe responsavel pór conter o modelo de resposta da entidade produto.
 *
 * @author Gabriel Silva Lima
 * @since 30/09/2021
 */
@Getter
@Setter
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProdutoModelResponse {

    private Long id;
    private String nome;
    private String descricao;
    private String marca;
    private Integer quantidade;
    private BigDecimal preco;
    private Boolean ativo;
    private Boolean ofertado;
    private Integer porcentagem;
    private CategoriaModelResponse categoria;
    private TabelaNutricionalEntrypointModelResponse tabelaNutricional;
}
