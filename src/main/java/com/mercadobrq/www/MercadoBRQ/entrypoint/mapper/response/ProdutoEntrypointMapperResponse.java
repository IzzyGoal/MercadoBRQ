package com.mercadobrq.www.MercadoBRQ.entrypoint.mapper.response;

import com.mercadobrq.www.MercadoBRQ.entrypoint.model.response.CategoriaModelResponse;
import com.mercadobrq.www.MercadoBRQ.entrypoint.model.response.ProdutoModelResponse;
import com.mercadobrq.www.MercadoBRQ.entrypoint.model.response.ProdutoModelResponseShort;
import com.mercadobrq.www.MercadoBRQ.usecase.domain.response.ProdutoDomainResponse;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

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
                .ativo(product.getAtivo())
                .ofertado(product.getOfertado())
                .porcentagem(product.getPorcentagem())
                .categoria(categoriaResponse(product))
                .build();
    }

    private static CategoriaModelResponse categoriaResponse(ProdutoDomainResponse product) {
        return CategoriaModelResponse.builder()
                .id(product.getCategoria().getId())
                .nome(product.getCategoria().getNome())
                .build();

    }

    public static List<ProdutoModelResponse> toCollectionModel(List<ProdutoDomainResponse> product) {
       return product.stream()
               .map(ProdutoEntrypointMapperResponse::toModel)
               .collect(Collectors.toList());
    }

    public static Page<ProdutoModelResponseShort> toCollectionModelShort(Page<ProdutoDomainResponse> produtoDomain) {
        return produtoDomain.map(ProdutoEntrypointMapperResponse::toModelShort);
    }

    private static ProdutoModelResponseShort toModelShort(ProdutoDomainResponse produtoDomainResponse) {
        return ProdutoModelResponseShort.builder()
                .id(produtoDomainResponse.getId())
                .nome(produtoDomainResponse.getNome())
                .marca(produtoDomainResponse.getMarca())
                .quantidade(produtoDomainResponse.getQuantidade())
                .preço(produtoDomainResponse.getPreco())
                .ofertado(produtoDomainResponse.getOfertado())
                .porcentagem(produtoDomainResponse.getPorcentagem())
                .build();
    }
}
