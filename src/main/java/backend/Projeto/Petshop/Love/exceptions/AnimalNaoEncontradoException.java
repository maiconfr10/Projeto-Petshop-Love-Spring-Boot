package backend.Projeto.Petshop.Love.exceptions;

public class AnimalNaoEncontradoException extends RuntimeException {
	public AnimalNaoEncontradoException(Long id) {
		super("Animal não encontrado com id: " + id);
	}
}
