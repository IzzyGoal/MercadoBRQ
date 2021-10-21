package com.mercadobrq.www.MercadoBRQ.entrypoint.Controller.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MensagemExceptionModelResponse {

    private String code;
    private String menssage;
    private List<FieldsAnswers> fieldsList;

}
