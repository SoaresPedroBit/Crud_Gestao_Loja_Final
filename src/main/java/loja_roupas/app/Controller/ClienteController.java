package loja_roupas.app.Controller;

import ch.qos.logback.core.net.server.Client;
import loja_roupas.app.Entity.Cliente;
import loja_roupas.app.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping("/salvar")
    public ResponseEntity<String> salvar(@RequestBody Cliente cliente, long id){

        try {
            String mensagem = this.clienteService.salvar(cliente);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Deu ruim o salvamento!"+e.getMessage(), HttpStatus.BAD_REQUEST );
        }

    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizar(@RequestBody Cliente cliente,@PathVariable long id){
        try {
            String mensagem = this.clienteService.atualizar(cliente,id);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Deu ruim a atualização!"+e.getMessage(), HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping("/buscaId/{id}")
    public ResponseEntity<Cliente> buscaId(@PathVariable long id){
        try {
            Cliente cliente = this.clienteService.buscaId(id);
            return new ResponseEntity<>(cliente, HttpStatus.CREATED);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/mostraTudo")
    public ResponseEntity<List<Cliente>> mostraTudo(){
        try {
            List<Cliente> clientesList = this.clienteService.buscaTudo();
            return new ResponseEntity<>(clientesList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST );
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletar(@PathVariable long id){
        try {
            String resposta = this.clienteService.deletar(id);
            return new ResponseEntity<>(resposta, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Deu ruim o deletar!"+e.getMessage(), HttpStatus.BAD_REQUEST );
        }


    }
    @GetMapping("/bucasCpf/{cpf}")
    public ResponseEntity<List<Cliente>> buscaCpf(@PathVariable String cpf){
        try {
            List<Cliente> clientes = this.clienteService.buscaCpf(cpf);
            return new ResponseEntity<>(clientes, HttpStatus.CREATED);
        } catch (Exception e) {
            return null;
        }

    }

    @GetMapping("/buscaAdulto/{idade}")
    public ResponseEntity<List<Cliente>> buscaAdulto(@PathVariable Integer idade){
        try {
            List<Cliente> clientes = this.clienteService.buscaAdulto(idade);
            return new ResponseEntity<>(clientes, HttpStatus.CREATED);
        } catch (Exception e) {
            return null;
        }

    }

    @GetMapping("/buscaTelefone/{telefone}")
    public ResponseEntity<List<Cliente>> buscaTelefone(String telefone){
        try {
            List<Cliente> clientes = this.clienteService.buscaTelefone(telefone);
            return new ResponseEntity<>(clientes, HttpStatus.CREATED);
        } catch (Exception e) {
            return null;
        }
    }


}
