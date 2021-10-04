package com.mercadobrq.www.MercadoBRQ.usecase.gateway;

import com.mercadobrq.www.MercadoBRQ.usecase.domain.request.ProdutoDomainRequest;
import com.mercadobrq.www.MercadoBRQ.usecase.domain.response.ProdutoDomainResponse;

import java.util.List;

/**
 * Interface dos recursos logicos da aplicação.
 *
 * @author Gabriel Silva Lima
 * @since 30/09/2021
 */
public interface ProdutoGateway {

    ProdutoDomainResponse addProduct(ProdutoDomainRequest produtoDomainRequest);

    List<ProdutoDomainResponse> searchAll();

    ProdutoDomainResponse findWithID(Long idProduct);

    ProdutoDomainResponse updateProduct(ProdutoDomainResponse newProduct);

    ProdutoDomainResponse partiallyUpdate(ProdutoDomainResponse productChanged);

    void deleteProduct(Long idProduct);
}
