package com.mercadobrq.www.mercadobrq.entrypoint.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TabelaNutricionalEntrypointModelResquest {

    @NotNull
    @NotBlank
    private String valorEnergetico;

    @NotNull
    @NotBlank
    private String gorduraSaturada;

    @NotNull
    @NotBlank
    private String sodio;

    @NotNull
    @NotBlank
    private String acucar;

    @NotNull
    @NotBlank
    private String proteinas;

    @NotNull
    @NotBlank
    private String fibras;

}
