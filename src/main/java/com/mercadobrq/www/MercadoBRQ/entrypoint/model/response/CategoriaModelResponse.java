package com.mercadobrq.www.MercadoBRQ.entrypoint.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe responsavel pór conter o modelo de resposta da entidade categoria.
 *
 * @author Gabriel Silva Lima
 * @since 30/09/2021
 */
@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoriaModelResponse {

    private Long id;
    private String nome;
}
