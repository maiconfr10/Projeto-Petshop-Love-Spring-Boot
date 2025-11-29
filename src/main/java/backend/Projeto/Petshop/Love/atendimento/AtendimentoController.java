package backend.Projeto.Petshop.Love.atendimento;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import backend.Projeto.Petshop.Love.validacoes.AtendimentoDTO;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/atendimento")
public class AtendimentoController {

    @Autowired
    private AtendimentoService service;

    @GetMapping
    public ResponseEntity<List<Atendimento>> listaAtendimento() {
        List<Atendimento> atendimentos = service.todosAtendimentos();
        return ResponseEntity.ok(atendimentos);
    }

    @GetMapping("/{idAtendimento}")
    public ResponseEntity<Optional<Atendimento>> buscarAtendimento(@PathVariable Long idAtendimento) {
        Optional<Atendimento> atendimento = service.procureAtendimento(idAtendimento);
        return ResponseEntity.ok(atendimento);
    }

    @PostMapping
    public ResponseEntity<Atendimento> cadastroAtendimento(
            @Valid @RequestBody AtendimentoDTO dto
    ) {
        Atendimento novoAtendimento = service.registrarAtendimento(dto);
        return ResponseEntity.ok(novoAtendimento);
    }

    @PutMapping("/{idAtendimento}")
    public ResponseEntity<Atendimento> atualizarAt(
            @PathVariable Long idAtendimento,
            @Valid @RequestBody AtendimentoDTO dto
    ) {
        Atendimento atualizado = service.atualizarAtendimento(idAtendimento, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{idAtendimento}")
    public ResponseEntity<Void> apagarAtendimento(@PathVariable Long idAtendimento) {
        service.cancelarAtendimento(idAtendimento);
        return ResponseEntity.noContent().build();
    }
}
