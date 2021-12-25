package br.com.mmtech.controlefinanceiro.rest.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class CategoryRequest {

    @NotEmpty(message = "cannot be null or empty")
    private String description;
}
