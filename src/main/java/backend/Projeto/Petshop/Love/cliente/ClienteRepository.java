package backend.Projeto.Petshop.Love.cliente;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntitie,Long>{
	Optional<ClienteEntitie>findByEmailCliente(String emailCliente);

}
