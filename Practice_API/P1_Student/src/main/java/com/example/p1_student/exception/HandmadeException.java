package com.example.p1_student.exception;

public class HandmadeException extends RuntimeException{
    private String exCode;
    private Long timestamp;

    public HandmadeException(String message, String exCode) {
        super(message);
        this.exCode = exCode;
        this.timestamp = System.currentTimeMillis();
    }

    @Override
    public String getMessage() {
        return super.getMessage() + "with exCode: " + exCode + " and timestamp: " + timestamp;
    }
}
