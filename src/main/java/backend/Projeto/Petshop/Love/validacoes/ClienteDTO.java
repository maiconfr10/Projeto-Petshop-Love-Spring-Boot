package backend.Projeto.Petshop.Love.validacoes;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import backend.Projeto.Petshop.Love.cliente.ClienteEntitie;

public class ClienteDTO {

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 100)
    private String nomeCliente;

    @NotBlank(message = "Telefone é obrigatório")
    @Pattern(regexp = "^\\d{8,13}$", message = "Telefone inválido (somente dígitos)")
    private String teleCliente;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    private String emailCliente;

    // Getters e setters
    public String getNomeCliente() { return nomeCliente; }
    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }

    public String getTeleCliente() { return teleCliente; }
    public void setTeleCliente(String teleCliente) { this.teleCliente = teleCliente; }

    public String getEmailCliente() { return emailCliente; }
    public void setEmailCliente(String emailCliente) { this.emailCliente = emailCliente; }

    // Conversão para entidade
    public ClienteEntitie toEntity() {
        ClienteEntitie c = new ClienteEntitie();
        c.setNomeCliente(this.nomeCliente);
        c.setTeleCliente(this.teleCliente);
        c.setEmailCliente(this.emailCliente);
        return c;
    }
}
