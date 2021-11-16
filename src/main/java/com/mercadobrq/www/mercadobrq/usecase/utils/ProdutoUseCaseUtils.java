package com.mercadobrq.www.mercadobrq.usecase.utils;

import com.mercadobrq.www.mercadobrq.entrypoint.model.response.ProdutoModelResponseShort;
import com.mercadobrq.www.mercadobrq.usecase.domain.request.ProdutoDomainRequest;
import com.mercadobrq.www.mercadobrq.usecase.domain.response.ProdutoDomainResponse;
import com.mercadobrq.www.mercadobrq.usecase.exceptions.*;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

public class ProdutoUseCaseUtils {
    private static final String MENSAGEM_PRODUTO_NAO_EXISTE = "O produto do ID digitado nao foi encontrado";
    private static final String MENSAGEM_PRODUTO_QUANTIDADE_ZERO = "A quantidade de produto nao pode ser igual ou menor que 0";
    private static final String MENSAGEM_PRODUTO_PORCENTAGEM_ZERO = "A porcentagem de produto nao pode ser menor ou igual a zero";
    private static final String MENSAGEM_PRODUTO_INATIVO_PARA_OFERTA = "O produto nao esta ativo a oferta por tanto essa propiedade nao pode ser alterada";
    private static final String MENSAGEM_PRODUTO_OFERTAD0_ATIVO = "O produto '%s' nao pode ser ofertado , pois não esta ativo";



    /**
     * Metodo responsavel por validar se produto existe de acordo com o seu ID e retorna uma exceção
     * HttpStatus 404 - Not Found.
     * @param product {@code ProdutoDomainResponse} - Requisição do usuario.
     * @param idProduct {@code Long} - ID do produto.
     */
    public static void CheckIfProductExist(ProdutoDomainResponse product, Long idProduct) {
        if (Objects.nonNull((product.getId()))) {
        }
        throw new ProductNotExistException(String.format(MENSAGEM_PRODUTO_NAO_EXISTE, idProduct));
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
    public static void checkIfQuantityIsNotZero(ProdutoDomainRequest quantidade) {
        if (quantidade.getQuantidade() <= 0) {
            throw new ProductQuantityIsZeroExcpetion(String.format(MENSAGEM_PRODUTO_QUANTIDADE_ZERO));
        }
    }
    public static void checkIfQuantityIsNotZeroForUpdate(ProdutoDomainResponse quantidade, Boolean product) {
        if (quantidade.getQuantidade() <= 0) {
            throw new ProductQuantityIsZeroExcpetion(String.format(MENSAGEM_PRODUTO_QUANTIDADE_ZERO));
        }
    }

    public static void checkIfPercentageIsZero(ProdutoDomainResponse porcentagem) {
        if (porcentagem.getPorcentagem() == 0) {
            throw new ProductPercentageIsZeroException(String.format(MENSAGEM_PRODUTO_PORCENTAGEM_ZERO));
        }
    }

    public static void productInactiveForPorcentage() {
        throw new ProductInactiveForPorcentageException(String.format(MENSAGEM_PRODUTO_INATIVO_PARA_OFERTA));
    }

    public static void checkActiveForQuantity(ProdutoDomainResponse productOrigin, ProdutoDomainResponse product) {
        if(Objects.nonNull(productOrigin.getAtivo())) {
            checkIfQuantityIsNotZeroForUpdate(product,productOrigin.getAtivo());
        }
    }

    public static void checIfActiveForOff(ProdutoDomainResponse productOrigin, ProdutoDomainResponse product) {
        if (Objects.nonNull(productOrigin.getOfertado())){
            if (Objects.equals(product.getAtivo(),true)) {
                if (Objects.equals(productOrigin.getAtivo(),false)){
                    throw new BadBusyException(String.format(MENSAGEM_PRODUTO_OFERTAD0_ATIVO,  product.getNome()));
                }
            }
        }
    }

    public static void checkIfOffAndPercentageIsNull(ProdutoDomainResponse productOrigin, ProdutoDomainResponse product) {
        if (Objects.nonNull(productOrigin.getOfertado()) && Objects.nonNull(productOrigin.getPorcentagem())) {
            checkIfPercentageIsZero(productOrigin);
            }
        }


}
