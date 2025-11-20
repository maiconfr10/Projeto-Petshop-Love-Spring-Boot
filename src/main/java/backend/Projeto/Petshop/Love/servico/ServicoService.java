package backend.Projeto.Petshop.Love.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import backend.Projeto.Petshop.Love.dto.servico.ServicoListDTO;

@Service
public class ServicoService {
	@Autowired
	private ServicoRepository repository;

	public Servico cadastrarServico(Servico servico) {
		return repository.save(servico);
	}

	public List<Servico> listarServico() {
		return repository.findAll();
	}

	public void removerServico(Long idServico) {
		repository.deleteById(idServico);
	}

	public Servico atualizarServico(Long idServico, Servico novoServico) {
		Servico servicoExistente = repository.findById(idServico)
				.orElseThrow(() -> new RuntimeException("Serviço não encontrado com o id" + idServico));

		servicoExistente.setDescricao(novoServico.getDescricao());
		servicoExistente.setPreco(novoServico.getPreco());

		return repository.save(servicoExistente);

	}public Optional<Servico> procurarServico(Long idServico) {
		return repository.findById(idServico);
	}

	public ServicoListDTO listarServicosComTotal() {
	    List<Servico> servicos = repository.findAll();

	    Double total = servicos.stream()
	            .mapToDouble(Servico::getPreco)
	            .sum();

	    return new ServicoListDTO(servicos, total);
	}



}
