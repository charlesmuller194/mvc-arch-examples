package com.fag.lucasmartins.mvc.model.repository.impl;

import com.fag.lucasmartins.mvc.model.bo.ProdutoBO;
import com.fag.lucasmartins.mvc.model.repository.ProdutoRepository;
import com.fag.lucasmartins.mvc.model.repository.entity.ProdutoEntity;
import com.fag.lucasmartins.mvc.model.repository.jpa.ProdutoJpaRepository;
import com.fag.lucasmartins.mvc.model.repository.mapper.ProdutoEntityMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProdutoRepositoryImpl implements ProdutoRepository {

    private final ProdutoJpaRepository jpaRepository;

    public ProdutoRepositoryImpl(ProdutoJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public ProdutoBO salvar(ProdutoBO bo) {
        ProdutoEntity entity = ProdutoEntityMapper.toEntity(bo);
        ProdutoEntity produtoSalvo = jpaRepository.save(entity);
        return ProdutoEntityMapper.toBo(produtoSalvo);
    }

    @Override
    public ProdutoBO buscarPorId(Long id) {
        Optional<ProdutoEntity> produto = jpaRepository.findById(id);
        if (produto.isEmpty()) {
            throw new IllegalArgumentException("Produto não encontrado para o id: " + id);
        }
        return ProdutoEntityMapper.toBo(produto.get());
    }
}
