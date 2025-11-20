package backend.Projeto.Petshop.Love.validacoes;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class ServicoDTO {

    @NotBlank(message = "A descrição é obrigatória")
    private String descricao;

    @Positive(message = "O preço deve ser maior que zero")
    private Double preco;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

    
}
