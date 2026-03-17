package com.fag.lucasmartins.mvc.model.repository.mapper;

import com.fag.lucasmartins.mvc.model.bo.ProdutoBO;
import com.fag.lucasmartins.mvc.model.repository.entity.ProdutoEntity;

public class ProdutoEntityMapper {

    private ProdutoEntityMapper() {
    }

    public static ProdutoEntity toEntity(ProdutoBO bo) {
        ProdutoEntity entity = new ProdutoEntity();
        entity.setId(bo.getId());
        entity.setNome(bo.getNome());
        entity.setPreco(bo.getPreco());
        entity.setEstoque(bo.getEstoque());
        return entity;
    }

    public static ProdutoBO toBo(ProdutoEntity entity) {
        ProdutoBO bo = new ProdutoBO();
        bo.setId(entity.getId());
        bo.setNome(entity.getNome());
        bo.setPreco(entity.getPreco());
        bo.setEstoque(entity.getEstoque());
        return bo;
    }
}
