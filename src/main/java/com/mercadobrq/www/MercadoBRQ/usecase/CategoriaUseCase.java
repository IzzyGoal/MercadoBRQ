package com.mercadobrq.www.MercadoBRQ.usecase;

import com.mercadobrq.www.MercadoBRQ.usecase.gateway.CategoriaGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class CategoriaUseCase {

    private CategoriaGateway categoriaGateway;

    public CategoriaDomainResponse cadastrarCategoria(CategoriaDomainRequest categoriaDomainRequest) {
    return categoriaGateway.cadastrarCategorias(categoriaDomainRequest);
    }
    public List<CategoriaDomainResponse> buscarCategoria() {
        return  categoriaGateway.buscarCatgeorias();
    }

    public CategoriaDomainResponse atualizarCategoria(Long idCategoria,CategoriaDomainRequest categorianew) {
        CategoriaDomainResponse categoriaDomainAtual = buscarCategoriaPorID(idCategoria);
        categoriaDomainAtual.builder()
                .id(categoriaDomainAtual.getId())
                .nome(categorianew.getNome())
                .build();

        return categoriaGateway.atualizarCategoria(categoriaDomainAtual);

    }

    public CategoriaDomainResponse buscarCategoriaPorID(Long idCategoria) {
        return categoriaGateway.buscarCategoriaPorId(idCategoria);
    }

    public void removerCategoriaPorID(Long idCategoria) {
        categoriaGateway.removerCategoriaPorID(idCategoria);

    }
}

