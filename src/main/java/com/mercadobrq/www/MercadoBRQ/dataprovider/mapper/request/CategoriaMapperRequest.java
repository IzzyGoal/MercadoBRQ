package com.mercadobrq.www.MercadoBRQ.dataprovider.mapper.request;

import com.mercadobrq.www.MercadoBRQ.dataprovider.entity.CategoriaEntity;
import com.mercadobrq.www.MercadoBRQ.usecase.domain.request.CategoriaDomainRequest;
import com.mercadobrq.www.MercadoBRQ.usecase.domain.response.CategoriaDomainResponse;
import java.util.Objects;

/**
 * Classe responsavel por preencher os dados do dominio com dados da entidade
 *
 * @author Gabriel Silva Lima
 * @since 30/09/2021
 */
public class CategoriaMapperRequest {

    /**
     * Construtor vazio para evitar instanciação.
     */
    private CategoriaMapperRequest() {
    }

    /**
     * Metodo resposavel por compor de forma logica o processo de atualização das informações da categoria provendo
     * as informações da entidade.
     * @param category - {@code CategoriaDomainResponse } -
     * @return CategoriaEntity
     */
    public static CategoriaEntity toEntityUpdate(CategoriaDomainResponse category) {
        return CategoriaEntity.builder()
                .id(category.getId())
                .nome(category.getNome())
                .build();
    }

    /**
     * Metodo que retorna os dados a uma entidade.
     * @param category {@code CategoriaDomainRequest } -
     * @return CategoriaEntity
     */
    public static CategoriaEntity toEntity(CategoriaDomainRequest category) {
        return CategoriaEntity.builder()
                .nome(category.getNome())
                .build();
    }

    /**
     * Metodo responsavel por validar e gerar uma objeto de categoria para produtos.
     * @param category{@code - CategoriaDomainRequest} -
     * @return 1. se nao existir uma categoria ele retornará um objeto vazio.
     *         2. se existir retornará suas informações.
     */
    public static CategoriaEntity toEntityProduct(CategoriaDomainRequest category) {
        if (Objects.isNull(category)) {
            return CategoriaEntity.builder().build();
        }
        return CategoriaEntity.builder()
                .id(category.getId())
                .build();
    }

    /**
     * Metodo responsavel por validar e gerar uma objeto atualizado de categoria para produtos.
     * @param category {@code CategoriaDomainResponse} -
     * @return 1. se nao existir uma categoria ele retornará um objeto vazio.
     *         2. se existir retornará suas informações.
     */
    public static CategoriaEntity toEntityProductAtualizado(CategoriaDomainResponse category) {
        if (Objects.isNull(category)) {
            return CategoriaEntity.builder().build();
        }

        return CategoriaEntity.builder()
                .id(category.getId())
                .build();
    }
}
