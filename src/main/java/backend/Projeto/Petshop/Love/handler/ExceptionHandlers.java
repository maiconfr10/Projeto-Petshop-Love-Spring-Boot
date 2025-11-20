package backend.Projeto.Petshop.Love.handler;

import backend.Projeto.Petshop.Love.exceptions.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ExceptionHandlers {

	@ExceptionHandler(AnimalNaoEncontradoException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public ErrorResponse animalNaoEncontrado(AnimalNaoEncontradoException ex, HttpServletRequest request) {
		return new ErrorResponse(404, "Not Found", ex.getMessage(), request.getRequestURI());
	}

	@ExceptionHandler(ClienteNaoEncontradoException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public ErrorResponse clienteNaoEncontrado(ClienteNaoEncontradoException ex, HttpServletRequest request) {
		return new ErrorResponse(404, "Not Found", ex.getMessage(), request.getRequestURI());
	}

	@ExceptionHandler(AtendimentoNaoEncontradoException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public ErrorResponse atendimentoNaoEncontrado(AtendimentoNaoEncontradoException ex, HttpServletRequest request) {
		return new ErrorResponse(404, "Not Found", ex.getMessage(), request.getRequestURI());
	}

	// Erros inesperados (500)
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ErrorResponse erroGeral(Exception ex, HttpServletRequest request) {
		return new ErrorResponse(500, "Internal Server Error", ex.getMessage(), request.getRequestURI());
	}
}
