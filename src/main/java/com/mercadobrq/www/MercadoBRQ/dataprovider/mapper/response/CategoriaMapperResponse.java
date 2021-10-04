package com.mercadobrq.www.MercadoBRQ.dataprovider.mapper.response;

import com.mercadobrq.www.MercadoBRQ.dataprovider.entity.CategoriaEntity;
import com.mercadobrq.www.MercadoBRQ.usecase.domain.response.CategoriaDomainResponse;
import java.util.List;
import java.util.stream.Collectors;
/**
 * Classe resposavel por mappear e transportar informação entre dominio e entidade.
 *
 * @author Gabriel Silva Lima
 * @since 30/09/2021
 */
public class CategoriaMapperResponse {

    /**
     * Construtor vazio pra evitar instanciação.
     */
    private CategoriaMapperResponse() {
    }

    /**
     * Metodo responsavel por conter a informação de entidade a camada de dominio.
     * @param categoria {@code CategoriaEntity} -
     * @return CategoriaDomainResponse
     */
    public static CategoriaDomainResponse toDomain(CategoriaEntity categoria) {
        return CategoriaDomainResponse.builder()
                .id(categoria.getId())
                .nome(categoria.getNome())
                .build();
    }

    /**
     * Metodo que transforma uma lista de categoria em uma stream e devolve uma lista de categorias.
     * @param categoriaEntities {@code CategoriaEntity}
     * @return categoriaEntities
     */
    public static List<CategoriaDomainResponse> toCollectionDomain(List<CategoriaEntity> categoriaEntities) {
        return categoriaEntities.stream()
                .map(CategoriaMapperResponse::toDomain)
                .collect(Collectors.toList());
    }
}

