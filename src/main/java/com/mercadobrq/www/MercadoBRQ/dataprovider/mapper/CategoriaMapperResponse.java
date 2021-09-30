package com.mercadobrq.www.MercadoBRQ.dataprovider.mapper;

import com.mercadobrq.www.MercadoBRQ.entrypoint.Controller.model.CategoriaModelRequest;
import com.mercadobrq.www.MercadoBRQ.entrypoint.Controller.model.CategoriaModelResponse;
import com.mercadobrq.www.MercadoBRQ.usecase.CategoriaDomainResponse;

import java.util.List;
import java.util.stream.Collectors;

public class CategoriaMapperResponse {
    private CategoriaMapperResponse() {

    }
    public static CategoriaModelResponse toModel(CategoriaDomainResponse categoriaDomainResponse) {
        return CategoriaModelResponse.builder()
                .id(categoriaDomainResponse.getId())
                .nome(categoriaDomainResponse.getNome())
                .build();
    }
    public static List<CategoriaModelResponse>  toCollectionsModel(List<CategoriaDomainResponse> categoriaDomainResponses) {
        return categoriaDomainResponses.stream()
                .map((CategoriaMapperResponse::toModel))
                .collect(Collectors.toList());
    }
}
