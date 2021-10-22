package com.mercadobrq.www.mercadobrq.dataprovider.mapper.response;

import com.mercadobrq.www.mercadobrq.dataprovider.entity.CategoriaEntity;
import com.mercadobrq.www.mercadobrq.usecase.domain.response.CategoriaDomainResponse;
import java.util.List;
import java.util.Objects;
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
     * @param category {@code CategoriaEntity} -
     * @return 1. se categoria for nula ira retornar um construtor vazio.
     *         2. se existir retornará suas informações.
     */
    public static CategoriaDomainResponse toDomain(CategoriaEntity category) {
        if (Objects.isNull(category)) {
            return CategoriaDomainResponse.builder().build();
        }
        return CategoriaDomainResponse.builder()
                .id(category.getId())
                .nome(category.getNome())
                .build();
    }

    /**
     * Metodo que transforma uma lista de categoria em uma stream e devolve uma lista de categorias.
     * @param categoryEntities {@code CategoriaEntity}
     * @return categoriaEntities
     */
    public static List<CategoriaDomainResponse> toCollectionDomain(List<CategoriaEntity> categoryEntities) {
        return categoryEntities.stream()
                .map(CategoriaMapperResponse::toDomain)
                .collect(Collectors.toList());
    }

    /**
     * Metodo responsavel por verificar se o id é nullo , se nao retorna um build para validação
     * @param categoriaEntity
     * @return 1 se categoria nao for nula retorna as informações
     *         2 se categoria for nulla, ela reforça o retorno nullo para posterior validação.
     */
    public static CategoriaDomainResponse toDomainID(CategoriaEntity categoriaEntity) {
        if (Objects.nonNull(categoriaEntity)){
            return CategoriaDomainResponse.builder()
                    .id(categoriaEntity.getId())
                    .nome(categoriaEntity.getNome())
                    .build();
        }
        return null;
    }
}
