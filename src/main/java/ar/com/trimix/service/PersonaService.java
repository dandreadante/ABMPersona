package ar.com.trimix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ar.com.trimix.converter.Convertidor;
import ar.com.trimix.entity.Persona;
import ar.com.trimix.model.MPersona;
import ar.com.trimix.repository.PersonaRepository;

@Service("servicio")
public class PersonaService {

	private static final String DELETE_FAIL = "No existe persona con ID %s en la base de datos.";

	@Autowired
	@Qualifier("repositorio")
	private PersonaRepository repositorio;

	@Autowired
	@Qualifier("convertidor")
	private Convertidor convertidor;

	public boolean crear(Persona persona) {
		try {
			repositorio.save(persona);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	public boolean actualizar(Persona persona) {
		try {
			// Checkquer que este
			repositorio.save(persona);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	public void borrarPersona(Long perId) {
		Persona persona = repositorio.findByPerId(perId);
		if (persona == null) {
			throw new IllegalArgumentException(String.format(DELETE_FAIL, perId));
		}
		repositorio.delete(persona);

	}

	public List<MPersona> obtener() {
		return convertidor.convertirLsita(repositorio.findAll());
	}

	public List<MPersona> obtenerByPerApellido(String apellido) {
		return convertidor.convertirLsita(repositorio.findByPerApellido(apellido));
	}

	public MPersona obtenerByPerId(Long id) {
		return new MPersona(repositorio.findByPerId(id));
	}

	public List<MPersona> obtenerAll() {
		return convertidor.convertirLsita(repositorio.findAll());
	}

	public List<MPersona> obtenerPorPaginacion(Pageable pageable) {
		return convertidor.convertirLsita(repositorio.findAll(pageable).getContent());
	}

}
