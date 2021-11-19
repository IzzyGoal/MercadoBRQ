package com.mercadobrq.www.mercadobrq.dataprovider.mapper.request;

import com.mercadobrq.www.mercadobrq.dataprovider.entity.TabelaNutricionalEntity;
import com.mercadobrq.www.mercadobrq.entrypoint.model.request.TabelaNutricionalEntrypointModelResquest;
import com.mercadobrq.www.mercadobrq.usecase.domain.request.TabelaNutricionalDomainRequest;
import com.mercadobrq.www.mercadobrq.usecase.domain.response.TabelaNutricionalDomainResponse;

/**
 * Classe responsavel por buildar as informações da tabela nutricional fornecida pelo usuario.
 *
 * @author Gabriel Silva Lima
 */
public class TabelaNutricionalDataProviderMapperRequest {

    /**
     * Construtor vazio para evitar instanciação
     */
    private TabelaNutricionalDataProviderMapperRequest() {
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

    public static TabelaNutricionalEntity toEntity(TabelaNutricionalDomainRequest tabelaNutricional) {
        return TabelaNutricionalEntity.builder()
                .valorEnergetico(tabelaNutricional.getValorEnergetico())
                .gorduraSaturada(tabelaNutricional.getGorduraSaturada())
                .sodio(tabelaNutricional.getSodio())
                .acucar(tabelaNutricional.getAcucar())
                .proteinas(tabelaNutricional.getProteinas())
                .fibras(tabelaNutricional.getFibras())
                .build();
    }

    public static TabelaNutricionalEntity toEntityUpdate(TabelaNutricionalDomainResponse tabelaNutricional) {
        return TabelaNutricionalEntity.builder()
                .valorEnergetico(tabelaNutricional.getValor_energetico())
                .gorduraSaturada(tabelaNutricional.getGordura_saturada())
                .sodio(tabelaNutricional.getSodio())
                .acucar(tabelaNutricional.getAcucar())
                .proteinas(tabelaNutricional.getProteinas())
                .fibras(tabelaNutricional.getFibras())
                .build();
    }
}
