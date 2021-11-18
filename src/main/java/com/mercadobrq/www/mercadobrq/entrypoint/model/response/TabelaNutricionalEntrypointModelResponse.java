package com.mercadobrq.www.mercadobrq.entrypoint.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TabelaNutricionalEntrypointModelResponse {

    private String valorEnergetico;
    private String gorduraSaturada;
    private String sodio;
    private String acucar;
    private String proteinas;
    private String fibras;
}
