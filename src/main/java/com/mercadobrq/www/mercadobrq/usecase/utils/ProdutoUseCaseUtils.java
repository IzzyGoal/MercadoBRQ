package com.mercadobrq.www.mercadobrq.usecase.utils;

import com.mercadobrq.www.mercadobrq.usecase.exceptions.ProductNotExistException;
import com.mercadobrq.www.mercadobrq.usecase.domain.response.ProdutoDomainResponse;

import java.util.Objects;

public class ProdutoUseCaseUtils {

    private static final String MENSAGEM_PRODUTO_NAO_EXISTE = "O produto do ID respectivo nao foi encontrado";

    private ProdutoUseCaseUtils() { }

    public static void CheckIfProductExist(ProdutoDomainResponse product, Long idProduct) {
        if (Objects.isNull(product.getId())) {
            throw new ProductNotExistException(String.format(MENSAGEM_PRODUTO_NAO_EXISTE, idProduct));
        }
    }
}
