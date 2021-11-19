package com.mercadobrq.www.mercadobrq.dataprovider.mapper.response;

import com.mercadobrq.www.mercadobrq.dataprovider.entity.CategoriaEntity;
import com.mercadobrq.www.mercadobrq.dataprovider.entity.ProdutoEntity;
import com.mercadobrq.www.mercadobrq.dataprovider.entity.TabelaNutricionalEntity;
import com.mercadobrq.www.mercadobrq.usecase.domain.response.ProdutoDomainResponse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProdutoDataProviderMapperResponseTest {

    @Test
    void toDomain() {
        ProdutoDomainResponse produtoDomainResponse = ProdutoDataProviderMapperResponse.toDomain(getMockProdutoEntity());

        assertAll(
                () -> assertEquals("Fanta",produtoDomainResponse.getNome()),
                () -> assertEquals("Refrigerante sabor laranja", produtoDomainResponse.getDescricao()),
                () -> assertEquals("Fanta",produtoDomainResponse.getMarca()),
                () -> assertEquals(10,produtoDomainResponse.getQuantidade()),
                () -> assertEquals(BigDecimal.valueOf(9.99),produtoDomainResponse.getPreco()),
                () -> assertEquals(Boolean.TRUE,produtoDomainResponse.getAtivo()),
                () -> assertEquals(Boolean.FALSE,produtoDomainResponse.getOfertado()),
                () -> assertEquals(0,produtoDomainResponse.getPorcentagem()),
                () -> assertEquals(1L,produtoDomainResponse.getCategoria().getId()),
                () -> assertEquals("Bebidas",produtoDomainResponse.getCategoria().getNome()),
                () -> assertEquals("50KCal",produtoDomainResponse.getTabela_nutricional().getValor_energetico()),
                () -> assertEquals("0g",produtoDomainResponse.getTabela_nutricional().getGordura_saturada()),
                () -> assertEquals("0g",produtoDomainResponse.getTabela_nutricional().getSodio()),
                () -> assertEquals("15g",produtoDomainResponse.getTabela_nutricional().getAcucar()),
                () -> assertEquals("2g",produtoDomainResponse.getTabela_nutricional().getProteinas()),
                () -> assertEquals("0g",produtoDomainResponse.getTabela_nutricional().getFibras())
        );
    }

    @Test
    void toDomainWithExpandSucess() {
        String expand = "tabela_nutricional";
        ProdutoDomainResponse produtoDomainResponse = ProdutoDataProviderMapperResponse
                .toDomainWithExpand(getMockProdutoEntity(), expand);
        assertAll(
                () -> assertEquals("Fanta",produtoDomainResponse.getNome()),
                () -> assertEquals("Refrigerante sabor laranja", produtoDomainResponse.getDescricao()),
                () -> assertEquals("Fanta",produtoDomainResponse.getMarca()),
                () -> assertEquals(10,produtoDomainResponse.getQuantidade()),
                () -> assertEquals(BigDecimal.valueOf(9.99),produtoDomainResponse.getPreco()),
                () -> assertEquals(Boolean.TRUE,produtoDomainResponse.getAtivo()),
                () -> assertEquals(Boolean.FALSE,produtoDomainResponse.getOfertado()),
                () -> assertEquals(0,produtoDomainResponse.getPorcentagem()),
                () -> assertEquals(1L,produtoDomainResponse.getCategoria().getId()),
                () -> assertEquals("Bebidas",produtoDomainResponse.getCategoria().getNome()),
                () -> assertEquals("50KCal",produtoDomainResponse.getTabela_nutricional().getValor_energetico()),
                () -> assertEquals("0g",produtoDomainResponse.getTabela_nutricional().getGordura_saturada()),
                () -> assertEquals("0g",produtoDomainResponse.getTabela_nutricional().getSodio()),
                () -> assertEquals("15g",produtoDomainResponse.getTabela_nutricional().getAcucar()),
                () -> assertEquals("2g",produtoDomainResponse.getTabela_nutricional().getProteinas()),
                () -> assertEquals("0g",produtoDomainResponse.getTabela_nutricional().getFibras())
        );

    }

    private ProdutoEntity getMockProdutoEntity() {
        return ProdutoEntity.builder()
                .nome("Fanta")
                .descricao("Refrigerante sabor laranja")
                .marca("Fanta")
                .quantidade(10)
                .preco(BigDecimal.valueOf(9.99))
                .ativo(true)
                .ofertado(false)
                .porcetagem(0)
                .categoria(getMockCategoriaforProductEntityResponse())
                .tabelaNutricional(getMockTabelaNutricionalForProductEntityResponse())
                .build();
    }

    private TabelaNutricionalEntity getMockTabelaNutricionalForProductEntityResponse() {
        return TabelaNutricionalEntity.builder()
                .valorEnergetico("50KCal")
                .gorduraSaturada("0g")
                .sodio("0g")
                .acucar("15g")
                .proteinas("2g")
                .fibras("0g")
                .build();
    }

    private CategoriaEntity getMockCategoriaforProductEntityResponse() {
        return CategoriaEntity.builder()
                .id(1L)
                .nome("Bebidas")
                .build();
    }
}
