package com.mercadobrq.www.MercadoBRQ.usecase;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class CategoriaDomainRequest {
    private String nome;
}
