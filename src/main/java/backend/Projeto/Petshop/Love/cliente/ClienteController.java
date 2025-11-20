package backend.Projeto.Petshop.Love.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import backend.Projeto.Petshop.Love.animal.Animal;
import backend.Projeto.Petshop.Love.validacoes.ClienteDTO;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cliente")
@Validated
public class ClienteController {

    @Autowired
    private ClienteService service;

    // LISTAR TODOS OS CLIENTES
    @GetMapping
    public ResponseEntity<List<ClienteEntitie>> buscarTodosCliente() {
        return ResponseEntity.ok(service.listaCliente());
    }

    // BUSCAR CLIENTE POR ID
    @GetMapping("/{idCliente}")
    public ResponseEntity<ClienteEntitie> encontrarCliente(@PathVariable Long idCliente) {
        return ResponseEntity.ok(service.buscarCliente(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado")));
    }

    // LISTAR ANIMAIS DO CLIENTE
    @GetMapping("/{idCliente}/animais")
    public ResponseEntity<List<Animal>> listarAnimalCliente(@PathVariable Long idCliente) {
        return ResponseEntity.ok(service.ListaAnimaisCliente(idCliente));
    }

    // CADASTRAR CLIENTE USANDO DTO
    @PostMapping
    public ResponseEntity<ClienteEntitie> cadastrarCliente(
            @Valid @RequestBody ClienteDTO clienteDTO) {

        ClienteEntitie novoCliente = service.cadastrarCliente(clienteDTO.toEntity());
        return ResponseEntity.ok(novoCliente);
    }

    // ATUALIZAR CLIENTE USANDO DTO (sem atualizar senha)
    @PutMapping("/{idCliente}")
    public ResponseEntity<ClienteEntitie> atualizarCliente(
            @PathVariable Long idCliente,
            @Valid @RequestBody ClienteDTO clienteDTO) {

        ClienteEntitie clienteAtualizado =
                service.atualizarCliente(idCliente, clienteDTO.toEntity());
        return ResponseEntity.ok(clienteAtualizado);
    }

    // REMOVER CLIENTE
    @DeleteMapping("/{idCliente}")
    public ResponseEntity<Void> apagarCliente(@PathVariable Long idCliente) {
        service.removerCliente(idCliente);
        return ResponseEntity.noContent().build();
    }
}
