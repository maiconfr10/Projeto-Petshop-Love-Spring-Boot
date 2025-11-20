package backend.Projeto.Petshop.Love.animal;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import backend.Projeto.Petshop.Love.atendimento.Atendimento;
import backend.Projeto.Petshop.Love.cliente.ClienteEntitie;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "animal")

public class Animal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_animal")
	private Long idAnimal;

	//CLIENTE
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_cliente", nullable = false)
	private ClienteEntitie cliente;
    
	//ATENDIMENTO
	@JsonIgnore
	@OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Atendimento> atendimento=new ArrayList<>();

	@Column(name = "nome_animal", nullable = false, length = 100)
	private String nomeAnimal;

	@Column(nullable = false, length = 50)
	private String especie;

	@Column(nullable = false, length = 50)
	private String raca;

	@Column(nullable = false)
	private String idade;

	public Animal(String nomeAnimal, String especie, String raca, String idade, ClienteEntitie cliente) {

		this.nomeAnimal = nomeAnimal;
		this.especie = especie;
		this.raca = raca;
		this.idade = idade;
		this.cliente = cliente;
	}

	public Animal() {
	}

	public Long getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(Long idAnimal) {
		this.idAnimal = idAnimal;
	}

	public ClienteEntitie getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntitie cliente) {
		this.cliente = cliente;
	}

	public List<Atendimento> getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(List<Atendimento> atendimento) {
		this.atendimento = atendimento;
	}

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

}
