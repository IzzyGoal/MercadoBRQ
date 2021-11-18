package com.mercadobrq.www.mercadobrq.usecase.utils;

import com.mercadobrq.www.mercadobrq.usecase.domain.request.CategoriaDomainRequest;
import com.mercadobrq.www.mercadobrq.usecase.domain.response.CategoriaDomainResponse;
import com.mercadobrq.www.mercadobrq.usecase.exceptions.BadResquestPostException;
import com.mercadobrq.www.mercadobrq.usecase.exceptions.CategoryNotFoundException;
import com.mercadobrq.www.mercadobrq.usecase.exceptions.EntityAlreadyExistsException;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class CategoriaUseCaseUtils {

    private static final String MENSAGEM_CATEGORIA_JA_EXISTE_NOME = "Não foi possivel alterar o atributo  '%s' da respectiva categoria pois ele ja existe";
    private static final String MENSAGEM_ERRO_CATEGORIA_JA_EXISTE = "Não foi possivel criar a categoria %s, porque ela já existe.";
    private static final String MENSAGEM_CATEGORIA_NAO_ENCONTRADA = "A categoria '%s' nao existe .";
    private static final String MENSAGEM_CATEGORIA_PRODUTO_NAO_EXISTE = "A CATEGORIA onde esta sendo cadastrado esse produto nao existe";
    private static final String MENSAGEM_CATEGORIA_ATRIBUTOS_NAO_PODEM_SER_NULOS_VAZIOS = "O nome da categoria nao pode ser nulo";

    private CategoriaUseCaseUtils() {
    }

    public static void checkifCategoryExist(CategoriaDomainResponse category, Long idCategoria) {
        if (Objects.isNull(category.getId())) {
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

    public static void checkifCategoryExistName(CategoriaDomainRequest categorianNew, CategoriaDomainResponse categoryName) {
        if (StringUtils.isNotBlank(categoryName.getNome())) {
            throw new EntityAlreadyExistsException(
                    String.format(MENSAGEM_CATEGORIA_JA_EXISTE_NOME,categorianNew.getNome()));
        }
    }

    public static void checkIfCategoryExistForProduct(Long id, CategoriaDomainResponse categoriaDomainResponse) {
        if (Objects.isNull(categoriaDomainResponse.getId())){
            throw new BadResquestPostException(String.format(MENSAGEM_CATEGORIA_PRODUTO_NAO_EXISTE, id));
        }
    }
}

