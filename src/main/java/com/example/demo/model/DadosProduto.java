package com.example.demo.model;

public record DadosProduto(
        String nome,
        String descricao,
        Double preco,
        Integer qtEstoque
) {}
