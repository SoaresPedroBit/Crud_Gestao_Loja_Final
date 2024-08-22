package loja_roupas.app.Controller;

import loja_roupas.app.Entity.Produto;
import loja_roupas.app.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/produto")
@RestController
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping("/salvar")
    public ResponseEntity<String> salvar(@RequestBody Produto produto, long id){

        try {
            String mensagem = this.produtoService.salvar(produto);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Deu ruim o salvamento!"+e.getMessage(), HttpStatus.BAD_REQUEST );
        }

    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizar(@RequestBody Produto produto,@PathVariable long id){
        try {
            String mensagem = this.produtoService.atualizar(produto,id);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Deu ruim a atualização!"+e.getMessage(), HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping("/buscaId/{id}")
    public ResponseEntity<Produto> buscaId(@PathVariable long id){
        try {
            Produto produto = this.produtoService.buscaId(id);
            return new ResponseEntity<>(produto, HttpStatus.CREATED);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/mostraTudo")
    public ResponseEntity<List<Produto>> mostraTudo(){
        try {
            List<Produto> produtosList = this.produtoService.buscaTudo();
            return new ResponseEntity<>(produtosList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST );
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletar(@PathVariable long id){
        try {
            String resposta = this.produtoService.deletar(id);
            return new ResponseEntity<>(resposta, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Deu ruim o deletar!"+e.getMessage(), HttpStatus.BAD_REQUEST );
        }

    }


}
