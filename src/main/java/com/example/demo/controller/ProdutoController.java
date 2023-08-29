package com.example.demo.controller;

import com.example.demo.model.DadosProduto;
import com.example.demo.model.Produto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
    @Autowired
    ProdutoRepository repo;

    @GetMapping("/selecionar")
    public List<Produto> listarProdutos(){
        return repo.findAll();
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarProduto(@RequestBody DadosProduto dado){
        try {
            repo.save(new Produto(dado));
        }catch(Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok("Ok.");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        repo.deleteById(id);
        return ResponseEntity.ok("Ok.");
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizar(@PathVariable Long id, @RequestBody Produto produtoAtt) {
        Optional<Produto> produtoExistente = repo.findById(id);
        if(produtoExistente.isPresent()) {
            Produto produto = produtoExistente.get();
            produto.setNome(produtoAtt.getNome());
            produto.setDescricao(produtoAtt.getDescricao());
            produto.setPreco(produtoAtt.getPreco());
            produto.setQtEstoque(produtoAtt.getQtEstoque());
            repo.save(produto);
            return ResponseEntity.ok("Ok!");
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/selecionar/{id}")
    public ResponseEntity<Produto> getProdutoPorId(@PathVariable Long id) {
        if(repo.existsById(id)) {
            Produto produto = repo.findById(id).orElse(null);
            return ResponseEntity.ok(produto);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/inserirForm")
    public ResponseEntity<String> inserirForm(@RequestParam String nome,
                                              @RequestParam String desc,
                                              @RequestParam double preco,
                                              @RequestParam int qnt) {
        Produto p = new Produto(new DadosProduto(nome, desc, preco, qnt));

        repo.save(p);
        return ResponseEntity.ok("Okay");
    }


}
