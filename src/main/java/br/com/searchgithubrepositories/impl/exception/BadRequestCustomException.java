package br.com.searchgithubrepositories.impl.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestCustomException extends RuntimeException {

	private static final long serialVersionUID = 4083816266004260077L;
	private static final Logger logger = LoggerFactory.getLogger(BadRequestCustomException.class);
	
	public BadRequestCustomException(String errorMessage, Throwable err) {
        super(errorMessage);
        logger.error(String.format("%s. Erro: %s", errorMessage, err.getMessage()));
    }

}