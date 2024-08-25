package loja_roupas.app.Service;

import jakarta.transaction.Transactional;
import loja_roupas.app.Entity.Cliente;
import loja_roupas.app.Repository.ClienteRepository;
import loja_roupas.app.Repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    VendaRepository vendaRepository;

    public String salvar(Cliente cliente){
        this.clienteRepository.save(cliente);
        return "Cliente cadastrado";

    }

    public String atualizar(Cliente cliente, long id){
        cliente.setId(id);
        this.clienteRepository.save(cliente);
        return "Cliente atualizado";

    }

    public Cliente buscaId(long id){
        Optional<Cliente> cliente = this.clienteRepository.findById(id);
        return cliente.orElse(null);
    }

    public List<Cliente> buscaTudo(){
        return clienteRepository.findAll();

    }

    @Transactional
    public String deletar(long id){
        Optional<Cliente> cliente = clienteRepository.findById(id);


        // Remover as vendas associadas ao cliente
        vendaRepository.deleteByCliente(cliente);

        this.clienteRepository.deleteById(id);
        return "foi de arrasta";
    }

    public List<Cliente> buscaCpf(String cpf){
        return clienteRepository.findByCpf(cpf);
    }

    public List<Cliente> buscaAdulto(){
        return clienteRepository.FindAllByIdade();
    }

    public List<Cliente> buscaTelefone(String telefone){
        return clienteRepository.findByTelefone(telefone);
    }


}
