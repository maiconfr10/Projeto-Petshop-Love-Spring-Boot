package backend.Projeto.Petshop.Love.validacoes;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class ClienteUpdateDTO {

    @NotBlank(message = "O nome é obrigatório")
    private String nomeCliente;

    @Pattern(regexp = "\\d{10,11}", message = "Telefone deve conter 10 ou 11 números")
    private String teleCliente;

    @Email(message = "Email inválido")
    @NotBlank(message = "Email é obrigatório")
    private String emailCliente;

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

    
}

