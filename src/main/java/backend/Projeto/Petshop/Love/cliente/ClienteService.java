package backend.Projeto.Petshop.Love.cliente;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import backend.Projeto.Petshop.Love.animal.Animal;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	public void removerCliente(Long idCliente) {
		if (!repository.existsById(idCliente)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado com Id " + idCliente);
		}
		repository.deleteById(idCliente);
	}

	public ClienteEntitie atualizarCliente(Long idCliente, ClienteEntitie novoCliente) {

		ClienteEntitie clienteExistente = repository.findById(idCliente).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado com Id " + idCliente));

		clienteExistente.setNomeCliente(novoCliente.getNomeCliente());
		clienteExistente.setTeleCliente(novoCliente.getTeleCliente());
		clienteExistente.setEmailCliente(novoCliente.getEmailCliente());
		return repository.save(clienteExistente);

	}public ClienteEntitie cadastrarCliente(ClienteEntitie cliente) {
	    return repository.save(cliente);
	}


	public List<Animal> ListaAnimaisCliente(Long idCliente) {
		ClienteEntitie cliente = repository.findById(idCliente).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado com Id " + idCliente));
		return cliente.getAnimais();
	}

	public List<ClienteEntitie> listaCliente() {
		return repository.findAll();
	}

	public Optional<ClienteEntitie> buscarCliente(Long idCliente) {
		return repository.findById(idCliente);
	}
}
