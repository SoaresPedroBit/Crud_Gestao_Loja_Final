package loja_roupas.app.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Insira um nome")
    private String nome;
    @CPF @NotBlank(message = "Insira um CPF para cliente")
    private String cpf;
    @NotNull(message = "Insira uma idade para o Cliente")
    private Integer idade;
    @NotBlank(message = "Insira um telefone") @Pattern(regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}", message = "Número de telefone inválido")
    private String telefone;

    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
    private List<Venda>vendas;

}
