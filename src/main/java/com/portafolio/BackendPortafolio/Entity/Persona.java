package com.portafolio.BackendPortafolio.Entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Persona {

    private Long id;


    @NotNull
    private String nombres;

    @NotNull
    private String apellido;

}
