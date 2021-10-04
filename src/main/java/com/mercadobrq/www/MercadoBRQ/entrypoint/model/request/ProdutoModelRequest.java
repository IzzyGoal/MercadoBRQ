package com.mercadobrq.www.MercadoBRQ.entrypoint.model.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Classe responsavel por o modelo de requisição de dados a entidade Produtos.
 *
 * @author Gabriel Silva Lima
 * @since 04/10/2021
 */
@Getter
@Setter
public class ProdutoModelRequest {

    private String nome;
    private String descricao;
    private String marca;
    private Integer quantidade;
    private BigDecimal preco;
}
