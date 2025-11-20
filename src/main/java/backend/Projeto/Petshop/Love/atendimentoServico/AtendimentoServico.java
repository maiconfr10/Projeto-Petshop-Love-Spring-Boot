package backend.Projeto.Petshop.Love.atendimentoServico;

import backend.Projeto.Petshop.Love.atendimento.Atendimento;
import backend.Projeto.Petshop.Love.servico.Servico;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "atendimento_servico")
public class AtendimentoServico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_atendimento_servico")
	private Long idAtendimentoServico;

	@ManyToOne
	@JoinColumn(name = "id_atendimento", nullable = false)
	private Atendimento atendimento;

	@ManyToOne
	@JoinColumn(name = "id_servico", nullable = false)
	private Servico servico;

	public AtendimentoServico() {
	}

	public Long getIdAtendimentoServico() {
		return idAtendimentoServico;
	}

	public void setIdAtendimentoServico(Long idAtendimentoServico) {
		this.idAtendimentoServico = idAtendimentoServico;
	}

	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

}
