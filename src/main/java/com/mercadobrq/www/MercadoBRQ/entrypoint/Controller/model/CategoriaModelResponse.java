package com.mercadobrq.www.MercadoBRQ.entrypoint.Controller.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CategoriaModelResponse {

    private Long id;
    private String nome;
}
