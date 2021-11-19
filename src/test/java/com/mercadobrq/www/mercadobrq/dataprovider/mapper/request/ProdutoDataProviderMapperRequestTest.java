package com.mercadobrq.www.mercadobrq.dataprovider.mapper.request;

import com.mercadobrq.www.mercadobrq.dataprovider.entity.ProdutoEntity;
import com.mercadobrq.www.mercadobrq.usecase.domain.request.CategoriaDomainRequest;
import com.mercadobrq.www.mercadobrq.usecase.domain.request.ProdutoDomainRequest;
import com.mercadobrq.www.mercadobrq.usecase.domain.request.TabelaNutricionalDomainRequest;
import com.mercadobrq.www.mercadobrq.usecase.domain.response.CategoriaDomainResponse;
import com.mercadobrq.www.mercadobrq.usecase.domain.response.ProdutoDomainResponse;
import com.mercadobrq.www.mercadobrq.usecase.domain.response.TabelaNutricionalDomainResponse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ProdutoDataProviderMapperRequestTest {

    @Test
    void toEntitySucess(){
        ProdutoEntity produtoEntity = ProdutoDataProviderMapperResquest.toEntity(getMockProdutoDomainResquest());
        assertAll(
                () -> assertEquals("Fanta",produtoEntity.getNome()),
                () -> assertEquals("Refrigerante sabor laranja", produtoEntity.getDescricao()),
                () -> assertEquals("Fanta",produtoEntity.getMarca()),
                () -> assertEquals(10,produtoEntity.getQuantidade()),
                () -> assertEquals(BigDecimal.valueOf(9.99),produtoEntity.getPreco()),
                () -> assertEquals(Boolean.TRUE,produtoEntity.getAtivo()),
                () -> assertEquals(Boolean.FALSE,produtoEntity.getOfertado()),
                () -> assertEquals(0,produtoEntity.getPorcetagem()),
                () -> assertEquals(1L,produtoEntity.getCategoria().getId()),
                () -> assertEquals("50KCal",produtoEntity.getTabelaNutricional().getValorEnergetico()),
                () -> assertEquals("0g",produtoEntity.getTabelaNutricional().getGorduraSaturada()),
                () -> assertEquals("0g",produtoEntity.getTabelaNutricional().getSodio()),
                () -> assertEquals("15g",produtoEntity.getTabelaNutricional().getAcucar()),
                () -> assertEquals("2g",produtoEntity.getTabelaNutricional().getProteinas()),
                () -> assertEquals("0g",produtoEntity.getTabelaNutricional().getFibras())
        );
    }

    @Test
    void toEntityUpdateSucess(){
        ProdutoEntity produtoEntity = ProdutoDataProviderMapperResquest.toEntityUpdate(getMockProdutoDomainResponse());

        assertAll(
                () -> assertEquals("Fanta",produtoEntity.getNome()),
                () -> assertEquals("Refrigerante sabor laranja", produtoEntity.getDescricao()),
                () -> assertEquals("Fanta",produtoEntity.getMarca()),
                () -> assertEquals(10,produtoEntity.getQuantidade()),
                () -> assertEquals(BigDecimal.valueOf(9.99),produtoEntity.getPreco()),
                () -> assertEquals(Boolean.TRUE,produtoEntity.getAtivo()),
                () -> assertEquals(Boolean.FALSE,produtoEntity.getOfertado()),
                () -> assertEquals(0,produtoEntity.getPorcetagem()),
                () -> assertEquals(1L,produtoEntity.getCategoria().getId()),
                () -> assertEquals("50KCal",produtoEntity.getTabelaNutricional().getValorEnergetico()),
                () -> assertEquals("0g",produtoEntity.getTabelaNutricional().getGorduraSaturada()),
                () -> assertEquals("0g",produtoEntity.getTabelaNutricional().getSodio()),
                () -> assertEquals("15g",produtoEntity.getTabelaNutricional().getAcucar()),
                () -> assertEquals("2g",produtoEntity.getTabelaNutricional().getProteinas()),
                () -> assertEquals("0g",produtoEntity.getTabelaNutricional().getFibras())
        );

    }

    private ProdutoDomainResponse getMockProdutoDomainResponse() {
        return ProdutoDomainResponse.builder()
                .nome("Fanta")
                .descricao("Refrigerante sabor laranja")
                .marca("Fanta")
                .quantidade(10)
                .preco(BigDecimal.valueOf(9.99))
                .ativo(true)
                .ofertado(false)
                .porcentagem(0)
                .categoria(getMockCategoriaforProductEntityResponse())
                .tabela_nutricional(getMockTabelaNutricionalForProductEntityResponse())
                .build();
    }

    private TabelaNutricionalDomainResponse getMockTabelaNutricionalForProductEntityResponse() {
        return TabelaNutricionalDomainResponse.builder()
                .valor_energetico("50KCal")
                .gordura_saturada("0g")
                .sodio("0g")
                .acucar("15g")
                .proteinas("2g")
                .fibras("0g")
                .build();
    }


    private CategoriaDomainResponse getMockCategoriaforProductEntityResponse() {
        return CategoriaDomainResponse.builder()
                .id(1L)
                .build();
    }

    private ProdutoDomainRequest getMockProdutoDomainResquest() {
        return ProdutoDomainRequest.builder()
                .nome("Fanta")
                .descricao("Refrigerante sabor laranja")
                .marca("Fanta")
                .quantidade(10)
                .preco(BigDecimal.valueOf(9.99))
                .ativo(true)
                .ofertado(false)
                .porcentagem(0)
                .categoria(getMockCategoriaforProductEntityRequest())
                .tabelaNutricional(getMockTabelaNutricionalForProductEntity())
                .build();
    }

    private TabelaNutricionalDomainRequest getMockTabelaNutricionalForProductEntity() {
        return TabelaNutricionalDomainRequest.builder()
                .valorEnergetico("50KCal")
                .gorduraSaturada("0g")
                .sodio("0g")
                .acucar("15g")
                .proteinas("2g")
                .fibras("0g")
                .build();
    }

    private CategoriaDomainRequest getMockCategoriaforProductEntityRequest() {
        return CategoriaDomainRequest.builder()
                .id(1L)
                .build();
    }
}
