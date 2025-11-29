package backend.Projeto.Petshop.Love.atendimentoServico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.Projeto.Petshop.Love.atendimento.Atendimento;
import backend.Projeto.Petshop.Love.atendimento.AtendimentoRepository;
import backend.Projeto.Petshop.Love.servico.Servico;
import backend.Projeto.Petshop.Love.servico.ServicoRepository;

@Service
public class AtendimentoServicoService {

	@Autowired
	private AtendimentoRepository atendimentoRepository;

	@Autowired
	private ServicoRepository servicoRepository;

	@Autowired
	private AtendimentoServicoRepository atendimentoServicoRepository;

	public AtendimentoServico adicionarServico(Long idAtendimento, Long idServico) {

		// 🔹 Busca o atendimento
		Atendimento atendimento = atendimentoRepository.findById(idAtendimento)
				.orElseThrow(() -> new RuntimeException("Atendimento não encontrado com id " + idAtendimento));

		// 🔹 Busca o serviço
		Servico servico = servicoRepository.findById(idServico)
				.orElseThrow(() -> new RuntimeException("Serviço não encontrado com id " + idServico));

		// 🔹 Cria o vínculo (tabela associativa)
		AtendimentoServico atendimentoServico = new AtendimentoServico();
		atendimentoServico.setAtendimento(atendimento);
		atendimentoServico.setServico(servico);

		// 🔹 Salva e retorna
		return atendimentoServicoRepository.save(atendimentoServico);
	
	}public List<AtendimentoServico> listarTodosVinculos() {
	    return atendimentoServicoRepository.findAll();
	}
	
	

}
