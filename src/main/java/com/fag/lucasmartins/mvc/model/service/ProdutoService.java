package com.fag.lucasmartins.mvc.model.service;

import com.fag.lucasmartins.mvc.model.bo.ProdutoBO;

import java.math.BigDecimal;

public interface ProdutoService {

    ProdutoBO criarProduto(ProdutoBO produtoBO);

    BigDecimal comprar(Long id, Integer quantidade);
}
