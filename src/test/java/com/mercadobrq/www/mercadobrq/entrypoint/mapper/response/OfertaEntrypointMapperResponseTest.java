package com.mercadobrq.www.mercadobrq.entrypoint.mapper.response;

import com.mercadobrq.www.mercadobrq.entrypoint.model.response.ProdutoModelResponseShort;
import com.mercadobrq.www.mercadobrq.usecase.domain.response.ProdutoDomainResponse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OfertaEntrypointMapperResponseTest {
    @Test
    void toDomainSucess() {
        ProdutoModelResponseShort produtoOferta = OfertaEntrypointMapperResponse
                .toDomain(getMockProdutoDomainResponse());
        assertAll(
                () -> assertEquals(1L, produtoOferta.getId()),
                () -> assertEquals("Fanta", produtoOferta.getNome()),
                () -> assertEquals("Fanta", produtoOferta.getMarca()),
                () -> assertEquals(10, produtoOferta.getQuantidade()),
                () -> assertEquals(BigDecimal.valueOf(9.99), produtoOferta.getPreco()),
                () -> assertEquals(0, produtoOferta.getPorcentagem())
        );
    }

    private ProdutoDomainResponse getMockProdutoDomainResponse() {
        return ProdutoDomainResponse.builder()
                .id(1L)
                .nome("Fanta")
                .marca("Fanta")
                .quantidade(10)
                .preco(BigDecimal.valueOf(9.99))
                .porcentagem(0)
                .build();
    }
}
