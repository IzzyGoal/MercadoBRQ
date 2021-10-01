package com.mercadobrq.www.MercadoBRQ.entrypoint.mapper;

import com.mercadobrq.www.MercadoBRQ.entrypoint.model.CategoriaModelRequest;
import com.mercadobrq.www.MercadoBRQ.usecase.domain.CategoriaDomainRequest;

public class CategoriaEntrypointMapperRequest {
    private CategoriaEntrypointMapperRequest() {}

    public static CategoriaDomainRequest toDomain(CategoriaModelRequest categoriaModelRequest) {
        return CategoriaDomainRequest.builder()
                .nome(categoriaModelRequest.getNome())
                .build();
    }
}

