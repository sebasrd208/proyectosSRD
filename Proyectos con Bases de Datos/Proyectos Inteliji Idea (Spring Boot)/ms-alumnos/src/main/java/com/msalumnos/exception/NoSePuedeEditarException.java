package com.msalumnos.exception;

public class NoSePuedeEditarException extends RuntimeException{

    private static final long serialVersionUID=1L;

    public NoSePuedeEditarException() {

    }

    public NoSePuedeEditarException(String message) {
        super(message);
    }

    public NoSePuedeEditarException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSePuedeEditarException(Throwable cause) {
        super(cause);
    }

    public NoSePuedeEditarException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
