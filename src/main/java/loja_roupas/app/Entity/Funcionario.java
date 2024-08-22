package loja_roupas.app.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Funcionario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Insira um nome")
    private String nome;
    @NotNull(message = "Insira a idade do Funcionario")
    private Integer idade;
    @NotBlank(message = "Insira a matricula do funcionario")
    private String matricula;

    @OneToMany(mappedBy = "funcionario",cascade = CascadeType.ALL)
    private List<Venda>vendas;
}
