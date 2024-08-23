package loja_roupas.app.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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


    @ManyToOne @JoinColumn(name = "venda_id")
    private Venda venda;

}
