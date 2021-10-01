package com.mercadobrq.www.MercadoBRQ.entrypoint.mapper;

import com.mercadobrq.www.MercadoBRQ.dataprovider.mapper.CategoriaMapperResponse;
import com.mercadobrq.www.MercadoBRQ.entrypoint.model.CategoriaModelResponse;
import com.mercadobrq.www.MercadoBRQ.usecase.domain.CategoriaDomainResponse;

import java.util.List;
import java.util.stream.Collectors;

public class CategoriaEntryopintMapperResponse {

    private CategoriaEntryopintMapperResponse() {}

    public static List<CategoriaModelResponse> toCollectionModel(List<CategoriaDomainResponse> categoriasDomain) {
        return categoriasDomain.stream()
                .map(CategoriaEntryopintMapperResponse::toModel)
                .collect(Collectors.toList());
    }

    public static CategoriaModelResponse toModel(CategoriaDomainResponse categoriaDomainResponse) {
        return CategoriaModelResponse.builder()
                .id(categoriaDomainResponse.getId())
                .nome(categoriaDomainResponse.getNome())
                .build();
    }

}


