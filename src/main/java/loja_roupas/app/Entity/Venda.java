package loja_roupas.app.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Venda {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String endereco;

    private Double valorTotal;

    @ManyToOne @JoinColumn(name = "cliente_id") @NotNull(message = "Insira um cliente valido")
    private Cliente cliente;
    @ManyToOne @JoinColumn(name = "funcionario_id") @NotNull(message = "Insira um funcionario valido;")
    private Funcionario funcionario;
    @OneToMany(mappedBy = "venda",cascade = CascadeType.ALL) @NotEmpty(message = "Nenhum produto selecionado")
    private List<Produto> produtos;

}
