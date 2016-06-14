package co.edu.usbcali.modelo;
// Generated 23-feb-2016 9:55:35 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

/**
 * Usuarios generated by hbm2java
 */
public class Usuarios implements java.io.Serializable {

	private long usuCedula;
	private TiposUsuarios tiposUsuarios;
	private String usuNombre;
	private String usuLogin;
	private String usuClave;
	private Set<Consignaciones> consignacioneses = new HashSet<Consignaciones>(0);
	private Set<Retiros> retiroses = new HashSet<Retiros>(0);

	public Usuarios() {
	}

	public Usuarios(long usuCedula, String usuNombre, String usuLogin, String usuClave) {
		this.usuCedula = usuCedula;
		this.usuNombre = usuNombre;
		this.usuLogin = usuLogin;
		this.usuClave = usuClave;
	}

	public Usuarios(long usuCedula, TiposUsuarios tiposUsuarios, String usuNombre, String usuLogin, String usuClave,
			Set<Consignaciones> consignacioneses, Set<Retiros> retiroses) {
		this.usuCedula = usuCedula;
		this.tiposUsuarios = tiposUsuarios;
		this.usuNombre = usuNombre;
		this.usuLogin = usuLogin;
		this.usuClave = usuClave;
		this.consignacioneses = consignacioneses;
		this.retiroses = retiroses;
	}

	public long getUsuCedula() {
		return this.usuCedula;
	}

	public void setUsuCedula(long usuCedula) {
		this.usuCedula = usuCedula;
	}

	public TiposUsuarios getTiposUsuarios() {
		return this.tiposUsuarios;
	}

	public void setTiposUsuarios(TiposUsuarios tiposUsuarios) {
		this.tiposUsuarios = tiposUsuarios;
	}

	public String getUsuNombre() {
		return this.usuNombre;
	}

	public void setUsuNombre(String usuNombre) {
		this.usuNombre = usuNombre;
	}

	public String getUsuLogin() {
		return this.usuLogin;
	}

	public void setUsuLogin(String usuLogin) {
		this.usuLogin = usuLogin;
	}

	public String getUsuClave() {
		return this.usuClave;
	}

	public void setUsuClave(String usuClave) {
		this.usuClave = usuClave;
	}

	public Set<Consignaciones> getConsignacioneses() {
		return this.consignacioneses;
	}

	public void setConsignacioneses(Set<Consignaciones> consignacioneses) {
		this.consignacioneses = consignacioneses;
	}

	public Set<Retiros> getRetiroses() {
		return this.retiroses;
	}

	public void setRetiroses(Set<Retiros> retiroses) {
		this.retiroses = retiroses;
	}

}
