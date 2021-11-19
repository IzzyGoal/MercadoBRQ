package com.mercadobrq.www.mercadobrq.dataprovider.provedor;

import com.mercadobrq.www.mercadobrq.dataprovider.entity.ProdutoEntity;
import com.mercadobrq.www.mercadobrq.dataprovider.mapper.response.OfertaMapperResponse;
import com.mercadobrq.www.mercadobrq.dataprovider.repository.OfertaRespository;
import com.mercadobrq.www.mercadobrq.usecase.domain.response.ProdutoDomainResponse;
import com.mercadobrq.www.mercadobrq.usecase.gateway.OfertaGateway;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class OfertaImplemetation implements OfertaGateway {
    OfertaRespository ofertaRespository;

    @Override
    public Page<ProdutoDomainResponse> FindAllOffers(Pageable pageable) {
        Page<ProdutoEntity> produtoEntitiesinOff = ofertaRespository.buscarProdutoEmOferta(pageable);

        return OfertaMapperResponse.toCollectionDomain(produtoEntitiesinOff);
    }
}
