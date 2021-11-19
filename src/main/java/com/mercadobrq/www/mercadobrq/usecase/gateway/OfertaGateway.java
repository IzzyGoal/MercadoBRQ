package com.mercadobrq.www.mercadobrq.usecase.gateway;

import com.mercadobrq.www.mercadobrq.usecase.domain.response.ProdutoDomainResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OfertaGateway {
    Page<ProdutoDomainResponse> FindAllOffers(Pageable pageable);
}
