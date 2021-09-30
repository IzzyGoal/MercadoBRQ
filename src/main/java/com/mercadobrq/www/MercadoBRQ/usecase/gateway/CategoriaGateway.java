package com.mercadobrq.www.MercadoBRQ.usecase.gateway;

import com.mercadobrq.www.MercadoBRQ.usecase.CategoriaDomainRequest;
import com.mercadobrq.www.MercadoBRQ.usecase.CategoriaDomainResponse;
import java.util.List;

public interface CategoriaGateway {

    CategoriaDomainResponse cadastrarCategorias(CategoriaDomainRequest categoriaDomainRequest);

    List<CategoriaDomainResponse> buscarCatgeorias();

    CategoriaDomainResponse buscarCategoriaPorId(Long idCategoria);

    void removerCategoriaPorID(Long idCategoria);

    CategoriaDomainResponse atualizarCategoria(CategoriaDomainResponse categoriaAtual);
}
