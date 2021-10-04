package com.mercadobrq.www.MercadoBRQ.usecase.domain.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
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

}
