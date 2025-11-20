package backend.Projeto.Petshop.Love.exceptions;

public class AtendimentoNaoEncontradoException extends RuntimeException {
	public AtendimentoNaoEncontradoException(Long id) {
		super("Atendimento não encontrado com id: " + id);
	}
}
