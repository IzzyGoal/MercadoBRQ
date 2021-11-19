package com.mercadobrq.www.mercadobrq.dataprovider.mapper.request;

import com.mercadobrq.www.mercadobrq.dataprovider.entity.TabelaNutricionalEntity;
import com.mercadobrq.www.mercadobrq.entrypoint.model.request.TabelaNutricionalEntrypointModelResquest;
import com.mercadobrq.www.mercadobrq.usecase.domain.request.TabelaNutricionalDomainRequest;
import com.mercadobrq.www.mercadobrq.usecase.domain.response.TabelaNutricionalDomainResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TabelaNutricionalDataProvideMapperRequestTest {

    @Test
    void toDomainSucess() {
        TabelaNutricionalDomainRequest tabelaNutricionalDomainRequest = TabelaNutricionalDataProviderMapperRequest
                .toDomain(getMockTabelaNutricionalModelResquest());

        assertAll(
                () -> assertEquals("50KCal",tabelaNutricionalDomainRequest.getValorEnergetico()),
                () -> assertEquals("0g",tabelaNutricionalDomainRequest.getGorduraSaturada()),
                () -> assertEquals("0g",tabelaNutricionalDomainRequest.getSodio()),
                () -> assertEquals("15g",tabelaNutricionalDomainRequest.getAcucar()),
                () -> assertEquals("2g",tabelaNutricionalDomainRequest.getProteinas()),
                () -> assertEquals("0g",tabelaNutricionalDomainRequest.getFibras())
        );
    }

    @Test
    void toEntitySucess() {
        TabelaNutricionalEntity tabelaEntity = TabelaNutricionalDataProviderMapperRequest
                .toEntity(getMockTabelaDomainRequest());

        assertAll(
                () -> assertEquals("50KCal",tabelaEntity.getValorEnergetico()),
                () -> assertEquals("0g",tabelaEntity.getGorduraSaturada()),
                () -> assertEquals("0g",tabelaEntity.getSodio()),
                () -> assertEquals("15g",tabelaEntity.getAcucar()),
                () -> assertEquals("2g",tabelaEntity.getProteinas()),
                () -> assertEquals("0g",tabelaEntity.getFibras())
        );
    }

    @Test
    void toEntityUpdate() {
        TabelaNutricionalEntity tabelaEntity = TabelaNutricionalDataProviderMapperRequest.toEntityUpdate(getMockTabelaDomainResponse());
        assertAll(
                () -> assertEquals("50KCal",tabelaEntity.getValorEnergetico()),
                () -> assertEquals("0g",tabelaEntity.getGorduraSaturada()),
                () -> assertEquals("0g",tabelaEntity.getSodio()),
                () -> assertEquals("15g",tabelaEntity.getAcucar()),
                () -> assertEquals("2g",tabelaEntity.getProteinas()),
                () -> assertEquals("0g",tabelaEntity.getFibras())
        );
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

    private TabelaNutricionalDomainRequest getMockTabelaDomainRequest() {
        return TabelaNutricionalDomainRequest.builder()
                .valorEnergetico("50KCal")
                .gorduraSaturada("0g")
                .sodio("0g")
                .acucar("15g")
                .proteinas("2g")
                .fibras("0g")
                .build();
    }

    private TabelaNutricionalEntrypointModelResquest getMockTabelaNutricionalModelResquest() {
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
