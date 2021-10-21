package com.mercadobrq.www.MercadoBRQ.usecase.utils;

import com.mercadobrq.www.MercadoBRQ.usecase.Exceptions.ProductNotExistException;
import com.mercadobrq.www.MercadoBRQ.usecase.domain.response.ProdutoDomainResponse;

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
