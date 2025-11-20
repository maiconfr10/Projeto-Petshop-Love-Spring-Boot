package backend.Projeto.Petshop.Love.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PerfilRepository perfilRepo;

    public UsuarioEntitie cadastrar(UsuarioEntitie usuario) {

        if (repository.findByEmail(usuario.getEmail()).isPresent()) {
            throw new RuntimeException("E-mail já cadastrado!");
        }

        usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));

        // ➤ Busca por perfil padrão
        Perfil comum = perfilRepo.findByNome("COMUM")
                .orElseThrow(() -> new RuntimeException("Perfil padrão COMUM não existe no banco."));

        usuario.getPerfis().add(comum);

        return repository.save(usuario);
    }
}



