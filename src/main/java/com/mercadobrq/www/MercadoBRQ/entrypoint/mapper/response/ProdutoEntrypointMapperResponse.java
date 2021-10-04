package com.mercadobrq.www.MercadoBRQ.entrypoint.mapper.response;

import com.mercadobrq.www.MercadoBRQ.entrypoint.model.response.ProdutoModelResponse;
import com.mercadobrq.www.MercadoBRQ.usecase.domain.response.ProdutoDomainResponse;

import java.util.List;

/**
 * Classe responsavel por tranformar/transportar informação da camada domain para model.
 *
 * @author Gabriel Silva Lima
 * @since 04/10/2021
 */
public class ProdutoEntrypointMapperResponse {
    /**
     * Construtor privado para eviutar instanciação.
     */
    private ProdutoEntrypointMapperResponse(){
    }

    public static ProdutoModelResponse toModel(ProdutoDomainResponse product) {
        return  ProdutoModelResponse.builder()
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

//    public static List<ProdutoModelResponse> toCollectionModel(List<ProdutoDomainResponse> product) {
//        return product.stream()
//                .map(ProdutoModelResponse)
//    }

}
