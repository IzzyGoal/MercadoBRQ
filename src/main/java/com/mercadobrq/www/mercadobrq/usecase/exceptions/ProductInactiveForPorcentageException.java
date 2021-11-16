package com.mercadobrq.www.mercadobrq.usecase.exceptions;

public class ProductInactiveForPorcentageException extends EntityAlreadyExistsException{
    private static final long serialVersionUID = 1L;

    public ProductInactiveForPorcentageException(String menssagem) {
        super(menssagem);
    }
}
