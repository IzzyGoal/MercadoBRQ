package com.mercadobrq.www.mercadobrq.usecase.utils;

import com.mercadobrq.www.mercadobrq.entrypoint.model.response.ProdutoModelResponseShort;
import com.mercadobrq.www.mercadobrq.usecase.exceptions.ProductBlankException;
import com.mercadobrq.www.mercadobrq.usecase.exceptions.ProductNotExistException;
import com.mercadobrq.www.mercadobrq.usecase.domain.response.ProdutoDomainResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

public class ProdutoUseCaseUtils {

    private static final String MENSAGEM_PRODUTO_NAO_EXISTE = "O produto do ID respectivo nao foi encontrado";

    private ProdutoUseCaseUtils() { }

    public static void CheckIfProductExist(ProdutoDomainResponse product, Long idProduct) {
        if (Objects.isNull(product.getId())) {
            throw new ProductNotExistException(String.format(MENSAGEM_PRODUTO_NAO_EXISTE, idProduct));
        }
    }

    public static ResponseEntity<Page<ProdutoModelResponseShort>> ProductIsBlankorNullException() {
    throw new ProductBlankException(String.format(""));
    }
}
