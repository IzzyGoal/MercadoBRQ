package com.mercadobrq.www.mercadobrq.usecase.domain.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import java.math.BigDecimal;

/**
 * Classe responsavel por conter o modelo de resposta do dominio de produtos.
 *
 * @author Gabriel Silva Lima
 * @since 04/10/2021
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProdutoDomainResponse {

    private Long id;
    private String nome;
    private String descricao;
    private String marca;
    private Integer quantidade;
    private BigDecimal preco;
    private Boolean ativo;
    private Boolean ofertado;
    private Integer porcentagem;
    private CategoriaDomainResponse categoria;
    private TabelaNutricionalDomainResponse tabelaNutricional;
}
