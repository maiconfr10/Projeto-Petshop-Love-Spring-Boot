package backend.Projeto.Petshop.Love.usuario;

import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioEntitie toEntity(UsuarioDTO dto) {
        UsuarioEntitie u = new UsuarioEntitie();
        u.setNome(dto.getNome());
        u.setEmail(dto.getEmail());
        u.setSenha(dto.getSenha());
        return u;
    }

    public UsuarioResponseDTO toDTO(UsuarioEntitie usuario) {
        return new UsuarioResponseDTO(
                usuario.getIdUsuario(),
                usuario.getNome(),
                usuario.getEmail()
        );
    }
}
