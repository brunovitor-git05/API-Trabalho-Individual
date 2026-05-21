package org.serratec.trabalho_individual_api.exception;

public class DuplicateEntryException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DuplicateEntryException(String mensagem) {
		super(mensagem);
	}

}
