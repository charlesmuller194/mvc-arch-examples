package com.fag.lucasmartins.mvc.controller.mapper;

import com.fag.lucasmartins.mvc.model.bo.ProdutoBO;
import com.fag.lucasmartins.mvc.view.dto.ProdutoDTO;

public class ProdutoDTOMapper {

    private ProdutoDTOMapper() {
    }

    public static ProdutoBO toBo(ProdutoDTO dto) {
        return new ProdutoBO(
                dto.getId(),
                dto.getNome(),
                dto.getPreco(),
                dto.getEstoque()
        );
    }

    public static ProdutoDTO toDto(ProdutoBO bo) {
        return new ProdutoDTO(
                bo.getId(),
                bo.getNome(),
                bo.getPreco(),
                bo.getEstoque(),
                bo.isPremium()
        );
    }
}
