package backend.Projeto.Petshop.Love.servico;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import backend.Projeto.Petshop.Love.atendimentoServico.AtendimentoServico;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "servico")
public class Servico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idServico;

	@Column(nullable = false)
	private String Descricao;

	@Column(nullable = false)
	private double preco;
	
	@JsonIgnore
	 @OneToMany(mappedBy = "servico", cascade = CascadeType.ALL)
    private List<AtendimentoServico> atendimentoServicos;

	public Servico() {
	}

	public Servico(Long idServico, String descricao, double preco) {
		super();
		this.idServico = idServico;
		Descricao = descricao;
		this.preco = preco;
	}

	public Long getIdServico() {
		return idServico;
	}

	public void setIdServico(Long idServico) {
		this.idServico = idServico;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

}
