package com.mercadobrq.www.mercadobrq.entrypoint.mapper.response;

import com.mercadobrq.www.mercadobrq.entrypoint.model.response.ProdutoModelResponseShort;
import com.mercadobrq.www.mercadobrq.usecase.domain.response.ProdutoDomainResponse;
import org.springframework.data.domain.Page;

public class OfertaEntrypointMapperResponse {
    private OfertaEntrypointMapperResponse() {

    }

    public static Page<ProdutoModelResponseShort> toCollection(Page<ProdutoDomainResponse> produtoDomainResponses){
        return produtoDomainResponses.map(OfertaEntrypointMapperResponse::toDomain);
    }

    public static ProdutoModelResponseShort toDomain(ProdutoDomainResponse produtoDomainResponse) {
        return ProdutoModelResponseShort.builder()
                .id(produtoDomainResponse.getId())
                .nome(produtoDomainResponse.getNome())
                .marca(produtoDomainResponse.getMarca())
                .quantidade(produtoDomainResponse.getQuantidade())
                .preco(produtoDomainResponse.getPreco())
                .porcentagem(produtoDomainResponse.getPorcentagem())
                .build();
    }
}
