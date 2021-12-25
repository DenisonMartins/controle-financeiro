package br.com.mmtech.controlefinanceiro.exception;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class ValidationExceptionDetails extends ExceptionDetails {

    private final String field;
    private final String fieldMessage;
}
