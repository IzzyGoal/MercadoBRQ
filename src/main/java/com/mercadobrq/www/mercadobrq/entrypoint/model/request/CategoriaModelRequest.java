package com.mercadobrq.www.mercadobrq.entrypoint.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Classe responsavel por conter o modelo de requisição á entidade Categoria.
 *
 * @author Gabriel Silva Lima
 * @since 30/09/2021
 */
@Getter
@Setter
public class CategoriaModelRequest {

    private Long id;

    @NotNull
    @NotBlank
    private String nome;
}
