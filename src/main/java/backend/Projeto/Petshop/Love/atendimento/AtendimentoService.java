package backend.Projeto.Petshop.Love.atendimento;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.Projeto.Petshop.Love.animal.Animal;
import backend.Projeto.Petshop.Love.animal.AnimalRepository;
import backend.Projeto.Petshop.Love.validacoes.AtendimentoDTO;

@Service
public class AtendimentoService {

    @Autowired
    private AtendimentoRepository repository;

    @Autowired
    private AnimalRepository animalRepository;

    // ------------------------- CREATE -------------------------
    public Atendimento registrarAtendimento(AtendimentoDTO dto) {

        Animal animal = animalRepository.findById(dto.getAnimalId())
                .orElseThrow(() -> new RuntimeException("Animal não encontrado: " + dto.getAnimalId()));

        Atendimento atendimento = new Atendimento();
        atendimento.setData(Date.valueOf(dto.getData())); 
        atendimento.setObservacoes(dto.getObservacoes());
        atendimento.setAnimal(animal);

        return repository.save(atendimento);
    }

    // ------------------------- DELETE -------------------------
    public void cancelarAtendimento(Long idAtendimento) {
        repository.deleteById(idAtendimento);
    }

    // ------------------------- UPDATE -------------------------
    public Atendimento atualizarAtendimento(Long idAtendimento, AtendimentoDTO dto) {

        Atendimento atendimentoExistente = repository.findById(idAtendimento)
                .orElseThrow(() -> new RuntimeException("Atendimento não encontrado com id " + idAtendimento));

        Animal animal = animalRepository.findById(dto.getAnimalId())
                .orElseThrow(() -> new RuntimeException("Animal não encontrado: " + dto.getAnimalId()));

        atendimentoExistente.setData(Date.valueOf(dto.getData()));
        atendimentoExistente.setObservacoes(dto.getObservacoes());
        atendimentoExistente.setAnimal(animal);

        return repository.save(atendimentoExistente);
    }

    // ------------------------- LISTAR TODOS -------------------------
    public List<Atendimento> todosAtendimentos() {
        return repository.findAll();
    }

    // ------------------------- BUSCAR UM -------------------------
    public Optional<Atendimento> procureAtendimento(Long idAtendimento) {
        return repository.findById(idAtendimento);
    }
}
