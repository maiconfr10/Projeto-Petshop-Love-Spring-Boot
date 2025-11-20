package backend.Projeto.Petshop.Love.atendimentoServico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtendimentoServicoRepository extends JpaRepository<AtendimentoServico, Long> {

}
