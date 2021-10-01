package com.mercadobrq.www.MercadoBRQ.usecase.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class CategoriaDomainRequest {
    private String nome;
}
