package org.serratec.trabalho_individual_api.exception;

import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
@ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<String> handleNotFound(ResourceNotFoundException ex) {
	return ResponseEntity.status(404).body(ex.getMessage());
	}
	
@ExceptionHandler(DuplicateEntryException.class)
public ResponseEntity<String> handleDuplicateEntry(DuplicateEntryException ex) {
	return ResponseEntity.status(409).body(ex.getMessage());
}

@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<String> handleValidation(MethodArgumentNotValidException ex) {
	String mensagem = ex.getBindingResult().getFieldErrors()
			.stream()
			.map(error -> error.getField() + ": " + error.getDefaultMessage())
			.collect(Collectors.joining("; "));
	
	return ResponseEntity.status(400).body(mensagem);
}

}

