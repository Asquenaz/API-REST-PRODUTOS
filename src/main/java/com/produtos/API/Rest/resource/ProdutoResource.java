package com.produtos.API.Rest.resource;



import org.springframework.beans.factory.annotation.Autowired;
import com.produtos.API.Rest.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;
import com.produtos.API.Rest.model.Produtos;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/api")
public class ProdutoResource {

    @Autowired
    ProdutoRepository produtoRepository;


    @GetMapping(value = "/produtos")
    public List <Produtos> listaProdutos(){
        return produtoRepository.findAll();
    }

    @GetMapping(value = "/produtos/{id}")
    public Produtos pegarProduto (@PathVariable (value = "id") long id){
                return produtoRepository.findById(id);
    }

    @PostMapping(value = "/produtos")
    public Produtos salvarProdutos(@RequestBody Produtos produtos) {
    return produtoRepository.save(produtos);

    }

    @DeleteMapping(value = "/produtos/deletar/{id}")
    public void  deletarProduto (@PathVariable (value = "id") long id){
        produtoRepository.deleteById(id);
    }

    @DeleteMapping(value = "/produtos/deletar")
    public void  deletarProdutos (@RequestBody Produtos produtos){
        produtoRepository.delete(produtos);
    }

    @PutMapping(value = "/produtos/atualizar")
    public Produtos atualizarProduto(@RequestBody Produtos produtos){
       produtos.setId(produtos.getId());
       produtos.setNome(produtos.getNome());
       produtos.setQuantidade(produtos.getQuantidade());
       produtos.setValor(produtos.getValor());

       return produtoRepository.save(produtos);
    }
}
