package com.mercadobrq.www.MercadoBRQ.entrypoint.model.response;

import lombok.Builder;
import lombok.Getter;

/**
 * Classe responsavel pór conter o modelo de resposta da entidade categoria.
 *
 * @author Gabriel Silva Lima
 * @since 30/09/2021
 */
@Getter
@Builder
public class CategoriaModelResponse {

    private Long id;
    private String nome;
}
