package backend.Projeto.Petshop.Love.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import backend.Projeto.Petshop.Love.usuario.UsuarioEntitie;
import backend.Projeto.Petshop.Love.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class AuthService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UsuarioEntitie usuario = repository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        return new User(
                usuario.getEmail(),
                usuario.getSenha(),
                true,
                true,
                true,
                true,
                usuario.getAuthorities()
        );
    }
}
