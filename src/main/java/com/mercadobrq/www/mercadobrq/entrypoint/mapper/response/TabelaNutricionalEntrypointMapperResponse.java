package com.mercadobrq.www.mercadobrq.entrypoint.mapper.response;

import com.mercadobrq.www.mercadobrq.dataprovider.entity.TabelaNutricionalEntity;
import com.mercadobrq.www.mercadobrq.entrypoint.model.response.TabelaNutricionalEntrypointModelResponse;
import com.mercadobrq.www.mercadobrq.usecase.domain.response.TabelaNutricionalDomainResponse;

public class TabelaNutricionalEntrypointMapperResponse {
    /**
     * Construtor privado para evitar instanciação.
     */
    private TabelaNutricionalEntrypointMapperResponse() {
    }

    public static TabelaNutricionalEntrypointModelResponse toModel(TabelaNutricionalDomainResponse tabela) {
        return TabelaNutricionalEntrypointModelResponse.builder()
                .valorEnergetico(tabela.getValorEnergetico())
                .gorduraSaturada(tabela.getGorduraSaturada())
                .sodio(tabela.getSodio())
                .acucar(tabela.getAcucar())
                .proteinas(tabela.getProteinas())
                .fibras(tabela.getFibras())
                .build();
    }

    public static TabelaNutricionalDomainResponse toDomainWithExpand(TabelaNutricionalEntity tabelaNutricional, String expand) {
        return TabelaNutricionalDomainResponse.builder()
                .valorEnergetico(tabelaNutricional.getValorEnergetico())
                .gorduraSaturada(tabelaNutricional.getGorduraSaturada())
                .sodio(tabelaNutricional.getSodio())
                .acucar(tabelaNutricional.getAcucar())
                .proteinas(tabelaNutricional.getProteinas())
                .fibras(tabelaNutricional.getFibras())
                .build();
    }

    public static TabelaNutricionalDomainResponse toDomain(TabelaNutricionalEntity tabelaNutricional) {
        return TabelaNutricionalDomainResponse.builder()
                .valorEnergetico(tabelaNutricional.getValorEnergetico())
                .gorduraSaturada(tabelaNutricional.getGorduraSaturada())
                .sodio(tabelaNutricional.getSodio())
                .acucar(tabelaNutricional.getAcucar())
                .proteinas(tabelaNutricional.getProteinas())
                .fibras(tabelaNutricional.getFibras())
                .build();
    }
}
