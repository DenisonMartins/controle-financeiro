package br.com.mmtech.controlefinanceiro.rest.dto.response;

import br.com.mmtech.controlefinanceiro.domain.entity.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryResponse {

    private Long id;
    private String description;

    public CategoryResponse(Category entity) {
        id = entity.getId();
        description = entity.getDescription();
    }
}
