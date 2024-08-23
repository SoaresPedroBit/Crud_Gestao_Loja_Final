package loja_roupas.app.Repository;

import loja_roupas.app.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {

    List<Cliente> findByTelefone(String telefone);
    List<Cliente> findByCpf(String cpf);
    @Query("SELECT v FROM Cliente v WHERE v.idade > 17")
    List<Cliente> FindAllByIdade();

}
