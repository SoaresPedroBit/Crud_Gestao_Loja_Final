package loja_roupas.app.Service;

import loja_roupas.app.Entity.Funcionario;
import loja_roupas.app.Entity.Venda;
import loja_roupas.app.Repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    VendaRepository vendaRepository;

    public String salvar(Venda venda){
        this.vendaRepository.save(venda);
        return "Venda cadastrado";

    }

    public String atualizar(Venda venda, long id){
        venda.setId(id);
        this.vendaRepository.save(venda);
        return "Venda atualizado";

    }

    public Venda buscaId(long id){
        Optional<Venda> venda = this.vendaRepository.findById(id);
        return venda.orElse(null);
    }

    public List<Venda> buscaTudo(){
        return vendaRepository.findAll();

    }

    public String deletar(long id){
        this.vendaRepository.deleteById(id);
        return "foi de arrasta";
    }

    public List<Venda> buscaVendaFuncionario(Funcionario funcionario){
        return vendaRepository.findByFuncionario(funcionario);
    }

    public List<Venda> buscaVendaValorMaior(double valor){

        return vendaRepository.findByValorTotal(valor);
    }


    //public List<Venda> findVendabyNome(String nomeP) {
        //return vendaRepository.findbyNome(nomeP);
    //}


}
