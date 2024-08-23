package loja_roupas.app.Repository;

import loja_roupas.app.Entity.Funcionario;
import loja_roupas.app.Entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VendaRepository extends JpaRepository<Venda,Long> {

    List<Venda> findByFuncionario(Funcionario funcionario);
    List<Venda> findByValorTotal(double valor);
    @Query("SELECT v FROM Venda v JOIN v.produtos p WHERE p.nome = :nomeProduto")
    List<Venda> findVendasByProdutoNome(@Param("nomeProduto") String nomeProduto);

}
