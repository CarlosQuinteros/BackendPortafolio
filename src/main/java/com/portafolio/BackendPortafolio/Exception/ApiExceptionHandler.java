package com.portafolio.BackendPortafolio.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({ResourceNotFoundException.class,InvalidDataException.class})
    @ResponseBody
    public ErrorMessage resourceNotFoundException(HttpServletRequest request, Exception exception){
        return new ErrorMessage(exception, request.getRequestURI());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    @ResponseBody
    public ErrorMessage badRequestException(HttpServletRequest request, Exception exception){
        return new ErrorMessage(exception, request.getRequestURI());
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    @ResponseBody
    public ErrorMessage unauthorizedException(HttpServletRequest request, Exception exception){
        return new ErrorMessage(exception, request.getRequestURI());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public ErrorMessage httpRequestMethodNotSupported(HttpServletRequest request, Exception exception){
        ErrorMessage errorMessage = new ErrorMessage(exception, request.getRequestURI());
        return errorMessage;
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseBody
    public ErrorMessage accessDeniedException(HttpServletRequest request, Exception exception){
        ErrorMessage errorMessage = new ErrorMessage(exception, request.getRequestURI());
        errorMessage.setMessage("Acceso denegado");
        return errorMessage;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorMessage fatalErrorUnexpectedException(HttpServletRequest request, Exception exception){
        /*
        nunca enviamos el mensaje o trace al cliente
        lo ideal seria enviar al administrador o desarrolladores
        un correo indicando lo que sucedio para su analisis
        */
        ErrorMessage errorMessage = new ErrorMessage(exception, request.getRequestURI());
        errorMessage.setMessage("Ocurrio un error inesperado. Operacion no realizada");
        System.out.println(exception.getMessage());
        System.out.println(exception.getClass());
        System.out.println(exception.getCause());
        return errorMessage;


    }

}
