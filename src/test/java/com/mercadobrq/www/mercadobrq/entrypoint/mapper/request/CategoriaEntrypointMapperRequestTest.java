package com.mercadobrq.www.mercadobrq.entrypoint.mapper.request;

import com.mercadobrq.www.mercadobrq.entrypoint.model.request.CategoriaIDModelRequest;
import com.mercadobrq.www.mercadobrq.entrypoint.model.request.CategoriaModelRequest;
import com.mercadobrq.www.mercadobrq.usecase.domain.request.CategoriaDomainRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoriaEntrypointMapperRequestTest {

    @Test
    void toDomainSucess() {
        CategoriaDomainRequest categoriaDomainRequest = CategoriaEntrypointMapperRequest
                .toDomain(getMockCategoriaModelRequest());
        assertAll(
                () -> assertEquals("Bebidas", categoriaDomainRequest.getNome())
        );
    }

    @Test
    void toDomainProductSucess() {
        CategoriaDomainRequest categoriaDomainRequest = CategoriaEntrypointMapperRequest
                .toDomainProduct(getMockCategoriaIDModelRequest());
        assertAll(
                () -> assertEquals(1L, categoriaDomainRequest.getId())
        );
    }

    private CategoriaIDModelRequest getMockCategoriaIDModelRequest() {
        return CategoriaIDModelRequest.builder()
                .id(1L)
                .build();
    }

    private CategoriaModelRequest getMockCategoriaModelRequest() {
        return CategoriaModelRequest.builder()
                .nome("Bebidas")
                .build();
    }
}
