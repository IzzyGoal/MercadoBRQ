package com.mercadobrq.www.mercadobrq.usecase.exceptions;

public class ProductBlankException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ProductBlankException(String menssagem) {
        super(menssagem);
    }
}
