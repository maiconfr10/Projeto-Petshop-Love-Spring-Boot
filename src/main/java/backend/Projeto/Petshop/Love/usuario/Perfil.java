package backend.Projeto.Petshop.Love.usuario;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.*;

@Entity
@Table(name = "perfil")
public class Perfil implements GrantedAuthority {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nome; // ADMIN, COMUM

	public Perfil() {
	}

	public Perfil(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;

	} @Override
    public String getAuthority() {
        return nome; // EX: "ADMIN", "COMUM"
    }
}
