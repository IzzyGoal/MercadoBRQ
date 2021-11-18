package com.mercadobrq.www.mercadobrq.entrypoint.mapper.request;

import com.mercadobrq.www.mercadobrq.entrypoint.model.request.TabelaNutricionalEntrypointModelResquest;
import com.mercadobrq.www.mercadobrq.usecase.domain.request.TabelaNutricionalDomainRequest;

public class TabelaNutricionalEntrypointMapperRequest {
    /**
     * Construtor vazio para evitar instanciação
     */
    private TabelaNutricionalEntrypointMapperRequest() {
    }

    public  static TabelaNutricionalDomainRequest toDomain(TabelaNutricionalEntrypointModelResquest tabela) {

        return TabelaNutricionalDomainRequest.builder()
                .valorEnergetico(tabela.getValorEnergetico())
                .gorduraSaturada(tabela.getGorduraSaturada())
                .sodio(tabela.getSodio())
                .acucar(tabela.getAcucar())
                .proteinas(tabela.getProteinas())
                .fibras(tabela.getFibras())
                .build();
    }
}
