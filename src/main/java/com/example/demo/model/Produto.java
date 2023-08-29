package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private Double preco;
    @Column(name = "quantidadeestoque")
    private Integer qtEstoque;

    public Produto(DadosProduto dado) {
        this.nome = dado.nome();
        this.descricao = dado.descricao();
        this.preco = dado.preco();
        this.qtEstoque = dado.qtEstoque();
    }
}
