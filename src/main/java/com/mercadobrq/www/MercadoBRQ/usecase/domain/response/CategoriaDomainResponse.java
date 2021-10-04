package com.mercadobrq.www.MercadoBRQ.usecase.domain.response;

import lombok.Builder;
import lombok.Getter;

/**
 * Classe responsavel por conter o modelo de resposta do dominio de categorias.
 *
 * @author Gabriel Silva Lima
 * @since 30/09/2021
 */
@Getter
@Builder
public class CategoriaDomainResponse {

    private Long id;
    private String nome;
}
