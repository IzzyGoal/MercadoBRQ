package com.mercadobrq.www.MercadoBRQ.dataprovider.mapper;

import com.mercadobrq.www.MercadoBRQ.dataprovider.entity.CategoriaEntity;
import com.mercadobrq.www.MercadoBRQ.entrypoint.model.CategoriaModelRequest;
import com.mercadobrq.www.MercadoBRQ.usecase.domain.CategoriaDomainRequest;
import com.mercadobrq.www.MercadoBRQ.usecase.domain.CategoriaDomainResponse;

public class CategoriaMapperRequest {

    private CategoriaMapperRequest() {
    }

    public static CategoriaEntity toEntityUpdate(CategoriaDomainResponse categoria) {
        return CategoriaEntity.builder()
                .id(categoria.getId())
                .nome(categoria.getNome())
                .build();
    }

    public static CategoriaEntity toEntity(CategoriaDomainRequest categoria) {
        return CategoriaEntity.builder()
                .nome(categoria.getNome())
                .build();
    }
}
