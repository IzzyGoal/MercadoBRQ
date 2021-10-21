package com.mercadobrq.www.MercadoBRQ.usecase.domain.request;

import lombok.Getter;
import java.beans.ConstructorProperties;

@Getter
public class ProdutoParameterModelResquest {
    private String nomeCategoria;
    private String marca;

    @ConstructorProperties(value = {"nome_categoria","marca"})
    public ProdutoParameterModelResquest(String nomeCategoria, String marca) {
        this.nomeCategoria = nomeCategoria;
        this.marca = marca;
    }
}
