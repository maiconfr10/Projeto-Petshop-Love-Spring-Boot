package backend.Projeto.Petshop.Love.animal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import backend.Projeto.Petshop.Love.atendimento.Atendimento;
import backend.Projeto.Petshop.Love.validacoes.AnimalDTO;
import backend.Projeto.Petshop.Love.validacoes.AnimalMapper;
import backend.Projeto.Petshop.Love.validacoes.AnimalResponseDTO;
import backend.Projeto.Petshop.Love.validacoes.AnimalResponseMapper;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/animal")
@Validated
public class AnimalController {
	@Autowired
	private AnimalResponseMapper responseMapper;

    @Autowired
    private AnimalService service;

    @Autowired
    private AnimalMapper mapper;

    // ------------------ LISTAR ATENDIMENTOS DO ANIMAL ------------------
    @Operation(summary = "Lista de atendimentos", description = "Esse método retorna uma lista de atendimentos do animal")
    @GetMapping("/{idAnimal}/atendimentos")
    public ResponseEntity<List<Atendimento>> listarAtendimentos(@PathVariable Long idAnimal) {
        List<Atendimento> atendimentos = service.listaAtendimentoAnimal(idAnimal);
        return ResponseEntity.ok(atendimentos);
    }

    // ------------------ BUSCAR ANIMAL POR ID ------------------
    @GetMapping("/{idAnimal}")
    public ResponseEntity<Animal> encontrarAnimal(@PathVariable Long idAnimal) {
        Animal animal = service.buscarAnimal(idAnimal)
                .orElseThrow(() -> new RuntimeException("Animal não encontrado com id " + idAnimal));
        return ResponseEntity.ok(animal);
    }

    // ------------------ CADASTRAR ANIMAL (COM VALIDAÇÃO) ------------------
    @PostMapping
    public ResponseEntity<AnimalResponseDTO> cadastrarAnimal(@Valid @RequestBody AnimalDTO dto) {
        Animal animal = mapper.toEntity(dto);
        Animal novoAnimal = service.cadastrarAnimal(animal);
        return ResponseEntity.ok(responseMapper.toDTO(novoAnimal));

    }

    // ------------------ ATUALIZAR ANIMAL (COM VALIDAÇÃO) ------------------
    @PutMapping("/{idAnimal}")
    public ResponseEntity<Animal> atualizarAnimal(
            @PathVariable Long idAnimal,
            @Valid @RequestBody AnimalDTO dto) {

        Animal animalAtualizado = service.atualizarAnimal(idAnimal, mapper.toEntity(dto));
        return ResponseEntity.ok(animalAtualizado);
    }

    // ------------------ REMOVER ANIMAL ------------------
    @DeleteMapping("/{idAnimal}")
    public ResponseEntity<Void> removerAnimal(@PathVariable Long idAnimal) {
        service.removerAnimal(idAnimal);
        return ResponseEntity.noContent().build();
    }

    // ------------------ LISTAR TODOS OS ANIMAIS ------------------
    @Operation(summary = "Lista de animais", description = "Esse método retorna uma lista de animais")
    @GetMapping
    public ResponseEntity<List<Animal>> listarTodos() {
        List<Animal> animais = service.mostrarTodosAnimal();
        return ResponseEntity.ok(animais);
    }
}
