package ar.com.trimix.model;

import java.util.Date;

import ar.com.trimix.entity.Persona;

public class MPersona {
	
	private Long perId;
	private String perApellido;
	private Date perFechaNacimiento;
	private Long perNumeroDocumento;
	private String perTipoDocumento;
	
	
	public MPersona () {
		
	}

	public MPersona (Persona per) {
		this.perId = per.getPerId();
		this.perApellido = per.getPerApellido();
		this.perFechaNacimiento = per.getPerFechaNacimiento();
		this.perNumeroDocumento = per.getPerNumeroDocumento();
		this.perTipoDocumento = per.getPerTipoDocumento();		
	}
	
	public MPersona(Long perId, String perApellido, Date perFechaNacimiento, Long perNumeroDocumento,
			String perTipoDocumento) {
		this.perId = perId;
		this.perApellido = perApellido;
		this.perFechaNacimiento = perFechaNacimiento;
		this.perNumeroDocumento = perNumeroDocumento;
		this.perTipoDocumento = perTipoDocumento;
	}
	
	
	public Long getPerId() {
		return perId;
	}
	public void setPerId(Long perId) {
		this.perId = perId;
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
