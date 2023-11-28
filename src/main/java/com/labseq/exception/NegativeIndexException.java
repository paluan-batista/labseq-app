package com.labseq.exception;

public class NegativeIndexException extends RuntimeException {
    public NegativeIndexException(String message) {
        super(message);
    }
}