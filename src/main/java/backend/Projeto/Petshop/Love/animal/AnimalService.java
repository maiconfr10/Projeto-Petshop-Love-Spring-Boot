package backend.Projeto.Petshop.Love.animal;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.Projeto.Petshop.Love.atendimento.Atendimento;
import backend.Projeto.Petshop.Love.cliente.ClienteEntitie;
import backend.Projeto.Petshop.Love.cliente.ClienteRepository;

@Service
public class AnimalService {

	@Autowired
	private AnimalRepository repository;

	@Autowired
	private ClienteRepository clienteRepository;

	public Animal cadastrarAnimal(Animal animal) {

	    if (animal.getCliente() == null) {
	        throw new RuntimeException("O cliente é obrigatório!");
	    }

	    return repository.save(animal);
	}


	public void removerAnimal(Long idAnimal) {
		repository.deleteById(idAnimal);
	}

	public List<Atendimento> listaAtendimentoAnimal(Long idAnimal) {
		Animal animal = repository.findById(idAnimal)
				.orElseThrow(() -> new RuntimeException("Animal não encontrado com id" + idAnimal));
		return animal.getAtendimento();

	}

	public Animal atualizarAnimal(Long idAnimal, Animal novoAnimal) {
		Animal animalExistente = repository.findById(idAnimal)
				.orElseThrow(() -> new RuntimeException("Animal não encontrado com id " + idAnimal));

		// Atualiza os campos básicos
		animalExistente.setNomeAnimal(novoAnimal.getNomeAnimal());
		animalExistente.setEspecie(novoAnimal.getEspecie());
		animalExistente.setRaca(novoAnimal.getRaca());
		animalExistente.setIdade(novoAnimal.getIdade());

		// Atualiza o cliente se for informado
		if (novoAnimal.getCliente() != null && novoAnimal.getCliente().getIdCliente() != null) {
			ClienteEntitie cliente = clienteRepository.findById(novoAnimal.getCliente().getIdCliente())
					.orElseThrow(() -> new RuntimeException(
							"Cliente não encontrado com id " + novoAnimal.getCliente().getIdCliente()));
			animalExistente.setCliente(cliente);
		}

		return repository.save(animalExistente);
	}

	public Optional<Animal> buscarAnimal(Long idAnimal) {
		return repository.findById(idAnimal);
	}

	public List<Animal> mostrarTodosAnimal() {
		return repository.findAll();
	}

}
