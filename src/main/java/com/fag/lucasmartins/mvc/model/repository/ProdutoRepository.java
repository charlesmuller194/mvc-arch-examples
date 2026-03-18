package com.fag.lucasmartins.mvc.model.repository;

import com.fag.lucasmartins.mvc.model.bo.ProdutoBO;

public interface ProdutoRepository {

    ProdutoBO salvar(ProdutoBO bo);

    ProdutoBO buscarPorId(Long id);
}
