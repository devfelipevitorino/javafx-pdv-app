package com.devfelipevitorino.pdv.Model;

import java.util.Date;

public class Produto {

    private Long id;
    private String nome;
    private String descricao;
    private Double preco;
    private Integer qtdEstoque;
    private String referencia;
    private String unidadeMedida;
    private Date dataCadastro;
    private Boolean ativo;

    public Produto(String nome, String descricao, Double preco, Integer qtdEstoque, String referencia, String unidadeMedida) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
        this.referencia = referencia;
        this.unidadeMedida = unidadeMedida;
        this.dataCadastro = new Date();
        this.ativo = true;

    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }

    public Integer getQtdEstoque() { return qtdEstoque; }
    public void setQtdEstoque(Integer qtdEstoque) { this.qtdEstoque = qtdEstoque; }

    public String getReferencia() { return referencia; }
    public void setReferencia(String referencia) { this.referencia = referencia; }

    public String getUnidadeMedida() { return unidadeMedida; }
    public void setUnidadeMedida(String unidadeMedida) { this.unidadeMedida = unidadeMedida; }

    public Date getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(Date dataCadastro) { this.dataCadastro = dataCadastro; }

    public Boolean getAtivo() { return ativo; }
    public void setAtivo(Boolean ativo) { this.ativo = ativo; }
}
