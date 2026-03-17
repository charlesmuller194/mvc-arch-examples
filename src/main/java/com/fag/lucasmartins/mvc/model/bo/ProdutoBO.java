package com.fag.lucasmartins.mvc.model.bo;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Modelo de Domínio Rico do Produto.
 * <p>
 * Todas as regras de negócio residem aqui (SRP):
 * — Classificação de produto Premium
 * — Cálculo de desconto de atacado
 * — Controle de baixa no estoque
 */
public class ProdutoBO {

    private static final BigDecimal LIMIAR_PREMIUM = new BigDecimal("1000.00");
    private static final int QUANTIDADE_MINIMA_ATACADO = 10;
    private static final BigDecimal PERCENTUAL_DESCONTO_ATACADO = new BigDecimal("0.85");

    private Long id;
    private String nome;
    private BigDecimal preco;
    private Integer estoque;

    public ProdutoBO() {
    }

    public ProdutoBO(Long id, String nome, BigDecimal preco, Integer estoque) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    /**
     * Um produto é Premium quando seu preço é maior ou igual a R$ 1.000,00.
     */
    public boolean isPremium() {
        return preco != null && preco.compareTo(LIMIAR_PREMIUM) >= 0;
    }

    /**
     * Calcula o preço final para a quantidade solicitada.
     * — Produtos Premium nunca recebem desconto de atacado.
     * — Compras com 10+ unidades de produtos não-Premium recebem 15% de desconto.
     *
     * @param quantidade unidades que o cliente deseja comprar
     * @return preço unitário final após aplicação das regras
     */
    public BigDecimal calcularPrecoComDesconto(Integer quantidade) {
        if (isPremium()) {
            return preco;
        }
        if (quantidade != null && quantidade >= QUANTIDADE_MINIMA_ATACADO) {
            return preco.multiply(PERCENTUAL_DESCONTO_ATACADO)
                    .setScale(2, RoundingMode.HALF_UP);
        }
        return preco;
    }

    /**
     * Deduz a quantidade do estoque após validar suficiência.
     *
     * @param quantidade unidades a deduzir
     * @throws IllegalStateException se o estoque for insuficiente
     */
    public void darBaixaNoEstoque(Integer quantidade) {
        if (quantidade == null || quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }
        if (this.estoque < quantidade) {
            throw new IllegalStateException(
                    "Estoque insuficiente. Disponível: " + this.estoque + " | Solicitado: " + quantidade);
        }
        this.estoque -= quantidade;
    }

    // ---- Getters e Setters ----

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }
}
