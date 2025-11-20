package backend.Projeto.Petshop.Love.validacoes;

import jakarta.validation.constraints.NotNull;

public class AtendimentoServicoDTO {

    @NotNull(message = "O ID do atendimento é obrigatório")
    private Long idAtendimento;

    @NotNull(message = "O ID do serviço é obrigatório")
    private Long idServico;

	public Long getIdAtendimento() {
		return idAtendimento;
	}

	public void setIdAtendimento(Long idAtendimento) {
		this.idAtendimento = idAtendimento;
	}

	public Long getIdServico() {
		return idServico;
	}

	public void setIdServico(Long idServico) {
		this.idServico = idServico;
	}

    
}

