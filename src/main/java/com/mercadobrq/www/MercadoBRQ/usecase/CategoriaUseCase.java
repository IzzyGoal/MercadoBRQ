package com.mercadobrq.www.MercadoBRQ.usecase;

import com.mercadobrq.www.MercadoBRQ.usecase.domain.request.CategoriaDomainRequest;
import com.mercadobrq.www.MercadoBRQ.usecase.domain.response.CategoriaDomainResponse;
import com.mercadobrq.www.MercadoBRQ.usecase.gateway.CategoriaGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Classe responsavel por intermediar a operação logica da aplicação e a comunicação com o banco de dados
 *
 * @author Gabriel Silva Lima
 * @since 30/09/2021
 *
 */
@AllArgsConstructor
@Service
public class CategoriaUseCase {

    private CategoriaGateway categoriaGateway;

    public CategoriaDomainResponse cadastrarCategoria(CategoriaDomainRequest categoriaDomainRequest) {
            return categoriaGateway.addCategory(categoriaDomainRequest);

    }

    public List<CategoriaDomainResponse> buscarCategorias() {
        return  categoriaGateway.findCategory();
    }

    private CategoriaDomainResponse findCatgeoryWithName(String name) {
        return categoriaGateway.findCategoryWithName(name);
    }

    public CategoriaDomainResponse atualizarCategoria(Long idCategoria,CategoriaDomainRequest categorianNew) {
        CategoriaDomainResponse categoriaDomainAtual = buscarCategoriaPorID(idCategoria);
            categoriaDomainAtual = CategoriaDomainResponse.builder()
                    .id(categoriaDomainAtual.getId())
                    .nome(categorianNew.getNome())
                    .build();

            return categoriaGateway.updateCategory(categoriaDomainAtual);
    }

    public CategoriaDomainResponse buscarCategoriaPorID(Long idCategoria) {
        CategoriaDomainResponse category = categoriaGateway.findCategoryWithId(idCategoria);

            return categoriaGateway.findCategoryWithId(idCategoria);
    }

    public void removerCategoriaPorID(Long idCategoria) {
        categoriaGateway.deleteCategoryWithId(idCategoria);
    }
}

