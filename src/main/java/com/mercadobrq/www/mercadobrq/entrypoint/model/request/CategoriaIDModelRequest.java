package com.mercadobrq.www.mercadobrq.entrypoint.model.request;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaIDModelRequest {

    @NotNull
    private Long id;
}
