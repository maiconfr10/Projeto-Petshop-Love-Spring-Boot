package backend.Projeto.Petshop.Love.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntitie, Long> {
    Optional<UsuarioEntitie> findByEmail(String email);
}

