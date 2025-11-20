package backend.Projeto.Petshop.Love.validacoes;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AnimalDTO {

    @NotBlank(message = "O nome do animal é obrigatório")
    @Size(min = 2, max = 50)
    private String nomeAnimal;

    @NotBlank(message = "A espécie é obrigatória")
    private String especie;

    @NotBlank(message = "A raça é obrigatória")
    private String raca;

    @NotNull(message = "A idade é obrigatória")
    private String idade;

    @NotNull(message = "O id do cliente é obrigatório")
    private Long idCliente;

	public String getNomeAnimal() {
		return nomeAnimal;
	}

	public void setNomeAnimal(String nomeAnimal) {
		this.nomeAnimal = nomeAnimal;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

    
}
