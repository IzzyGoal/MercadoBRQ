package com.mercadobrq.www.mercadobrq.usecase;

import com.mercadobrq.www.mercadobrq.usecase.domain.request.CategoriaDomainRequest;
import com.mercadobrq.www.mercadobrq.usecase.domain.response.CategoriaDomainResponse;
import com.mercadobrq.www.mercadobrq.usecase.exceptions.EntityInUseException;
import com.mercadobrq.www.mercadobrq.usecase.gateway.CategoriaGateway;
import com.mercadobrq.www.mercadobrq.usecase.utils.CategoriaUseCaseUtils;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import java.util.List;

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

    private static final String MENSAGEM_ERRO_AO_REMOVER_CATEGORIA = "Erro ao remover categoria, esta em uso";

    private CategoriaGateway categoriaGateway;

    public CategoriaDomainResponse cadastrarCategoria(CategoriaDomainRequest categoriaDomainRequest) {
        CategoriaDomainResponse categoriaDomainResponse = findCategoryWithName(categoriaDomainRequest.getNome());
        CategoriaUseCaseUtils.checkifcategoryAreBePresent(categoriaDomainRequest,categoriaDomainResponse);

            return categoriaGateway.addCategory(categoriaDomainRequest);
    }

    public List<CategoriaDomainResponse> buscarCategorias() {
        return  categoriaGateway.sarchAll();
    }

    private CategoriaDomainResponse findCategoryWithName(String nomeCategoria) {
        return categoriaGateway.findCategoryWithName(nomeCategoria);
    }

    public CategoriaDomainResponse atualizarCategoria(Long idCategoria,CategoriaDomainRequest categorianNew) {
        CategoriaDomainResponse categoriaDomainAtual = buscarCategoriaPorID(idCategoria);
        CategoriaDomainResponse categoryName = findCategoryWithName(categorianNew.getNome());
        CategoriaUseCaseUtils.checkifCategoryExistName(categorianNew,categoryName);
            categoriaDomainAtual = CategoriaDomainResponse.builder()
                    .id(categoriaDomainAtual.getId())
                    .nome(categorianNew.getNome())
                    .build();

            return categoriaGateway.updateCategory(categoriaDomainAtual);
    }

    public void removerCategoriaPorID(Long idCategoria) {

        buscarCategoriaPorID(idCategoria);
        try {
            categoriaGateway.deleteCategoryWithId(idCategoria);
        } catch (DataIntegrityViolationException ex) {
            throw new EntityInUseException(String.format(MENSAGEM_ERRO_AO_REMOVER_CATEGORIA,idCategoria));
        }
    }

    public CategoriaDomainResponse buscarCategoriaPorID(Long idCategoria) {

        CategoriaDomainResponse category = categoriaGateway.findCategoryWithId(idCategoria);
        CategoriaUseCaseUtils.checkifCategoryExist(category,idCategoria);

        return category;
    }
}

