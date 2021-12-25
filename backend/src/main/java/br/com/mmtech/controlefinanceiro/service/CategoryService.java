package br.com.mmtech.controlefinanceiro.service;

import br.com.mmtech.controlefinanceiro.rest.dto.request.CategoryRequest;
import br.com.mmtech.controlefinanceiro.rest.dto.response.CategoryResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> findAll();

    CategoryResponse findById(Long id);

    CategoryResponse save(CategoryRequest categoryRequest);

    void delete(Long id);

    CategoryResponse update(Long id, CategoryRequest categoryRequest);
}
