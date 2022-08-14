package com.portafolio.BackendPortafolio.Controllers;

import com.portafolio.BackendPortafolio.Dto.EmailDto;
import com.portafolio.BackendPortafolio.Dto.Message;
import com.portafolio.BackendPortafolio.Exception.ErrorMessage;
import com.portafolio.BackendPortafolio.Exception.InvalidDataException;
import com.portafolio.BackendPortafolio.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/contacto")
@CrossOrigin("*")
public class ContactoController {

    @Autowired
    private EmailService emailService;

    @PostMapping("")
    public ResponseEntity<?> enviarMensajeContacto(@Valid @RequestBody EmailDto emailDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()) throw new InvalidDataException(bindingResult);
        try {
            emailService.sendEmail(emailDto.getTo(), emailDto.getSubject(), emailDto.getContent());
            return new ResponseEntity<>(new Message("Mensaje enviado correctamente"), HttpStatus.OK);

        }catch (Exception e){
            ErrorMessage errorMessage = new ErrorMessage(e, "/contacto");
            errorMessage.setMessage("Error al enviar el mensaje");
            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
        }
    }
}
