package com.mercadobrq.www.mercadobrq.usecase;

import com.mercadobrq.www.mercadobrq.usecase.domain.response.ProdutoDomainResponse;
import com.mercadobrq.www.mercadobrq.usecase.exceptions.EmptyOff;
import com.mercadobrq.www.mercadobrq.usecase.gateway.OfertaGateway;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OfertaUseCase {

    private static final String SEM_OFERTAS_DISPONIVEIS = "Sem Ofertas Disponiveis";
    private final OfertaGateway ofertaGateway;

    public Page<ProdutoDomainResponse> findAllOffers(Pageable pageable) {
        if (pageable.isUnpaged()) {
            throw new EmptyOff(String.format(SEM_OFERTAS_DISPONIVEIS));
        }
        else {
        return ofertaGateway.FindAllOffers(pageable);
        }
    }
}
