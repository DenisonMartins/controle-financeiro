package br.com.mmtech.controlefinanceiro.domain.repository;

import br.com.mmtech.controlefinanceiro.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
