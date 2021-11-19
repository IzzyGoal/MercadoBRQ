package com.mercadobrq.www.mercadobrq.usecase.domain.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TabelaNutricionalDomainResponse {

    private String valor_energetico;
    private String gordura_saturada;
    private String sodio;
    private String acucar;
    private String proteinas;
    private String fibras;
}
