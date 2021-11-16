package com.mercadobrq.www.mercadobrq.usecase.exceptions;

public class ProductPercentageIsZeroException extends EntityAlreadyExistsException{

    private static final long serialVersionUID = 1L;

    public ProductPercentageIsZeroException(String menssagem) {
        super(menssagem);
    }
}
