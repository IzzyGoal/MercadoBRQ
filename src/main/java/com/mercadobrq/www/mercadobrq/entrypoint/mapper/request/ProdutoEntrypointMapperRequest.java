package com.mercadobrq.www.mercadobrq.entrypoint.mapper.request;

import com.mercadobrq.www.mercadobrq.entrypoint.model.request.ProdutoModelRequest;
import com.mercadobrq.www.mercadobrq.usecase.domain.request.ProdutoDomainRequest;

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
     * Meotodo respponsavel por promover informação de requisição ao dominio produto.
     * @param productModel {@code ProdutoModelRequest} -
     * @return ProdutoDomainRequest
     */
    public static ProdutoDomainRequest toDomainAdd(ProdutoModelRequest productModel) {
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
                .tabelaNutricional(TabelaNutricionalEntrypointMapperRequest.toDomain(productModel.getTabelaNutricional()))
                .build();
    }
}
