package com.portafolio.BackendPortafolio;

import com.portafolio.BackendPortafolio.Entity.Domicilio;
import com.portafolio.BackendPortafolio.Entity.ExperienciaLaboral;
import com.portafolio.BackendPortafolio.Entity.Persona;
import com.portafolio.BackendPortafolio.Enum.TipoJornada;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Month;

@SpringBootTest
class BackendPortafolioApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void timeAgoExperienciaAdmDeRed(){
		Domicilio domicilioCarlos = new Domicilio("La plata", 528, "chilecito, La Rioja Argentina1");
		Persona carlos = new Persona("Carlos","Quinteros", "38223076",LocalDate.of(1995, Month.FEBRUARY,17),"","","","","", domicilioCarlos);
		ExperienciaLaboral experienciaLaboral = new ExperienciaLaboral("E.P.E.T. N° 2 PAULA A. DE SARMIENTO","","Administrador de red", "administrar conectar igualdad", TipoJornada.PARCIAL,LocalDate.of(2017,Month.JUNE,1),null, carlos);
		System.out.println(experienciaLaboral.getDuracion());
	}

	@Test
	void timeAgoExperienciaTutoria(){
		Domicilio domicilioCarlos = new Domicilio("La plata", 528, "chilecito, La Rioja Argentina1");
		Persona carlos = new Persona("Carlos","Quinteros", "38223076",LocalDate.of(1995, Month.FEBRUARY,17),"","","","","", domicilioCarlos);
		ExperienciaLaboral experienciaLaboral = new ExperienciaLaboral("E.P.E.T. N° 1","Tutorias", "", "Tutorias de matematica, fisica electronica", TipoJornada.PARCIAL,LocalDate.of(2014,Month.AUGUST,1),LocalDate.of(2014,Month.DECEMBER,15), carlos);
		System.out.println(experienciaLaboral.getDuracion());
	}

}
