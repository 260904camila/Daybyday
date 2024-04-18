package br.com.fiap.daybyday.model;

import java.math.BigDecimal;

import br.com.fiap.daybyday.validation.TipoServico;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Categoria {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "{categoria.descricao.notblank}")
    @Size(min = 3, max = 255)
    private String descricao;

    @TipoCategoria 
    private String tipo; // PROFISSIONAL | PESSOAL | SAÚDE | LAZER | ESTUDO
     
}
