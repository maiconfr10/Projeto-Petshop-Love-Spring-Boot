package backend.Projeto.Petshop.Love.validacoes;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AtendimentoDTO {

    @NotNull(message = "A data é obrigatória")
    private LocalDate data;

    @Size(max = 255, message = "Observação deve ter no máximo 255 caracteres")
    private String observacoes;

    @NotNull(message = "O ID do animal é obrigatório")
    private Long animalId;

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Long getAnimalId() {
		return animalId;
	}

	public void setAnimalId(Long animalId) {
		this.animalId = animalId;
	}

  
}
