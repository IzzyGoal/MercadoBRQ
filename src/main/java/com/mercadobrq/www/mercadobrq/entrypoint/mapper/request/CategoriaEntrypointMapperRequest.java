package com.mercadobrq.www.mercadobrq.entrypoint.mapper.request;

import com.mercadobrq.www.mercadobrq.entrypoint.model.request.CategoriaIDModelRequest;
import com.mercadobrq.www.mercadobrq.entrypoint.model.request.CategoriaModelRequest;
import com.mercadobrq.www.mercadobrq.usecase.domain.request.CategoriaDomainRequest;

import java.util.Objects;

/**
 * Classe reponsavel por fazer a transformação do dado model ao domain
 * @author Gabriel Silva Lima
 * @since 30/09/2021
 */
public class CategoriaEntrypointMapperRequest {

    /**
     * Construtor vazio para evitar instanciação.
     */
    private CategoriaEntrypointMapperRequest() {}

    /**
     * metodo responsavel por transformar um informacão de model para o dominio.
     * @param categoriaModelRequest {@code CategoriaModelRequest } -
     * @return CategoriaDomainRequest
     */
    public static CategoriaDomainRequest toDomain(CategoriaModelRequest categoriaModelRequest) {
        return CategoriaDomainRequest.builder()
                .nome(categoriaModelRequest.getNome())
                .build();
    }
    public static CategoriaDomainRequest toDomainProduct(CategoriaIDModelRequest category) {
        if (Objects.isNull(category)) {
            return CategoriaDomainRequest.builder().build();
        }
        return CategoriaDomainRequest.builder()
                .id(category.getId())
                .build();
    }
}

