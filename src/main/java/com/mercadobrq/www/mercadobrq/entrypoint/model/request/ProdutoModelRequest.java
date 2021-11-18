package com.mercadobrq.www.mercadobrq.entrypoint.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

/**
 * Classe responsavel por o modelo de requisição de dados a entidade Produtos.
 *
 * @author Gabriel Silva Lima
 * @since 04/10/2021
 */
@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProdutoModelRequest {

    @NotNull
    @NotBlank
    private String nome;

    @NotNull
    @NotBlank
    private String descricao;

    @NotNull
    @NotBlank
    private String marca;

    @PositiveOrZero
    @NotNull
    private Integer quantidade;

    @PositiveOrZero
    @NotNull
    private BigDecimal preco;

    @NotNull
    private Boolean ativo;

    @NotNull
    private Boolean ofertado;

    @NotNull
    private Integer porcentagem;

    @NotNull
    @Valid
    private CategoriaIDModelRequest categoria;


    private TabelaNutricionalEntrypointModelResquest tabelaNutricional;
}
