package br.com.mmtech.controlefinanceiro.service.impl;

import br.com.mmtech.controlefinanceiro.domain.entity.Category;
import br.com.mmtech.controlefinanceiro.domain.repository.CategoryRepository;
import br.com.mmtech.controlefinanceiro.rest.dto.request.CategoryRequest;
import br.com.mmtech.controlefinanceiro.rest.dto.response.CategoryResponse;
import br.com.mmtech.controlefinanceiro.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.text.MessageFormat;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    @Transactional(readOnly = true)
    public List<CategoryResponse> findAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryResponse::new)
                .collect(toList());
    }

    @Override
    @Transactional(readOnly = true)
    public CategoryResponse findById(Long id) {
        Category category = consultarPorId(id);
        return new CategoryResponse(category);
    }

    @Override
    @Transactional
    public CategoryResponse save(CategoryRequest categoryRequest) {
        Category category = categoryRepository.save(
                Category.builder()
                        .description(categoryRequest.getDescription())
                        .build()
        );
        return new CategoryResponse(category);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Category category = consultarPorId(id);
        categoryRepository.delete(category);
    }

    @Override
    @Transactional
    public CategoryResponse update(Long id, CategoryRequest categoryRequest) {
        Category category = consultarPorId(id);
        category.setDescription(categoryRequest.getDescription());
        return new CategoryResponse(category);
    }

    private Category consultarPorId(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        MessageFormat.format("Entity with id {0} not exists", id)
                ));
    }
}
