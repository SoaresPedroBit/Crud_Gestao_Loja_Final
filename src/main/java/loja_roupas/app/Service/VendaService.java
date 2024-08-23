package loja_roupas.app.Service;

import loja_roupas.app.Entity.Funcionario;
import loja_roupas.app.Entity.Produto;
import loja_roupas.app.Entity.Venda;
import loja_roupas.app.Repository.ProdutoRepository;
import loja_roupas.app.Repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    VendaRepository vendaRepository;
    @Autowired
    ProdutoRepository produtoRepository;

    public String salvar(Venda venda){
        calcularVenda(venda);
        this.vendaRepository.save(venda);
        return "Venda cadastrado";

    }

    public String atualizar(Venda venda, long id){
        venda.setId(id);
        calcularVenda(venda);
        List<Produto> produtos = new ArrayList<>();
        // Para cada produto enviado, verifique se ele existe no banco e o adicione na lista de produtos
        for (Produto produto : venda.getProdutos()) {
            Produto produtoExistente = produtoRepository.findById(produto.getId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
            produtos.add(produtoExistente);
        }
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


    public List<Venda> findVendasByProdutoNome(String nomeProduto) {
        return vendaRepository.findVendasByProdutoNome(nomeProduto);
    }
    private void calcularVenda(Venda venda){
        double total = 0;
        ArrayList<Produto> produtos= new ArrayList<>();
        for (Produto produto : venda.getProdutos()){
            produtos.add(produtoRepository
                    .findById
                            (produto.getId())
                    .get()
            );
        }
        for(Produto produto : produtos){
            total += produto.getValor();
        }
        venda.setValorTotal(total);
    }



}
