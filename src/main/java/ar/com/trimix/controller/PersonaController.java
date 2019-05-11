package ar.com.trimix.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.trimix.entity.Persona;
import ar.com.trimix.model.MPersona;
import ar.com.trimix.service.PersonaService;

@RestController
@RequestMapping("/v1")
public class PersonaController {
	
	@Autowired
	@Qualifier("servicio")
	PersonaService service;
	
	@PutMapping("/persona")
    public boolean agregarPersona(@RequestBody @Valid Persona persona) {
		return service.crear(persona);
	}
	
	@PostMapping("/persona")
    public boolean actualizarPersona(@RequestBody @Valid Persona persona) {
		return service.actualizar(persona);
	}
	
	@DeleteMapping("/persona/{id}")
	public boolean borrarPersona(@PathVariable("id") long id) {
		return service.borrar(id);
	}
	
	@GetMapping("/personas")
	public List<MPersona> obtenerPersonas(){
		return service.obtenerAll();
	}

	@GetMapping("/personaspages")
	public List<MPersona> obtenerPersonas(Pageable pageable){
		return service.obtenerPorPaginacion(pageable);
	}
	
}