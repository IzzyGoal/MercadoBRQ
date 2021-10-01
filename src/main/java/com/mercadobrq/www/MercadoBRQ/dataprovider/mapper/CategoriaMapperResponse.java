package com.mercadobrq.www.MercadoBRQ.dataprovider.mapper;

import com.mercadobrq.www.MercadoBRQ.dataprovider.entity.CategoriaEntity;
import com.mercadobrq.www.MercadoBRQ.usecase.domain.CategoriaDomainResponse;
import java.util.List;
import java.util.stream.Collectors;

public class CategoriaMapperResponse {
    private CategoriaMapperResponse() {

    }

    public static CategoriaDomainResponse toDomain(CategoriaEntity categoria) {
        return CategoriaDomainResponse.builder()
                .id(categoria.getId())
                .nome(categoria.getNome())
                .build();
    }

    public static List<CategoriaDomainResponse> toCollecationDomain(List<CategoriaEntity> categoriaEntities) {
        return categoriaEntities.stream()
                .map(CategoriaMapperResponse::toDomain)
                .collect(Collectors.toList());
    }
}

