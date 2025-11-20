package backend.Projeto.Petshop.Love.atendimentoServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
@RestController
@RequestMapping("/atendimento-servico")
public class AtendimentoServicoController {

    @Autowired
    private AtendimentoServicoService atendimentoServicoService;

    @PostMapping("/{idAtendimento}/{idServico}")
    public ResponseEntity<AtendimentoServico> adicionarServico(
            @NotNull(message = "O ID do atendimento é obrigatório.")
            @PathVariable Long idAtendimento,

            @NotNull(message = "O ID do serviço é obrigatório.")
            @PathVariable Long idServico) {

        AtendimentoServico novo = atendimentoServicoService.adicionarServico(idAtendimento, idServico);
        return ResponseEntity.ok(novo);
    }
}
