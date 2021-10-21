package com.mercadobrq.www.MercadoBRQ.usecase.domain.request;

import lombok.Builder;
import lombok.Getter;

/**
 * Classe repsonsavel por conter as informações de saida da requisição do dominio.
 *
 * @author Gabriel Silva Lima
 * @since 30/09/2021
 */
@Getter
@Builder
public class CategoriaDomainRequest {

    private Long id;
    private String nome;
}
