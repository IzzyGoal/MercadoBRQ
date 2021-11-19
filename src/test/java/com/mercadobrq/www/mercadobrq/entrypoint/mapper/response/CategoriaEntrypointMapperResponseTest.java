package com.mercadobrq.www.mercadobrq.entrypoint.mapper.response;

import com.mercadobrq.www.mercadobrq.entrypoint.model.response.CategoriaModelResponse;
import com.mercadobrq.www.mercadobrq.usecase.domain.response.CategoriaDomainResponse;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoriaEntrypointMapperResponseTest {

    @Test
    void toModelSucess() {
        CategoriaModelResponse categoria = CategoriaEntryopintMapperResponse.toModel(getMockCategoriaDomainResponse());
        assertAll(
                () -> assertEquals(1L, categoria.getId()),
                () -> assertEquals("Bebidas", categoria.getNome())
        );
    }

    @Test
    void toCollectionModelSucess() {
        List<CategoriaModelResponse> categorias = CategoriaEntryopintMapperResponse.
                toCollectionModel(List.of(getMockCategoriaDomainResponse()));
        assertAll(
                () -> assertEquals(1L, categorias.get(0).getId()),
                () -> assertEquals("Bebidas", categorias.get(0).getNome())
        );
    }

    private CategoriaDomainResponse getMockCategoriaDomainResponse() {
        return CategoriaDomainResponse.builder()
                .id(1L)
                .nome("Bebidas")
                .build();
    }
}
