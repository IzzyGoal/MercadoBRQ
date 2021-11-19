package com.mercadobrq.www.mercadobrq.entrypoint.mapper.request;

import com.mercadobrq.www.mercadobrq.entrypoint.model.request.CategoriaIDModelRequest;
import com.mercadobrq.www.mercadobrq.entrypoint.model.request.ProdutoModelRequest;
import com.mercadobrq.www.mercadobrq.entrypoint.model.request.TabelaNutricionalEntrypointModelResquest;
import com.mercadobrq.www.mercadobrq.usecase.domain.request.ProdutoDomainRequest;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProdutoEntrypointMapperRequestTest {

    @Test
    void toDomainAddSucess() {
        ProdutoDomainRequest produtoDomainRequest = ProdutoEntrypointMapperRequest
                .toDomainAdd(getMockProdutoModelRequest());
        assertAll(
                () -> assertEquals("Fanta", produtoDomainRequest.getNome()),
                () -> assertEquals("Refrigerante sabor laranja", produtoDomainRequest.getDescricao()),
                () -> assertEquals("Fanta", produtoDomainRequest.getMarca()),
                () -> assertEquals(10, produtoDomainRequest.getQuantidade()),
                () -> assertEquals(BigDecimal.valueOf(9.99), produtoDomainRequest.getPreco()),
                () -> assertEquals(Boolean.TRUE, produtoDomainRequest.getAtivo()),
                () -> assertEquals(Boolean.FALSE, produtoDomainRequest.getOfertado()),
                () -> assertEquals(0, produtoDomainRequest.getPorcentagem()),
                () -> assertEquals(1L, produtoDomainRequest.getCategoria().getId()),
                () -> assertEquals("50KCal", produtoDomainRequest.getTabelaNutricional().getValorEnergetico()),
                () -> assertEquals("0g", produtoDomainRequest.getTabelaNutricional().getGorduraSaturada()),
                () -> assertEquals("0g", produtoDomainRequest.getTabelaNutricional().getSodio()),
                () -> assertEquals("15g", produtoDomainRequest.getTabelaNutricional().getAcucar()),
                () -> assertEquals("2g", produtoDomainRequest.getTabelaNutricional().getProteinas()),
                () -> assertEquals("0g", produtoDomainRequest.getTabelaNutricional().getFibras())
        );

    }

    private ProdutoModelRequest getMockProdutoModelRequest() {
        return ProdutoModelRequest.builder()
                .nome("Fanta")
                .descricao("Refrigerante sabor laranja")
                .marca("Fanta")
                .quantidade(10)
                .preco(BigDecimal.valueOf(9.99))
                .ativo(true)
                .ofertado(false)
                .porcentagem(0)
                .categoria(getMockCategoriaforProductEntityResponse())
                .tabelaNutricional(getMockTabelaNutricionalForProductEntityResponse())
                .build();
    }

    private TabelaNutricionalEntrypointModelResquest getMockTabelaNutricionalForProductEntityResponse() {
        return TabelaNutricionalEntrypointModelResquest.builder()
                .valorEnergetico("50KCal")
                .gorduraSaturada("0g")
                .sodio("0g")
                .acucar("15g")
                .proteinas("2g")
                .fibras("0g")
                .build();
    }

    private CategoriaIDModelRequest getMockCategoriaforProductEntityResponse() {
        return CategoriaIDModelRequest.builder()
                .id(1L)
                .build();
    }
}
