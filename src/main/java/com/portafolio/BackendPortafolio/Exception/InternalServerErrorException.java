package com.portafolio.BackendPortafolio.Exception;

public class InternalServerErrorException extends RuntimeException {

    public InternalServerErrorException(String message){
        super(message);
    }
}
