package com.fag.lucasmartins.mvc.model.repository.jpa;

import com.fag.lucasmartins.mvc.model.repository.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoJpaRepository extends JpaRepository<ProdutoEntity, Long> {
}
