package com.mercadobrq.www.mercadobrq.dataprovider.mapper.response;

import com.mercadobrq.www.mercadobrq.dataprovider.entity.ProdutoEntity;
import com.mercadobrq.www.mercadobrq.usecase.domain.response.ProdutoDomainResponse;
import org.springframework.data.domain.Page;

public class OfertaMapperResponse {
    private OfertaMapperResponse(){

    }

    public static Page<ProdutoDomainResponse> toCollectionDomain(Page<ProdutoEntity> productInOff) {
        return productInOff.map(OfertaMapperResponse::toDomain);
    }

    public static ProdutoDomainResponse toDomain(ProdutoEntity produtoEntity) {
        return ProdutoDomainResponse.builder()
                .id(produtoEntity.getId())
                .nome(produtoEntity.getNome())
                .marca(produtoEntity.getMarca())
                .descricao(produtoEntity.getDescricao())
                .quantidade(produtoEntity.getQuantidade())
                .preco(produtoEntity.getPreco())
                .porcentagem(produtoEntity.getPorcetagem())
                .build();
    }
}
