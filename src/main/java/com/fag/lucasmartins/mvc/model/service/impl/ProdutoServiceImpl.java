package com.fag.lucasmartins.mvc.model.service.impl;

import com.fag.lucasmartins.mvc.model.bo.ProdutoBO;
import com.fag.lucasmartins.mvc.model.repository.ProdutoRepository;
import com.fag.lucasmartins.mvc.model.service.ProdutoService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public ProdutoBO criarProduto(ProdutoBO produtoBO) {
        return produtoRepository.salvar(produtoBO);
    }

    @Override
    public BigDecimal comprar(Long id, Integer quantidade) {
        ProdutoBO produto = produtoRepository.buscarPorId(id);

        BigDecimal precoFinal = produto.calcularPrecoComDesconto(quantidade);

        produto.darBaixaNoEstoque(quantidade);

        produtoRepository.salvar(produto);

        return precoFinal;
    }
}
