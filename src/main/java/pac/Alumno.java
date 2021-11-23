package pac;

import java.util.HashSet;
import java.util.Set;

public class Alumno {
	
	private Long id;
	private String nombre;
	private String nacionalidad;
	private int edad;
	private String sexo;
	private Set<Modulo> modulos=new HashSet<Modulo>();
	
	public Alumno() {		
	}
	
	public Alumno(String nombre,String nacionalidad,int edad,String sexo) {		
		this.nombre=nombre;
		this.nacionalidad=nacionalidad;
		this.edad=edad;
		this.sexo=sexo;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	
	public Set<Modulo> getModulos() {
		return modulos;
	}

	public void setModulos(Set<Modulo> modulos) {
		this.modulos = modulos;
	}

	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", edad=" + edad
				+ ", sexo=" + sexo + ", alumno_modulo=" + modulos + "]";
	}
	
	
	
	

}
