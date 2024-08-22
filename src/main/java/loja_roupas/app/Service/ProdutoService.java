package loja_roupas.app.Service;

import loja_roupas.app.Entity.Produto;
import loja_roupas.app.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

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

    public String deletar(long id){
        this.produtoRepository.deleteById(id);
        return "foi de arrasta";
    }


}
