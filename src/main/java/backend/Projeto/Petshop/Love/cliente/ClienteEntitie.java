package backend.Projeto.Petshop.Love.cliente;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import backend.Projeto.Petshop.Love.animal.Animal;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class ClienteEntitie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Animal> animais = new ArrayList<>();

    @Column(nullable = false, length = 100)
    private String nomeCliente;

    @Column(length = 20)
    private String teleCliente;

    @Column(unique = true, length = 100)
    private String emailCliente;

    public ClienteEntitie() {}

    public ClienteEntitie(Long idCliente, String nomeCliente, String teleCliente, String emailCliente) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.teleCliente = teleCliente;
        this.emailCliente = emailCliente;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTeleCliente() {
        return teleCliente;
    }

    public void setTeleCliente(String teleCliente) {
        this.teleCliente = teleCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public List<Animal> getAnimais() {
        return animais;
    }
}
