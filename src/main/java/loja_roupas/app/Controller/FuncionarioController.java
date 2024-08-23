package loja_roupas.app.Controller;

import loja_roupas.app.Entity.Funcionario;
import loja_roupas.app.Entity.Venda;
import loja_roupas.app.Service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    @PostMapping("/salvar")
    public ResponseEntity<String> salvar(@RequestBody Funcionario funcionario){

        try {
            String mensagem = this.funcionarioService.salvar(funcionario);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Deu ruim o salvamento!"+e.getMessage(), HttpStatus.BAD_REQUEST );
        }

    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizar(@RequestBody Funcionario funcionario,@PathVariable long id){
        try {
            String mensagem = this.funcionarioService.atualizar(funcionario,id);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Deu ruim a atualização!"+e.getMessage(), HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping("/buscaId/{id}")
    public ResponseEntity<Funcionario> buscaId(@PathVariable long id){
        try {
            Funcionario funcionario = this.funcionarioService.buscaId(id);
            return new ResponseEntity<>(funcionario, HttpStatus.CREATED);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/mostraTudo")
    public ResponseEntity<List<Funcionario>> mostraTudo(){
        try {
            List<Funcionario> funcionariosList = this.funcionarioService.buscaTudo();
            return new ResponseEntity<>(funcionariosList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST );
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletar(@PathVariable long id){
        try {
            String resposta = this.funcionarioService.deletar(id);
            return new ResponseEntity<>(resposta, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Deu ruim o deletar!"+e.getMessage(), HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping("/buscaPorNome/{nome}")
    public ResponseEntity<List<Funcionario>> buscaPorNome(@PathVariable String nome) {
        List<Funcionario> funcionarios = funcionarioService.buscaByNome(nome);
        if (funcionarios.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(funcionarios, HttpStatus.OK);
        }
    }


    @GetMapping("/buscaMatricula/{matricula}")
    public ResponseEntity<List<Funcionario>> buscaMatricula(@PathVariable String matricula) {
        List<Funcionario> funcionarios = funcionarioService.buscaByMatricula(matricula);
        if (funcionarios.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(funcionarios, HttpStatus.OK);
    }

   @GetMapping("/buscaIdadeMaior/{idade}")
    public  ResponseEntity<List<Funcionario>> buscaIdadeMaior(@PathVariable Integer idade){
        List<Funcionario> funcionarios = funcionarioService.buscaByIdade(idade);
       if (funcionarios.isEmpty()) {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       } else {
           return new ResponseEntity<>(funcionarios, HttpStatus.OK);
       }

   }


}
