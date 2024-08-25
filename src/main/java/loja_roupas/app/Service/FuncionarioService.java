package loja_roupas.app.Service;

import jakarta.transaction.Transactional;
import loja_roupas.app.Entity.Funcionario;
import loja_roupas.app.Repository.FuncionarioRepository;
import loja_roupas.app.Repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {


    @Autowired
    FuncionarioRepository funcionarioRepository;
    @Autowired
    VendaRepository vendaRepository;

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


    @Transactional
    public String deletar(long id){
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);

        // Remover ou desvincular as vendas associadas ao funcionário
        vendaRepository.deleteByFuncionario(funcionario);
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
