package backend.Projeto.Petshop.Love.atendimento;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.Projeto.Petshop.Love.animal.Animal;
import backend.Projeto.Petshop.Love.animal.AnimalRepository;

@Service
public class AtendimentoService {

    @Autowired
    private AtendimentoRepository repository;

    @Autowired
    private AnimalRepository animalRepository;

    public Atendimento registrarAtendimento(Atendimento atendimento) {

        Long idAnimal = atendimento.getAnimal().getIdAnimal();

        
        Animal animal = animalRepository.findById(idAnimal)
                .orElseThrow(() -> new RuntimeException("Animal não encontrado: " + idAnimal));

        atendimento.setAnimal(animal);

        return repository.save(atendimento);
    }

    public void cancelarAtendimento(Long idAtendimento) {
        repository.deleteById(idAtendimento);
    }

    public Atendimento atualizarAtendimento(Long idAtendimento, Atendimento novoAtendimento) {

        Atendimento atendimentoExistente = repository.findById(idAtendimento)
                .orElseThrow(() -> new RuntimeException("Atendimento não encontrado com id " + idAtendimento));

        atendimentoExistente.setObservacoes(novoAtendimento.getObsercoes());
        atendimentoExistente.setData(novoAtendimento.getData());

        Long idAnimal = novoAtendimento.getAnimal().getIdAnimal();

        
        Animal animal = animalRepository.findById(idAnimal)
                .orElseThrow(() -> new RuntimeException("Animal não encontrado: " + idAnimal));

        atendimentoExistente.setAnimal(animal);

        return repository.save(atendimentoExistente);
    }

    public List<Atendimento> todosAtendimentos() {
        return repository.findAll();
    }

    public Optional<Atendimento> procureAtendimento(Long idAtendimento) {
        return repository.findById(idAtendimento);
    }
}
