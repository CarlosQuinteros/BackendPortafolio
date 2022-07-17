package com.portafolio.BackendPortafolio.Exception;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.stream.Collectors;

public class InvalidDataException extends RuntimeException{
    public InvalidDataException(BindingResult bindingResult){
        super(bindingResult.getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining(". "))
        );
    }
}
