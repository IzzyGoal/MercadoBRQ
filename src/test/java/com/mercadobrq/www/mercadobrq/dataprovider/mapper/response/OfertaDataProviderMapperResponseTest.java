package com.mercadobrq.www.mercadobrq.dataprovider.mapper.response;

import com.mercadobrq.www.mercadobrq.dataprovider.entity.ProdutoEntity;
import com.mercadobrq.www.mercadobrq.usecase.domain.response.ProdutoDomainResponse;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OfertaDataProviderMapperResponseTest {

    @Test
    void toDomain() {
        ProdutoDomainResponse produtoDomainResponse = OfertaMapperResponse.toDomain(getMockProdutoEntity());

        assertAll(
                () -> assertEquals("Coca Cola",produtoDomainResponse.getNome()),
                () -> assertEquals("Refrigerante Coca Cola", produtoDomainResponse.getDescricao()),
                () -> assertEquals("Coca Cola",produtoDomainResponse.getMarca()),
                () -> assertEquals(10,produtoDomainResponse.getQuantidade()),
                () -> assertEquals(BigDecimal.valueOf(9.99),produtoDomainResponse.getPreco()),
                () -> assertEquals(0, produtoDomainResponse.getPorcentagem())
        );
    }

    private ProdutoEntity getMockProdutoEntity() {
        return ProdutoEntity.builder()
                .id(1L)
                .nome("Coca Cola")
                .marca("Coca Cola")
                .descricao("Refrigerante Coca Cola")
                .quantidade(10)
                .preco(BigDecimal.valueOf(9.99))
                .porcetagem(0)
                .build();
    }

}
