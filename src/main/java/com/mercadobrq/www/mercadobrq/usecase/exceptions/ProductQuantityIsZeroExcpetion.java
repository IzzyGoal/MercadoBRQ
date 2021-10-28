package com.mercadobrq.www.mercadobrq.usecase.exceptions;

public class ProductQuantityIsZeroExcpetion extends EntityAlreadyExistsException{

    private static final long serialVersionUID = 1L;

    public ProductQuantityIsZeroExcpetion(String menssagem) {
        super(menssagem);
    }
}
