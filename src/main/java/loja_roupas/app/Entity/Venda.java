package loja_roupas.app.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Venda {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String endereco;

    private Double valorTotal;

    @ManyToOne @JoinColumn(name = "cliente_id") @NotNull(message = "Insira um cliente válido")@JsonIgnoreProperties({"vendas"})
    private Cliente cliente;
    @ManyToOne @JoinColumn(name = "funcionario_id") @NotNull(message = "Insira um funcionario valido;")@JsonIgnoreProperties({"vendas"})
    private Funcionario funcionario;
    @OneToMany(mappedBy = "venda") @NotEmpty(message = "Nenhum produto selecionado") @JsonIgnoreProperties({"venda"})
    private List<Produto> produtos;

}
