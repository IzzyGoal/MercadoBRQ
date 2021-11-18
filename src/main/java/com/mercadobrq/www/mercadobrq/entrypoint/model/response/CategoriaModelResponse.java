package com.mercadobrq.www.mercadobrq.entrypoint.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

    @NotNull
    private Long id;

    @NotBlank
    private String nome;
}
