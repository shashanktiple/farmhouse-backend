package org.app.farmhouse.exception;

public class TokenExpiredException extends RuntimeException {
    public TokenExpiredException(String errorMessage) {
        super(errorMessage);
    }
}
