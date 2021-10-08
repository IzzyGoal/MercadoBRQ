package com.mercadobrq.www.MercadoBRQ.usecase.domain.request;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

/**
 * Classe repsonsavel por conter as informações de saida da requisição do dominio.
 *
 * @author Gabriel Silva Lima
 * @since 04/10/2021
 */
@Getter
@Builder
public class ProdutoDomainRequest {

    private String nome;
    private String descricao;
    private String marca;
    private Integer quantidade;
    private BigDecimal preco;
    private Boolean ativo;
    private Boolean ofertado;
    private Integer porcentagem;
}
