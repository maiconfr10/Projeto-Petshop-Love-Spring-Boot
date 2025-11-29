package backend.Projeto.Petshop.Love.atendimento;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import backend.Projeto.Petshop.Love.animal.Animal;
import backend.Projeto.Petshop.Love.atendimentoServico.AtendimentoServico;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Atendimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_atendimento")
	private Long idAtendimento;

	@Column(nullable = false)
	private Date data;

	@Column(name = "observacoes", length = 255)
	private String observacoes;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_animal", nullable = false)
	private Animal animal;

	@JsonIgnore
	@OneToMany(mappedBy = "atendimento", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<AtendimentoServico> atendimentoservicos = new ArrayList<>();

	public Atendimento() {
	}

	public Long getIdAtendimento() {
		return idAtendimento;
	}

	public void setIdAtendimento(Long idAtendimento) {
		this.idAtendimento = idAtendimento;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

}
