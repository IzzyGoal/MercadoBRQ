package com.mercadobrq.www.MercadoBRQ.usecase.utils;

import com.mercadobrq.www.MercadoBRQ.usecase.domain.request.CategoriaDomainRequest;
import com.mercadobrq.www.MercadoBRQ.usecase.domain.response.CategoriaDomainResponse;
import com.mercadobrq.www.MercadoBRQ.usecase.domain.response.ProdutoDomainResponse;
import com.mercadobrq.www.MercadoBRQ.usecase.exceptions.BadResquestPostException;
import com.mercadobrq.www.MercadoBRQ.usecase.exceptions.CategoryNotFoundException;
import com.mercadobrq.www.MercadoBRQ.usecase.exceptions.EntityAlreadyExistsException;
import com.mercadobrq.www.MercadoBRQ.usecase.gateway.CategoriaGateway;
import org.apache.commons.lang3.StringUtils;
import java.util.Objects;

public class CategoriaUseCaseUtils {

    private static final String MENSAGEM_ERRO_REMOVER_CATEGORIA_EM_USO = "A categoria com o código %s, não pode ser removida, esta em uso;";
    private static final String MENSAGEM_ERRO_CATEGORIA_JA_EXISTE = "Não foi possivel criar a categoria, porque ela já existe.";
    private static final String MENSAGEM_CATEGORIA_NAO_ENCONTRADA = "Essa Categoria nao existe.";

    private CategoriaUseCaseUtils() {
    }

    public static void checkifCategoryExist(CategoriaDomainResponse category, Long idCategoria) {
        if (Objects.isNull(category)) {
            throw new CategoryNotFoundException(String.format(MENSAGEM_CATEGORIA_NAO_ENCONTRADA, idCategoria));
        }
    }

    public static void checkifcategoryAreBePresent(CategoriaDomainRequest categoriaDomainRequest, CategoriaDomainResponse categoryDomainName) {
        if (StringUtils.isNotBlank(categoryDomainName.getNome())) {
            throw new EntityAlreadyExistsException(String.format(MENSAGEM_ERRO_CATEGORIA_JA_EXISTE, categoriaDomainRequest.getNome()));
        }
    }

    public static void checkIfCategoryAlreadyExist(Long idCategoria, CategoriaDomainResponse category) {
        if (Objects.isNull(category.getId())) {
            throw new BadResquestPostException(String.format(MENSAGEM_ERRO_CATEGORIA_JA_EXISTE, idCategoria));
        }
    }
}

