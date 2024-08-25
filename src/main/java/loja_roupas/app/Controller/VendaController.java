package loja_roupas.app.Controller;

import loja_roupas.app.Entity.Funcionario;
import loja_roupas.app.Entity.Venda;
import loja_roupas.app.Service.FuncionarioService;
import loja_roupas.app.Service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/venda")
public class VendaController {

    @Autowired
    VendaService vendaService;
    @Autowired
    FuncionarioService funcionarioService;

    @PostMapping("/salvar")
    public ResponseEntity<String> salvar(@RequestBody Venda venda){

        try {
            String mensagem = this.vendaService.salvar(venda);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Deu ruim o salvamento!"+e.getMessage(), HttpStatus.BAD_REQUEST );
        }


    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizar(@RequestBody Venda venda,@PathVariable long id){
        try {
            String mensagem = this.vendaService.atualizar(venda,id);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Deu ruim a atualização!"+e.getMessage(), HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping("/buscaId/{id}")
    public ResponseEntity<Venda> buscaId(@PathVariable long id){
        try {
            Venda venda = this.vendaService.buscaId(id);
            return new ResponseEntity<>(venda, HttpStatus.CREATED);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/mostraTudo")
    public ResponseEntity<List<Venda>> mostraTudo(){
        try {
            List<Venda> vendasList = this.vendaService.buscaTudo();
            return new ResponseEntity<>(vendasList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST );
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletar(@PathVariable long id){
        try {
            String resposta = this.vendaService.deletar(id);
            return new ResponseEntity<>(resposta, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Deu ruim o deletar!"+e.getMessage(), HttpStatus.BAD_REQUEST );
        }

    }

    @GetMapping("/buscaVendaFun/{id}")
    public ResponseEntity<List<Venda>> buscaVendasPorFuncionario(@PathVariable Long id) {
        Funcionario funcionario = funcionarioService.buscaId(id);
        if (funcionario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Venda> vendas = vendaService.buscaVendaFuncionario(funcionario);
        return new ResponseEntity<>(vendas, HttpStatus.OK);
    }

    @GetMapping("/buscaVendaValor/{valor}")
    public ResponseEntity<List<Venda>> buscaVendaMaior(@PathVariable double valor) {
        List<Venda> vendas = vendaService.buscaVendaValorMaior(valor);
        if (vendas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(vendas, HttpStatus.OK);
        }

    }


    @GetMapping("/buscaPorProduto/{nomeProduto}")
    public ResponseEntity<List<Venda>> buscaPorProduto(@PathVariable String nomeProduto) {
        List<Venda> vendas = vendaService.findVendasByProdutoNome(nomeProduto);
        if (vendas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(vendas, HttpStatus.OK);
        }
    }
}



