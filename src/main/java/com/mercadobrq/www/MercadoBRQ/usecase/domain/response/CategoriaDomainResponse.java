package com.mercadobrq.www.MercadoBRQ.usecase.domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Classe responsavel por conter o modelo de resposta do dominio de categorias.
 *
 * @author Gabriel Silva Lima
 * @since 30/09/2021
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDomainResponse {

    private Long id;
    private String nome;
}
