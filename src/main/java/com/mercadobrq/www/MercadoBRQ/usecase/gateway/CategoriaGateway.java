package com.mercadobrq.www.MercadoBRQ.usecase.gateway;

import com.mercadobrq.www.MercadoBRQ.usecase.domain.CategoriaDomainRequest;
import com.mercadobrq.www.MercadoBRQ.usecase.domain.CategoriaDomainResponse;
import java.util.List;

public interface CategoriaGateway {

    CategoriaDomainResponse addCategory(CategoriaDomainRequest categoriaDomainRequest);

    List<CategoriaDomainResponse> findCategory();

    CategoriaDomainResponse findCategoryWithId(Long idCategoria);

    void deleteCategoryWithId(Long idCategoria);

    CategoriaDomainResponse updateCategory(CategoriaDomainResponse categoriaAtual);
}
