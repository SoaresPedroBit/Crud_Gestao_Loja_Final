package loja_roupas.app.Service;

import jakarta.transaction.Transactional;
import loja_roupas.app.Entity.Produto;
import loja_roupas.app.Entity.Venda;
import loja_roupas.app.Repository.ProdutoRepository;
import loja_roupas.app.Repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;
    @Autowired
    VendaRepository vendaRepository;

    public String salvar(Produto produto){
        this.produtoRepository.save(produto);
        return "Produto cadastrado";

    }

    public String atualizar(Produto produto, long id){
        produto.setId(id);
        this.produtoRepository.save(produto);
        return "Produto atualizado";

    }

    public Produto buscaId(long id){
        Optional<Produto> produto = this.produtoRepository.findById(id);
        return produto.orElse(null);
    }

    public List<Produto> buscaTudo(){
        return produtoRepository.findAll();

    }

    @Transactional
    public String deletar(long id){
        Optional<Produto> produto = produtoRepository.findById(id);

        vendaRepository.deleteByProdutos(produto);
        this.produtoRepository.deleteById(id);
        return "foi de arrasta";
    }
     public List<Produto> buscaNome(String nome){
        List<Produto> produtos = this.produtoRepository.findByNome(nome);
        return produtos;

     }

     public List<Produto> buscaTudoDesc(){
        return produtoRepository.findAllByOrderByValorDesc();
     }

     public List<Produto> buscaNomeValor(String nome, double valor){
        return produtoRepository.findByNomeAndValor(nome, valor);
     }


}
