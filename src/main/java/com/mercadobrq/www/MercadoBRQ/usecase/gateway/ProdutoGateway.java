package com.mercadobrq.www.MercadoBRQ.usecase.gateway;

import com.mercadobrq.www.MercadoBRQ.usecase.domain.request.ProdutoDomainRequest;
import com.mercadobrq.www.MercadoBRQ.usecase.domain.response.ProdutoDomainResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Interface dos recursos logicos da aplicação.
 *
 * @author Gabriel Silva Lima
 * @since 30/09/2021
 */
public interface ProdutoGateway {

    ProdutoDomainResponse addProduct(ProdutoDomainRequest produtoDomainRequest);

    ProdutoDomainResponse findWithID(Long idProduct);

    ProdutoDomainResponse updateProduct(ProdutoDomainResponse newProduct);

    ProdutoDomainResponse partiallyUpdate(ProdutoDomainResponse productChanged);

    void deleteProduct(Long idProduct);

    Page<ProdutoDomainResponse> searchProductforCategory(Pageable pageable, String Category);

    Page<ProdutoDomainResponse> searchProductforBrand(Pageable pageable, String Brand);

    Page<ProdutoDomainResponse> searchAllProduct(Pageable pageable);
}
