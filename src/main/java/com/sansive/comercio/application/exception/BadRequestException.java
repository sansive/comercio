package com.sansive.comercio.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception to represent a "Bad Request" (HTTP 400) error.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    /**
     * Default constructor.
     *
     * @param message   the exception message
     */
    public BadRequestException(String message) {
        super(message);
    }
}