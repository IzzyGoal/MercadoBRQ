package com.mercadobrq.www.MercadoBRQ.dataprovider.mapper.request;

import com.mercadobrq.www.MercadoBRQ.dataprovider.entity.ProdutoEntity;
import com.mercadobrq.www.MercadoBRQ.usecase.domain.request.ProdutoDomainRequest;
import com.mercadobrq.www.MercadoBRQ.usecase.domain.response.ProdutoDomainResponse;

/**
 * Classe responsavel por preencher os dados do dominio com dados da entidade
 *
 * @author Gabriel Silva Lima
 * @since 30/09/2021
 */
public class ProdutoDataProviderMapperResquest {

    /**
     * Construtor privado para evitar instanciação.
     */
    private ProdutoDataProviderMapperResquest() {
    }

    /**
     * Metodo responsavel por abastecer informação a entidade de produtos.
     * @param product {@code ProdutoDomainRequest} -
     * @return ProdutoEntity
     */
    public static ProdutoEntity toEntity(ProdutoDomainRequest product) {
        return ProdutoEntity.builder()
                .nome(product.getNome())
                .descricao(product.getDescricao())
                .marca(product.getMarca())
                .quantidade(product.getQuantidade())
                .preco(product.getPreco())
                .ativo(true)
                .ofertado(false)
                .porcetagem(0)
                .categoria(CategoriaMapperRequest.toProvideID((product.getCategoria())))
                .build();
    }

    /**
     * Metodo responsavel por atulizar as informações da entidade.
     * @param product {@code ProdutoDomainResponse} -
     * @return ProdutoEntity
     */
    public static ProdutoEntity toEntityUpdate(ProdutoDomainResponse product) {
        return ProdutoEntity.builder()
                .id(product.getId())
                .nome(product.getNome())
                .descricao(product.getDescricao())
                .marca(product.getMarca())
                .quantidade(product.getQuantidade())
                .preco(product.getPreco())
                .ativo(product.getAtivo())
                .ofertado(product.getOfertado())
                .porcetagem(product.getPorcentagem())
                .categoria(CategoriaMapperRequest.toProvideIDUpdate(product.getCategoria()))
                .build();
    }
}
