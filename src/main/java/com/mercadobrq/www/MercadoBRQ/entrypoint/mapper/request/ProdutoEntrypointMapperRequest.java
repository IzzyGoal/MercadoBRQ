package com.mercadobrq.www.MercadoBRQ.entrypoint.mapper.request;

import com.mercadobrq.www.MercadoBRQ.dataprovider.mapper.request.CategoriaMapperRequest;
import com.mercadobrq.www.MercadoBRQ.entrypoint.mapper.response.CategoriaEntryopintMapperResponse;
import com.mercadobrq.www.MercadoBRQ.entrypoint.model.request.CategoriaModelRequest;
import com.mercadobrq.www.MercadoBRQ.entrypoint.model.request.ProdutoModelRequest;
import com.mercadobrq.www.MercadoBRQ.usecase.domain.request.CategoriaDomainRequest;
import com.mercadobrq.www.MercadoBRQ.usecase.domain.request.ProdutoDomainRequest;

/**
 * Classe reponsavel por fazer a transformação do dado model ao domain
 * @author Gabriel Silva Lima
 * @since 04/10/2021
 */
public class ProdutoEntrypointMapperRequest {

    /**
     * Contrutor privado para evitar instanciação.
     */
    private ProdutoEntrypointMapperRequest() {
    }

    /**
     * Meotod respponsavel por promover informação de requisição ao dominio produto.
     * @param product {@code ProdutoModelRequest} -
     * @return ProdutoDomainRequest
     */
    public static ProdutoDomainRequest toDomain(ProdutoModelRequest product) {
        return ProdutoDomainRequest.builder()
                .nome(product.getNome())
                .descricao(product.getDescricao())
                .marca(product.getMarca())
                .quantidade(product.getQuantidade())
                .preco(product.getPreco())
                .categoria(CategoriaEntrypointMapperRequest.toDomainProduct(product.getCategoria()))
                .build();
    }

    public static ProdutoDomainRequest toDomainUpdate(ProdutoModelRequest productModel) {
        return  ProdutoDomainRequest.builder()
                .nome(productModel.getNome())
                .descricao(productModel.getDescricao())
                .marca(productModel.getMarca())
                .quantidade(productModel.getQuantidade())
                .preco(productModel.getPreco())
                .ativo(productModel.getAtivo())
                .ofertado(productModel.getOfertado())
                .porcentagem(productModel.getPorcentagem())
                .categoria(CategoriaEntrypointMapperRequest.toDomainProduct(productModel.getCategoria()))
                .build();
    }
}
