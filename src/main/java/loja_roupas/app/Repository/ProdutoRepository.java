package loja_roupas.app.Repository;

import loja_roupas.app.Entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ProdutoRepository extends JpaRepository<Produto,Long> {
}
