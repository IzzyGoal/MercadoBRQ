package com.mercadobrq.www.MercadoBRQ.usecase;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class CategoriaDomainResponse {

    private Long id;
    private String nome;
}
