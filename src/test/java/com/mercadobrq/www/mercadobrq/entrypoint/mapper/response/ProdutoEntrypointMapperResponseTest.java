package com.mercadobrq.www.mercadobrq.entrypoint.mapper.response;

import com.mercadobrq.www.mercadobrq.entrypoint.model.response.ProdutoModelResponse;
import com.mercadobrq.www.mercadobrq.entrypoint.model.response.ProdutoModelResponseShort;
import com.mercadobrq.www.mercadobrq.usecase.domain.response.CategoriaDomainResponse;
import com.mercadobrq.www.mercadobrq.usecase.domain.response.ProdutoDomainResponse;
import com.mercadobrq.www.mercadobrq.usecase.domain.response.TabelaNutricionalDomainResponse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProdutoEntrypointMapperResponseTest {

    @Test
    void toModelSucess() {
        ProdutoModelResponse produto = ProdutoEntrypointMapperResponse.toModel(getMockProdutoDomainResponse());

        assertAll(
                        () -> assertEquals("Fanta",produto.getNome()),
                        () -> assertEquals("Refrigerante sabor laranja", produto.getDescricao()),
                        () -> assertEquals("Fanta",produto.getMarca()),
                        () -> assertEquals(10,produto.getQuantidade()),
                        () -> assertEquals(BigDecimal.valueOf(9.99),produto.getPreco()),
                        () -> assertEquals(Boolean.TRUE,produto.getAtivo()),
                        () -> assertEquals(Boolean.FALSE,produto.getOfertado()),
                        () -> assertEquals(0,produto.getPorcentagem()),
                        () -> assertEquals(1L,produto.getCategoria().getId()),
                        () -> assertEquals("50KCal",produto.getTabelaNutricional().getValorEnergetico()),
                        () -> assertEquals("0g",produto.getTabelaNutricional().getGorduraSaturada()),
                        () -> assertEquals("0g",produto.getTabelaNutricional().getSodio()),
                        () -> assertEquals("15g",produto.getTabelaNutricional().getAcucar()),
                        () -> assertEquals("2g",produto.getTabelaNutricional().getProteinas()),
                        () -> assertEquals("0g",produto.getTabelaNutricional().getFibras())
        );
    }

    @Test
    void toModelShortSucess() {
        ProdutoModelResponseShort produto = ProdutoEntrypointMapperResponse
                .toModelShort(getMockProdutoDomainResponse());
        assertAll(
                () -> assertEquals("Fanta",produto.getNome()),
                () -> assertEquals("Fanta",produto.getMarca()),
                () -> assertEquals(10,produto.getQuantidade()),
                () -> assertEquals(BigDecimal.valueOf(9.99),produto.getPreco()),
                () -> assertEquals(Boolean.FALSE,produto.getOfertado()),
                () -> assertEquals(0,produto.getPorcentagem())
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
                .nome("Bebidas")
                .build();
    }

}
