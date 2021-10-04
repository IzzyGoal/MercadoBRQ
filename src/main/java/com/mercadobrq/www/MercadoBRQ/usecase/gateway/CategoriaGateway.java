package com.mercadobrq.www.MercadoBRQ.usecase.gateway;

import com.mercadobrq.www.MercadoBRQ.usecase.domain.request.CategoriaDomainRequest;
import com.mercadobrq.www.MercadoBRQ.usecase.domain.response.CategoriaDomainResponse;
import java.util.List;

/**
 * Interface dos recursos logicos da aplicação.
 *
 * @author Gabriel Silva Lima
 * @since 30/09/2021
 */
public interface CategoriaGateway {

    CategoriaDomainResponse addCategory(CategoriaDomainRequest categoriaDomainRequest);

    List<CategoriaDomainResponse> findCategory();

    CategoriaDomainResponse findCategoryWithId(Long idCategoria);

    void deleteCategoryWithId(Long idCategoria);

    CategoriaDomainResponse updateCategory(CategoriaDomainResponse categoriaAtual);
}
