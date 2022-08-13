package com.portafolio.BackendPortafolio.Controllers;

import com.portafolio.BackendPortafolio.Dto.EmailDto;
import com.portafolio.BackendPortafolio.Dto.Message;
import com.portafolio.BackendPortafolio.Exception.ErrorMessage;
import com.portafolio.BackendPortafolio.Exception.InvalidDataException;
import com.portafolio.BackendPortafolio.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;

@RestController
@RequestMapping("/envio-email")
@CrossOrigin
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("")
    public ResponseEntity<?> enviarCorreoElectronico(@Valid @RequestBody EmailDto emailDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new InvalidDataException(bindingResult);
        }
        try {
            emailService.sendEmail(emailDto.getTo(), emailDto.getSubject(), emailDto.getContent());
            return new ResponseEntity<>(new Message("Correo enviado correctamente"), HttpStatus.OK);

        }catch (Exception e){
            ErrorMessage errorMessage = new ErrorMessage(e, "/envio-email");
            errorMessage.setMessage("Error al enviar el mensaje");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }
    }
}
