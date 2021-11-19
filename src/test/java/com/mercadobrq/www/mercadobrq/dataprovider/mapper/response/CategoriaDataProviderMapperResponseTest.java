package com.mercadobrq.www.mercadobrq.dataprovider.mapper.response;

import com.mercadobrq.www.mercadobrq.dataprovider.entity.CategoriaEntity;
import com.mercadobrq.www.mercadobrq.usecase.domain.response.CategoriaDomainResponse;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoriaDataProviderMapperResponseTest {

    @Test
    void toDomainSucess() {
        CategoriaDomainResponse categoriaDomainResponse = CategoriaMapperResponse.toDomain(getMockCategoriaEntity());
        assertAll(
                () -> assertEquals(1L, categoriaDomainResponse.getId()),
                () -> assertEquals("Bebidas", categoriaDomainResponse.getNome())
        );
    }

    @Test
    void toCollectionDomainSucess() {
        List<CategoriaDomainResponse> categoriaList = CategoriaMapperResponse.toCollectionDomain(List.of(getMockCategoriaEntity()));
        assertAll(
                () -> assertEquals(1L,categoriaList.get(0).getId()),
                () -> assertEquals("Bebidas", categoriaList.get(0).getNome())
        );
    }

    @Test
    void toDomainIdSucess() {
        CategoriaDomainResponse categoria = CategoriaMapperResponse.toDomainID(getMockCategoriaEntity());
        assertAll(
                () -> assertEquals(1L, categoria.getId()),
                () -> assertEquals("Bebidas", categoria.getNome())
        );
    }

    private CategoriaEntity getMockCategoriaEntity() {
        return CategoriaEntity.builder()
                .id(1L)
                .nome("Bebidas")
                .build();
    }
}
