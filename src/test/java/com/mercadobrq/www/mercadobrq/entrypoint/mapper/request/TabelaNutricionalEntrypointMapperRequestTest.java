package com.mercadobrq.www.mercadobrq.entrypoint.mapper.request;

import com.mercadobrq.www.mercadobrq.entrypoint.model.request.TabelaNutricionalEntrypointModelResquest;
import com.mercadobrq.www.mercadobrq.usecase.domain.request.TabelaNutricionalDomainRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TabelaNutricionalEntrypointMapperRequestTest {

    @Test
    void toDomainSucess () {
        TabelaNutricionalDomainRequest tabelaNutricional = TabelaNutricionalEntrypointMapperRequest
                .toDomain(getMockTabelaModelRequest());
        assertAll(
                () -> assertEquals("50KCal", tabelaNutricional.getValorEnergetico()),
                () -> assertEquals("0g", tabelaNutricional.getGorduraSaturada()),
                () -> assertEquals("0g", tabelaNutricional.getSodio()),
                () -> assertEquals("15g", tabelaNutricional.getAcucar()),
                () -> assertEquals("2g", tabelaNutricional.getProteinas()),
                () -> assertEquals("0g", tabelaNutricional.getFibras())
        );
    }

    private TabelaNutricionalEntrypointModelResquest getMockTabelaModelRequest() {
        return TabelaNutricionalEntrypointModelResquest.builder()
                .valorEnergetico("50KCal")
                .gorduraSaturada("0g")
                .sodio("0g")
                .acucar("15g")
                .proteinas("2g")
                .fibras("0g")
                .build();
    }
}
