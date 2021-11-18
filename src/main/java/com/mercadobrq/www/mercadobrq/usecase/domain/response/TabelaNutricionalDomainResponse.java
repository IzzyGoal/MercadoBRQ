package com.mercadobrq.www.mercadobrq.usecase.domain.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TabelaNutricionalDomainResponse {
    private String valorEnergetico;
    private String gorduraSaturada;
    private String sodio;
    private String acucar;
    private String proteinas;
    private String fibras;
}
