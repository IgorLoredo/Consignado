package com.example.consignado.service.Exception;

public class DatabaseException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DatabaseException(String msg) {
        super(msg);
    }

    public static class ResourceNotFoundException extends RuntimeException{

        private static final long serialVersionUID = 1L;

        public ResourceNotFoundException(String msg) {
            super(msg);
        }

    }
}
