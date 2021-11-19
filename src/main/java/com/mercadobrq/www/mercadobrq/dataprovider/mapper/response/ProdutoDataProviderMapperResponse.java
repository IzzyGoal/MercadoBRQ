package com.mercadobrq.www.mercadobrq.dataprovider.mapper.response;

import com.mercadobrq.www.mercadobrq.dataprovider.entity.ProdutoEntity;
import com.mercadobrq.www.mercadobrq.entrypoint.mapper.response.TabelaNutricionalEntrypointMapperResponse;
import com.mercadobrq.www.mercadobrq.usecase.domain.response.ProdutoDomainResponse;
import com.mercadobrq.www.mercadobrq.usecase.domain.response.TabelaNutricionalDomainResponse;
import org.springframework.data.domain.Page;

import java.util.Objects;

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
                .tabela_nutricional(TabelaNutricionalEntrypointMapperResponse.toDomain(product.getTabelaNutricional()))
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

    public static ProdutoDomainResponse toDomainWithExpand(ProdutoEntity produtoEntity, String expand) {
        return ProdutoDomainResponse.builder()
                .id(produtoEntity.getId())
                .nome(produtoEntity.getNome())
                .descricao(produtoEntity.getDescricao())
                .marca(produtoEntity.getMarca())
                .quantidade(produtoEntity.getQuantidade())
                .preco(produtoEntity.getPreco())
                .ativo(produtoEntity.getAtivo())
                .ofertado(produtoEntity.getOfertado())
                .porcentagem(produtoEntity.getPorcetagem())
                .categoria(CategoriaMapperResponse.toDomain(produtoEntity.getCategoria()))
                .tabela_nutricional(TabelaNutricionalEntrypointMapperResponse.toDomainWithExpand(produtoEntity
                        .getTabelaNutricional(), expand))
                .build();
    }
}
