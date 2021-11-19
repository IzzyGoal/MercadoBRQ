package com.mercadobrq.www.mercadobrq.dataprovider.mapper.request;


import com.mercadobrq.www.mercadobrq.dataprovider.entity.CategoriaEntity;
import com.mercadobrq.www.mercadobrq.usecase.domain.request.CategoriaDomainRequest;
import com.mercadobrq.www.mercadobrq.usecase.domain.response.CategoriaDomainResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoriaDataProviderMapperRequestTest {

    @Test
    void toEntityUpdateSucces(){
        CategoriaEntity categoriaEntity = CategoriaMapperRequest.toEntityUpdate((getMockCategoriaEntityDomainResponse()));

        assertAll(
                () -> assertEquals(1L,categoriaEntity.getId()),
                () -> assertEquals("Bebidas",categoriaEntity.getNome())
        );
    }

    @Test
    void toEntitysucess(){
        CategoriaEntity categoriaEntity = CategoriaMapperRequest.toEntity((getMockCategoriaEntityResponseToEntity()));

        assertAll(
                () -> assertEquals("Bebidas",categoriaEntity.getNome())
        );
    }

    @Test
    void toProvideIDSucess(){
        CategoriaEntity categoriaEntity = CategoriaMapperRequest.toProvideID((getMockCategoriaEntityResponseToEntity()));

        assertAll(
                () -> assertEquals(1L,categoriaEntity.getId())

        );
    }

    @Test
    void toProvideIDUpdateSucess(){
        CategoriaEntity categoriaEntity = CategoriaMapperRequest.toProvideIDUpdate((getMockCategoriaEntityDomainResponse()));

        assertAll(
                () -> assertEquals(1L,categoriaEntity.getId())
        );
    }

    private CategoriaDomainRequest getMockCategoriaEntityResponseToEntity() {
        return CategoriaDomainRequest.builder()
                .id(1L)
                .nome("Bebidas")
                .build();
    }

    private CategoriaDomainResponse getMockCategoriaEntityDomainResponse() {
        return CategoriaDomainResponse.builder()
                .id(1L)
                .nome("Bebidas")
                .build();
    }

}
