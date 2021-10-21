package com.mercadobrq.www.MercadoBRQ.entrypoint.mapper.response;

import com.mercadobrq.www.MercadoBRQ.entrypoint.model.response.CategoriaModelResponse;
import com.mercadobrq.www.MercadoBRQ.usecase.domain.response.CategoriaDomainResponse;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Classe responsavel por tranformar/transportar informação da camada domain para model.
 *
 * @author Gabriel Silva Lima
 * @since 30/09/2021
 */
public class CategoriaEntryopintMapperResponse {

    private CategoriaEntryopintMapperResponse() {}

    public static List<CategoriaModelResponse> toCollectionModel(List<CategoriaDomainResponse> categoriasDomain) {
        return categoriasDomain.stream()
                .map(CategoriaEntryopintMapperResponse::toModel)
                .collect(Collectors.toList());
    }

    public static CategoriaModelResponse toModel(CategoriaDomainResponse categoriaDomainResponse) {
        if (Objects.isNull(categoriaDomainResponse)) {
            return CategoriaModelResponse.builder().build();
        }

        return CategoriaModelResponse.builder()
                .id(categoriaDomainResponse.getId())
                .nome(categoriaDomainResponse.getNome())
                .build();
    }
}


