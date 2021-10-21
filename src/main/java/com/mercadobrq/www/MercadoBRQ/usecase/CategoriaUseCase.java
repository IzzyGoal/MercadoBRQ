package com.mercadobrq.www.MercadoBRQ.usecase;

import com.mercadobrq.www.MercadoBRQ.usecase.domain.request.CategoriaDomainRequest;
import com.mercadobrq.www.MercadoBRQ.usecase.domain.response.CategoriaDomainResponse;
import com.mercadobrq.www.MercadoBRQ.usecase.exceptions.EntityInUseException;
import com.mercadobrq.www.MercadoBRQ.usecase.gateway.CategoriaGateway;
import com.mercadobrq.www.MercadoBRQ.usecase.utils.CategoriaUseCaseUtils;
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
        CategoriaDomainResponse categoryDomainName = findCatgeoryWithName(categoriaDomainRequest.getNome());
        CategoriaUseCaseUtils.checkifcategoryAreBePresent(categoriaDomainRequest,categoryDomainName);

            return categoriaGateway.addCategory(categoriaDomainRequest);
    }

    public List<CategoriaDomainResponse> buscarCategorias() {
        return  categoriaGateway.sarchAll();
    }

    private CategoriaDomainResponse findCatgeoryWithName(String nomeCategoria) {
        return categoriaGateway.findCategoryWithName(nomeCategoria);
    }

    public CategoriaDomainResponse atualizarCategoria(Long idCategoria,CategoriaDomainRequest categorianNew) {
        CategoriaDomainResponse categoriaDomainAtual = buscarCategoriaPorID(idCategoria);
        CategoriaDomainResponse categoriaDomainNome = findCatgeoryWithName(categoriaDomainAtual.getNome());
        CategoriaUseCaseUtils.checkifcategoryAreBePresent(categorianNew,categoriaDomainNome);
            categoriaDomainAtual = CategoriaDomainResponse.builder()
                    .id(categoriaDomainAtual.getId())
                    .nome(categorianNew.getNome())
                    .build();

            return categoriaGateway.updateCategory(categoriaDomainAtual);
    }

    public CategoriaDomainResponse buscarCategoriaPorID(Long idCategoria) {

        CategoriaDomainResponse category = categoriaGateway.findCategoryWithId(idCategoria);
        CategoriaUseCaseUtils.checkifCategoryExist(category,idCategoria);

            return category;
    }

    public void removerCategoriaPorID(Long idCategoria) {

        buscarCategoriaPorID(idCategoria);
        try {
            categoriaGateway.deleteCategoryWithId(idCategoria);
        } catch (DataIntegrityViolationException ex) {
            throw new EntityInUseException(String.format(MENSAGEM_ERRO_AO_REMOVER_CATEGORIA,idCategoria));
        }
    }
}

