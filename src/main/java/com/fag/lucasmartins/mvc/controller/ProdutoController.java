package com.fag.lucasmartins.mvc.controller;

import com.fag.lucasmartins.mvc.controller.mapper.ProdutoDTOMapper;
import com.fag.lucasmartins.mvc.model.bo.ProdutoBO;
import com.fag.lucasmartins.mvc.model.service.ProdutoService;
import com.fag.lucasmartins.mvc.view.dto.ProdutoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> criarProduto(@Valid @RequestBody ProdutoDTO dto) {
        ProdutoBO produtoBO = ProdutoDTOMapper.toBo(dto);

        ProdutoBO produtoCriadoBO = produtoService.criarProduto(produtoBO);

        ProdutoDTO produtoCriadoDTO = ProdutoDTOMapper.toDto(produtoCriadoBO);

        return ResponseEntity
                .status(201)
                .body(produtoCriadoDTO);
    }

    @PostMapping("/{id}/comprar")
    public ResponseEntity<String> comprar(
            @PathVariable Long id,
            @RequestParam @Min(value = 1, message = "A quantidade deve ser de ao menos 1.") Integer quantidade) {

        BigDecimal precoFinal = produtoService.comprar(id, quantidade);

        return ResponseEntity.ok(
                "Compra realizada com sucesso! Preço unitário aplicado: R$ " + precoFinal
        );
    }
}
