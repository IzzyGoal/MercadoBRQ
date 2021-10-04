package com.mercadobrq.www.MercadoBRQ.entrypoint.model.response;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

/**
 * Classe responsavel pór conter o modelo de resposta da entidade produto.
 *
 * @author Gabriel Silva Lima
 * @since 30/09/2021
 */
@Getter
@Builder
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
}
