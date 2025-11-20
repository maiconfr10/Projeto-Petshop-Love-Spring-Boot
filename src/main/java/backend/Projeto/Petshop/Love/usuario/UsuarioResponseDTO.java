package backend.Projeto.Petshop.Love.usuario;

public class UsuarioResponseDTO {

    private Long idUsuario;
    private String nome;
    private String email;

    public UsuarioResponseDTO(Long idUsuario, String nome, String email) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
    }

    public Long getIdUsuario() { return idUsuario; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
}

