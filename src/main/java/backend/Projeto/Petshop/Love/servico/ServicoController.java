package backend.Projeto.Petshop.Love.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import backend.Projeto.Petshop.Love.dto.servico.ServicoListDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
@RestController
@RequestMapping("/servico")
public class ServicoController {

    @Autowired
    private ServicoService service;

    @GetMapping
    public ResponseEntity<List<Servico>> BuscarTodosServicos() {
        List<Servico> servicos = service.listarServico();
        return ResponseEntity.ok(servicos);
    }

    @GetMapping("/{idServico}")
    public ResponseEntity<Optional<Servico>> buscarServico(
            @NotNull(message = "O ID do serviço é obrigatório.")
            @PathVariable Long idServico) {

        Optional<Servico> servico = service.procurarServico(idServico);
        return ResponseEntity.ok(servico);
    }

    @PostMapping
    public ResponseEntity<Servico> salvarServico(
            @Valid @RequestBody Servico novoServico) {

        Servico salvo = service.cadastrarServico(novoServico);
        return ResponseEntity.ok(salvo);
    }

    @PostMapping("/{idServico}")
    public ResponseEntity<Servico> postarPorId(
            @Valid @RequestBody Servico novoServico,
            @NotNull(message = "O ID do serviço é obrigatório.")
            @PathVariable Long idServico) {

        Servico salvo = service.cadastrarServico(novoServico);
        return ResponseEntity.ok(salvo);
    }

    @PutMapping("/{idServico}")
    public ResponseEntity<Servico> modificarServico(
            @NotNull(message = "O ID do serviço é obrigatório.")
            @PathVariable Long idServico,

            @Valid @RequestBody Servico modificadoServico) {

        Servico atualizado = service.atualizarServico(idServico, modificadoServico);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{idServico}")
    public ResponseEntity<Void> apagarServico(
            @NotNull(message = "O ID do serviço é obrigatório.")
            @PathVariable Long idServico) {

        service.removerServico(idServico);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/com-total")
    public ResponseEntity<ServicoListDTO> listarComTotal() {
        ServicoListDTO dto = service.listarServicosComTotal();
        return ResponseEntity.ok(dto);
    }
}
