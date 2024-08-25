package loja_roupas.app.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class Produto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Insira um nome")
    private String nome;
    @NotNull(message = "Insira um valor para o produto")
    private double valor;


    @ManyToMany(mappedBy = "produtos") @JsonIgnoreProperties({"produtos"})
    private List<Venda> vendas;

}
