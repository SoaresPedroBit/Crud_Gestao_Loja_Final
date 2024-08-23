package loja_roupas.app.Repository;

import loja_roupas.app.Entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProdutoRepository extends JpaRepository<Produto,Long> {

    @Query("SELECT p FROM Produto p WHERE p.nome = :nome")
    List<Produto> findByNome(@Param("nome") String nome);
    List<Produto> findAllByOrderByValorDesc();
    List<Produto> findByNomeAndValor(String nome, double valor);
}
