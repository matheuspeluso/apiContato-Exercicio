package aluno.Matheus.Peluso.handlers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ArgumentExceptionHandler {
	/*
	 * Método para capturar erros gerados pela exceção: IllegalArgumentException
	 */
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public List<String> errorHandler(IllegalArgumentException e) {

		var errors = new ArrayList<String>();
		errors.add(e.getMessage());

		return errors;
	}
}