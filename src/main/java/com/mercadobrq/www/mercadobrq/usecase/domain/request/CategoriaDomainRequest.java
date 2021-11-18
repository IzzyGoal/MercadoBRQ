package com.mercadobrq.www.mercadobrq.usecase.domain.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Classe repsonsavel por conter as informações de saida da requisição do dominio.
 *
 * @author Gabriel Silva Lima
 * @since 30/09/2021
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDomainRequest {

    private Long id;

    private String nome;
}
