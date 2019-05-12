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

	public abstract Page<Persona> findByPerApellido(String apellido, Pageable pageable);

	public abstract List<Persona> findByPerTipoDocumentoAndPerNumeroDocumento(String tDoc, long docNro);

	public abstract Page<Persona> findByPerTipoDocumento(String tDoc, Pageable pageable);

	public abstract Page<Persona> findAll(Pageable pageable);

}
