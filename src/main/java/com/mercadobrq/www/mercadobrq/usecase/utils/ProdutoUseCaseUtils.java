package com.mercadobrq.www.mercadobrq.usecase.utils;

import com.mercadobrq.www.mercadobrq.entrypoint.model.response.ProdutoModelResponseShort;
import com.mercadobrq.www.mercadobrq.usecase.exceptions.ProductBlankException;
import com.mercadobrq.www.mercadobrq.usecase.exceptions.ProductNotExistException;
import com.mercadobrq.www.mercadobrq.usecase.domain.response.ProdutoDomainResponse;
import com.mercadobrq.www.mercadobrq.usecase.exceptions.ProductQuantityIsZeroExcpetion;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

public class ProdutoUseCaseUtils {

    private static final String MENSAGEM_PRODUTO_NAO_EXISTE = "O produto do ID respectivo nao foi encontrado";
    private static final String MENSAGEM_PRODUTO_QUANTIDADE_ZERO = "A quantidade de produto nao pode ser igual ou menor que 0";

    private ProdutoUseCaseUtils() { }

    /**
     * Metodo responsavel por validar se produto existe de acordo com o seu ID e retorna uma exceção
     * HttpStatus 404 - Not Found.
     * @param product {@code ProdutoDomainResponse} - Requisição do usuario.
     * @param idProduct {@code Long} - ID do produto.
     */
    public static void CheckIfProductExist(ProdutoDomainResponse product, Long idProduct) {
        if (Objects.isNull(product.getId())) {
            throw new ProductNotExistException(String.format(MENSAGEM_PRODUTO_NAO_EXISTE, idProduct));
        }
    }

    /**
     * Metodo responsavel por tratar a exceção onde a lista de produtos retorna vazia
     * @return HttpStatus 204.
     */
    public static ResponseEntity<Page<ProdutoModelResponseShort>> ProductIsBlankorNullException() {
    throw new ProductBlankException(String.format(""));
    }

    /**
     * Metodo responsavel por tratar a exceção de quando a quantidade de produto é igual ou menor que ZERO.
     * o retorno é 422 - Unprocessable
     * @param quantidade {@code Integer} - Quantidade de produtos.
     */
    public static void CheckIfQuantityIsNotZero(Integer quantidade) {
        if (quantidade >= 0){
            throw new ProductQuantityIsZeroExcpetion(String.format(MENSAGEM_PRODUTO_QUANTIDADE_ZERO));
        }
    }
}
