package com.dailycodebuffer.springboot.tutorial.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ErrorDetails {
    private HttpStatus status;
    private Date timestamp;
    private String message;
    private String details;

    /**
     * @param timestamp
     * @param message
     * @param details
     */
    public ErrorDetails(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    /**
     * @param status
     * @param timestamp
     * @param message
     * @param details
     */
    public ErrorDetails(HttpStatus status, Date timestamp, String message, String details) {
        super();
        this.setStatus(status);
        this.setDetails(details);
        this.setTimestamp(timestamp);
        this.setMessage(message);
    }

    /**
     * @return the status
     */
    public HttpStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
