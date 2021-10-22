package com.mercadobrq.www.MercadoBRQ.dataprovider.mapper.response;

import com.mercadobrq.www.MercadoBRQ.dataprovider.entity.ProdutoEntity;
import com.mercadobrq.www.MercadoBRQ.usecase.domain.response.ProdutoDomainResponse;
import org.springframework.data.domain.Page;

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
    private ProdutoDataProviderMapperResponse() {}

    /**
     * Metodo responsavel por gerar um corpto de resposta para o dominio.
     * @param product {@code ProdutoEntity} - Entidade de produto.
     * @return ProdutoDomainResponse
     */
    public static ProdutoDomainResponse toDomain(ProdutoEntity product) {
        return ProdutoDomainResponse.builder()
                .id(product.getId())
                .nome(product.getNome())
                .descricao(product.getDescricao())
                .marca(product.getMarca())
                .quantidade(product.getQuantidade())
                .preco(product.getPreco())
                .ativo(product.getAtivo())
                .ofertado(product.getOfertado())
                .porcentagem(product.getPorcetagem())
                .categoria(CategoriaMapperResponse.toDomain(product.getCategoria()))
                .build();
    }

    /**
     * Metodo repsonsavel por gerar uma lista de respostas para o dominio.
     * @param productEntities {@code ProdutoEntity } - Entidade de produto.
     * @return uma lista de ProdutoDomainResponse
     */
    public static Page<ProdutoDomainResponse> toCollectionDomain(Page<ProdutoEntity> productEntities) {

        return productEntities.map(ProdutoDataProviderMapperResponse::toDomain);
    }
}
