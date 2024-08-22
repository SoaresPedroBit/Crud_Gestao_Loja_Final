package loja_roupas.app.Service;

import loja_roupas.app.Entity.Funcionario;
import loja_roupas.app.Repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {


    @Autowired
    FuncionarioRepository funcionarioRepository;

    public String salvar(Funcionario funcionario){
        this.funcionarioRepository.save(funcionario);
        return "Funcionario cadastrado";

    }

    public String atualizar(Funcionario funcionario, long id){
        funcionario.setId(id);
        this.funcionarioRepository.save(funcionario);
        return "Funcionario atualizado";

    }

    public Funcionario buscaId(long id){
        Optional<Funcionario> funcionario = this.funcionarioRepository.findById(id);
        return funcionario.orElse(null);
    }

    public List<Funcionario> buscaTudo(){
        return funcionarioRepository.findAll();

    }


    public String deletar(long id){
        this.funcionarioRepository.deleteById(id);
        return "foi demitido meu parça";
    }


    public List<Funcionario> buscaByNome(String nome){
        return funcionarioRepository.findByNome(nome);
    }

    public List<Funcionario> buscaByMatricula(String matricula){
        return funcionarioRepository.findByMatricula(matricula);
    }

    public List<Funcionario> buscaByIdade(Integer idade){
        return funcionarioRepository.findByIdade(idade);
    }




}
