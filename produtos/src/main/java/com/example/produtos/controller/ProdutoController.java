package com.example.produtos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.produtos.modelo.Produto;
import com.example.produtos.servico.ProdutoServico;
import jakarta.persistence.EntityNotFoundException;


@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
    @Autowired
    private ProdutoServico ProdutoServico;

    public ProdutoController(ProdutoServico ProdutoServico) {
        this.ProdutoServico = ProdutoServico;
    }

    // Criar um novo produto
    @PostMapping
    public Produto criarProduto(@RequestBody Produto produto) {
        return ProdutoServico.save(produto);
    }

    // Obter todos os produtos
    @GetMapping
    public List<Produto> listarProdutos() {
        return ProdutoServico.findAll();
    }

    // Obter um produto por ID
    @GetMapping("/{id}")
    public Optional<Produto> buscarProduto(@PathVariable Long id) {
        return ProdutoServico.findById(id);
    }

    // Atualizar um produto
    @PutMapping("/{id}")
    public Produto atualizarProduto(@PathVariable Long id,
            @RequestBody Produto novoProduto) {
        return ProdutoServico.findById(id)
                .map(produto -> {
                    produto.setNome(novoProduto.getNome());
                    produto.setPreco(novoProduto.getPreco());
                    produto.setCategoria(novoProduto.getCategoria());
                    return ProdutoServico.save(produto);
                })
                .orElseGet(() -> {
                    //novoProduto.setId(id);
                    //return ProdutoServico.save(novoProduto);
                    throw new EntityNotFoundException();
                });

    }

    // Excluir um produto
    @DeleteMapping("/{id}")
    public void excluirProduto(@PathVariable Long id) {
        ProdutoServico.deleteById(id);
        throw new EntityNotFoundException();
    }
}