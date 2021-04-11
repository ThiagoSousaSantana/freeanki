package br.com.freeanki.utils.exceptions;

import lombok.Data;

import java.io.Serializable;

@Data
public class StandardError implements Serializable {

    private Integer status;
    private String message;
    private String error;
    private long timestamp;
    private String path;

    public StandardError(Integer status, String message, String error, long timestamp, String path) {
        this.status = status;
        this.message = message;
        this.error = error;
        this.timestamp = timestamp;
        this.path = path;
    }


}
