package com.mercadobrq.www.MercadoBRQ.dataprovider.mapper;

import com.mercadobrq.www.MercadoBRQ.entrypoint.Controller.model.CategoriaModelRequest;
import com.mercadobrq.www.MercadoBRQ.usecase.CategoriaDomainRequest;

public class CategoriaMapperRequest {

    private CategoriaMapperRequest() {
    }

    public static CategoriaDomainRequest toDomain(CategoriaModelRequest categoriaModelRequest) {
    return  CategoriaDomainRequest.builder()
            .nome(categoriaModelRequest.getNome())
            .build();
    }

}
