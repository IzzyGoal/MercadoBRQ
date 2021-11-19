package com.mercadobrq.www.mercadobrq.entrypoint.mapper.response;

import com.mercadobrq.www.mercadobrq.dataprovider.entity.TabelaNutricionalEntity;
import com.mercadobrq.www.mercadobrq.entrypoint.model.response.TabelaNutricionalEntrypointModelResponse;
import com.mercadobrq.www.mercadobrq.usecase.domain.response.TabelaNutricionalDomainResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TabelaNutricionalEntrypointMapperResponseTest {
    @Test
    void toModelSucess() {
        TabelaNutricionalEntrypointModelResponse tabela = TabelaNutricionalEntrypointMapperResponse
                .toModel(getMockTabelaDomainResponse());

        assertAll(
                () -> assertEquals("50KCal",tabela.getValorEnergetico()),
                () -> assertEquals("0g",tabela.getGorduraSaturada()),
                () -> assertEquals("0g",tabela.getSodio()),
                () -> assertEquals("15g",tabela.getAcucar()),
                () -> assertEquals("2g",tabela.getProteinas()),
                () -> assertEquals("0g",tabela.getFibras())
        );
    }

    @Test
    void toDomainWithExpandSucess() {
        String expand = "tabela_nutricional";
        TabelaNutricionalDomainResponse tabela = TabelaNutricionalEntrypointMapperResponse
                .toDomainWithExpand(getMockTabelaEntity(), expand);
        assertAll(
                () -> assertEquals("50KCal",tabela.getValor_energetico()),
                () -> assertEquals("0g",tabela.getGordura_saturada()),
                () -> assertEquals("0g",tabela.getSodio()),
                () -> assertEquals("15g",tabela.getAcucar()),
                () -> assertEquals("2g",tabela.getProteinas()),
                () -> assertEquals("0g",tabela.getFibras())
        );
    }

    @Test
    void toDomain() {
        TabelaNutricionalDomainResponse tabela = TabelaNutricionalEntrypointMapperResponse.toDomain(getMockTabelaEntity());

        assertAll(
                () -> assertEquals("50KCal",tabela.getValor_energetico()),
                () -> assertEquals("0g",tabela.getGordura_saturada()),
                () -> assertEquals("0g",tabela.getSodio()),
                () -> assertEquals("15g",tabela.getAcucar()),
                () -> assertEquals("2g",tabela.getProteinas()),
                () -> assertEquals("0g",tabela.getFibras())
        );
    }

    private TabelaNutricionalEntity getMockTabelaEntity() {
        return TabelaNutricionalEntity.builder()
                .valorEnergetico("50KCal")
                .gorduraSaturada("0g")
                .sodio("0g")
                .acucar("15g")
                .proteinas("2g")
                .fibras("0g")
                .build();
    }

    private TabelaNutricionalDomainResponse getMockTabelaDomainResponse() {
        return TabelaNutricionalDomainResponse.builder()
                .valor_energetico("50KCal")
                .gordura_saturada("0g")
                .sodio("0g")
                .acucar("15g")
                .proteinas("2g")
                .fibras("0g")
                .build();

    }
}
