package com.example.studentmanagement.handler;

public class ErrorRespond{
    private int status;
    private String message;
    private Long timestamp;

    public ErrorRespond(int status, String message1) {
        this.status = status;
        this.message = message1;
        this.timestamp = System.currentTimeMillis();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
