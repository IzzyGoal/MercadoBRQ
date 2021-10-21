package com.mercadobrq.www.MercadoBRQ.entrypoint.Controller.exceptions;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FieldsAnswers {
    private String name;
    private String messageUser;
}
