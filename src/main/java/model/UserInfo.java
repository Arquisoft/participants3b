package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Entity
@Table(name="TCitizens")
public class UserInfo implements Serializable{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private long id;
	private String nombre;
	private String apellidos;
	private String email;
	@Temporal(TemporalType.DATE) private Date fechaNacimiento;
	private String direccion;
	private String nacionalidad;
	@Column(name = "DNI")
	@NotNull private String dni;
	
	private String usuario;
	@Column(name = "password")
	private String pass;
	
	UserInfo(){}
	
	public UserInfo(String usuario, String pass, String email,
			String dni, String nombre, String apellidos, Date fechaNacimiento,
			String direccion, String nacionalidad) {
		super();
		this.usuario = usuario;
		this.pass = pass;
		this.email = email;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.nacionalidad = nacionalidad;
	}

	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return pass;
	}
	public void setPassword(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccionPostal) {
		this.direccion = direccionPostal;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInfo other = (UserInfo) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Citizen [nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email
				+ ", fechaNacimiento=" + fechaNacimiento + ", direccion=" + direccion + ", nacionalidad=" + nacionalidad
				+ ", dni=" + dni + ", password=" + pass + "]";
	}
    
}