package ar.com.trimix.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ar.com.trimix.entity.Persona;

@Repository("repositorio")
public interface PersonaRepository
		extends JpaRepository<Persona, Serializable>, PagingAndSortingRepository<Persona, Serializable> {

	public abstract Persona findByPerId(Long perId);

	public abstract List<Persona> findByPerApellido(String apellido);

	public abstract List<Persona> findByPerTipoDocumentoAndPerNumeroDocumento(String tDoc, String docNro);

	public abstract Page<Persona> findAll(Pageable pageable);

}
