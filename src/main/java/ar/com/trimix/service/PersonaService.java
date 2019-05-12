package ar.com.trimix.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	private static final String PAR_APELLIDO = "APELLIDO";

	private static final String PERSONA_NOT_FOUND = "No existe persona con ID '%s' en la base de datos.";
	private static final String ERRR_PAR_TIPO_DOC = "Tipo de documento '%s' no valido. Valores permitidos 'DNI', 'CEDULA' o 'PASAPORTE'.";
	private static final String ERRR_PAR_NULL = "Parametro '%s' no valido";
	private Set<String> TIPO_DOC = new HashSet<String>() {
		{
			add("DNI");
			add("CEDULA");
			add("PASAPORTE");
		}
	};

	@Autowired
	@Qualifier("repositorio")
	private PersonaRepository repositorio;

	@Autowired
	@Qualifier("convertidor")
	private Convertidor convertidor;

	public void crearPersona(Persona persona) {

		if (!isValido(persona.getPerApellido())) {
			throw new IllegalArgumentException(String.format(ERRR_PAR_NULL, PAR_APELLIDO));
		}

		if (!isValidoTipoDoc(persona.getPerTipoDocumento())) {
			throw new IllegalArgumentException(String.format(ERRR_PAR_TIPO_DOC, persona.getPerTipoDocumento()));
		}

		repositorio.save(persona);

	}

	public void actualizarPersona(Persona persona) {
		Persona personad = repositorio.findByPerId(persona.getPerId());
		if (personad == null) {
			throw new IllegalArgumentException(String.format(PERSONA_NOT_FOUND, persona.getPerId()));
		}
		if (!isValidoTipoDoc(persona.getPerTipoDocumento())) {
			throw new IllegalArgumentException(String.format(ERRR_PAR_TIPO_DOC, persona.getPerTipoDocumento()));
		}

		repositorio.save(persona);
	}

	public void borrarPersona(Long perId) {
		Persona persona = repositorio.findByPerId(perId);
		if (persona == null) {
			throw new IllegalArgumentException(String.format(PERSONA_NOT_FOUND, perId));
		}
		repositorio.delete(persona);

	}

	public List<MPersona> obtener() {
		return convertidor.convertirLista(repositorio.findAll());
	}

	public List<MPersona> obtenerByPerApellido(String apellido) {
		return convertidor.convertirLista(repositorio.findByPerApellido(apellido));
	}

	public List<MPersona> obtenerByPerApellidoAndPerTipoDocumento(String apellido, String tipoDoc) {
		return convertidor.convertirLista(repositorio.findByPerTipoDocumentoAndPerNumeroDocumento(apellido, tipoDoc));
	}

	public MPersona obtenerByPerId(Long id) {
		return new MPersona(repositorio.findByPerId(id));
	}

	public List<MPersona> obtenerAll(Pageable pageable) {
		return convertidor.convertirLista(repositorio.findAll(pageable).getContent());
	}

	private boolean isValido(String value) {
		return value != null && !value.isEmpty();
	}

	private boolean isValidoTipoDoc(String tipoDoc) {
		return isValido(tipoDoc) && TIPO_DOC.contains(tipoDoc.toUpperCase());
	}
}
