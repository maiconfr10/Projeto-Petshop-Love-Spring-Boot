package backend.Projeto.Petshop.Love.atendimentoServico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/atendimento-servico")
public class AtendimentoServicoController {

	@Autowired
	private AtendimentoServicoService atendimentoServicoService;

	@PostMapping("/{idAtendimento}/{idServico}")
	public ResponseEntity<AtendimentoServico> adicionarServico(
			@NotNull(message = "O ID do atendimento é obrigatório.") @PathVariable Long idAtendimento,

			@NotNull(message = "O ID do serviço é obrigatório.") @PathVariable Long idServico) {

		AtendimentoServico novo = atendimentoServicoService.adicionarServico(idAtendimento, idServico);
		return ResponseEntity.ok(novo);
	}

	@GetMapping
	public ResponseEntity<List<AtendimentoServico>> listarTodos() {
		List<AtendimentoServico> lista = atendimentoServicoService.listarTodosVinculos();
		return ResponseEntity.ok(lista);
	}
}
