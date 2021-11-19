package com.mercadobrq.www.mercadobrq.usecase;

import com.mercadobrq.www.mercadobrq.usecase.domain.response.ProdutoDomainResponse;
import com.mercadobrq.www.mercadobrq.usecase.gateway.OfertaGateway;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OfertaUseCase {

    private final OfertaGateway ofertaGateway;

    public Page<ProdutoDomainResponse> findAllOffers(Pageable pageable) {
        return ofertaGateway.FindAllOffers(pageable);
    }

}
