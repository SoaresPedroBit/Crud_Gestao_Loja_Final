package loja_roupas.app.Repository;

import loja_roupas.app.Entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {


    List<Funcionario> findByNome(String nome);
    List<Funcionario> findByMatricula(String matricula);
    @Query("SELECT v FROM Funcionario v WHERE v.idade > :idade")
    List<Funcionario> findByIdade(@Param("idade") Integer idade);


}
