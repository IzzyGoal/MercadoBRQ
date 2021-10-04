package com.mercadobrq.www.MercadoBRQ.dataprovider.mapper.response;

import com.mercadobrq.www.MercadoBRQ.dataprovider.entity.ProdutoEntity;
import com.mercadobrq.www.MercadoBRQ.usecase.domain.response.ProdutoDomainResponse;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe resposavel por mappear e transportar informação entre dominio e entidade.
 *
 * @author Gabriel Silva Lima
 * @since 04/10/2021
 */
public class ProdutoDataProviderMapperResponse {

    /**
     * Construtor vazio para evitar instanciação.
     */
    private ProdutoDataProviderMapperResponse() {
    }

    public static ProdutoDomainResponse toDomain(ProdutoEntity product) {
        return ProdutoDomainResponse.builder()
                .id(product.getId())
                .nome(product.getNome())
                .descricao(product.getDescricao())
                .marca(product.getMarca())
                .quantidade(product.getQuantidade())
                .preco(product.getPreco())
                .ativo(true)
                .ofertado(false)
                .porcentagem(0)
                .build();
    }

    public static List<ProdutoDomainResponse> toCollectionDomain(List<ProdutoEntity> product) {
        return product.stream()
                .map(ProdutoDataProviderMapperResponse::toDomain)
                .collect(Collectors.toList());

    }
}
