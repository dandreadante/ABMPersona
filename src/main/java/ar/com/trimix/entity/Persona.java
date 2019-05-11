package ar.com.trimix.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Table(name="PERSONA")
@Entity
public class Persona implements Serializable {
	
	@GeneratedValue
	@Id
	@Column(name="ID_PER")
	private Long perId;
	
	@Column(name="APELLIDO")
	private String perApellido;
	
	@Column(name="FECHANAC")
	private Date perFechaNacimiento;
	
	@Column(name="DOCNRO")
	private Long perNumeroDocumento;
	
	@Column(name="DOCTYPE")
	private String perTipoDocumento;
	
	/**
	 * Constructo por defecto
	 */
	public Persona() {
	}
	
	
	/**
	 * Constructor
	 * @param perApellido
	 * @param date
	 * @param perNumeroDocumento
	 * @param perTipoDocumento
	 */
	public Persona(String perApellido,  Date date,  Long perNumeroDocumento, String perTipoDocumento) {
		this.perApellido = perApellido;
		this.perFechaNacimiento = date;
		this.perNumeroDocumento = perNumeroDocumento;
		this.perTipoDocumento = perTipoDocumento;
	}
	
	public String getPerApellido() {
		return perApellido;
	}
	
	public void setPerApellido(String perApellido) {
		this.perApellido = perApellido;
	}
	
	public Date getPerFechaNacimiento() {
		return perFechaNacimiento;
	}
	
	public void setPerFechaNacimiento(Date perFechaNacimiento) {
		this.perFechaNacimiento = perFechaNacimiento;
	}
	
	public Long getPerId() {
		return perId;
	}
	
	public void setPerId(Long perId) {
		this.perId = perId;
	}
	
	public Long getPerNumeroDocumento() {
		return perNumeroDocumento;
	}
	
	public void setPerNumeroDocumento(Long perNumeroDocumento) {
		this.perNumeroDocumento = perNumeroDocumento;
	}
	
	public String getPerTipoDocumento() {
		return perTipoDocumento;
	}
	
	public void setPerTipoDocumento(String perTipoDocumento) {
		this.perTipoDocumento = perTipoDocumento;
	}

}