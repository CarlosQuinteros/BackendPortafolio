package com.portafolio.BackendPortafolio.Dto;

import javax.validation.constraints.NotBlank;

public class EmailDto {

    @NotBlank(message = "El correo destino es obligatorio")
    private String to;

    @NotBlank(message = "El asunto es obligatorio")
    private String subject;

    @NotBlank(message = "El mensaje es obligatorio")
    private String content;

    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }
}
