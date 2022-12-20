package com.produtos.API.Rest.repository;

import com.produtos.API.Rest.model.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends JpaRepository <Produtos, Long> {
    Produtos findById(long id);

    Produtos findById(Produtos id);

    Produtos deleteById(long id);

}
