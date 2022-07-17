package com.portafolio.BackendPortafolio.Exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ErrorMessage {
    private ZonedDateTime timestamp;
    private String message;
    private String exception;
    private String path;

    public ErrorMessage(){}

    public ErrorMessage(Exception exception, String path) {
        this.timestamp = ZonedDateTime.now(ZoneId.systemDefault());
        this.message = exception.getMessage();
        this.exception = exception.getClass().getSimpleName();
        this.path = path;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
