package com.mercadobrq.www.MercadoBRQ.entrypoint.model.request;

import lombok.Getter;
import lombok.Setter;

import java.beans.ConstructorProperties;

@Getter
@Setter
public class ProdutoParameterModelResquest {

    private String nomeCategoria;
    private String marca;

    @ConstructorProperties(value = {"nome_categoria","marca"})
    public ProdutoParameterModelResquest(String nomeCategoria, String marca) {
        this.nomeCategoria = nomeCategoria;
        this.marca = marca;
    }
}
