package proyectoDogSchool;

public class Clientes {

	private String dni, nombre, apellido1, apellido2, correo, perro, raza_perro, deporte;
    private int telefono;
    
	public Clientes(String dni, String nombre, String apellido1, String apellido2, String correo, String perro,
			String raza_perro, String deporte, int telefono) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.correo = correo;
		this.perro = perro;
		this.raza_perro = raza_perro;
		this.deporte = deporte;
		this.telefono = telefono;
	}
	@Override
	public String toString() {
		return "Clientes [dni=" + dni + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
				+ ", correo=" + correo + ", perro=" + perro + ", raza_perro=" + raza_perro + ", deporte=" + deporte
				+ ", telefono=" + telefono + "]";
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
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPerro() {
		return perro;
	}
	public void setPerro(String perro) {
		this.perro = perro;
	}
	public String getRaza_perro() {
		return raza_perro;
	}
	public void setRaza_perro(String raza_perro) {
		this.raza_perro = raza_perro;
	}
	public String getDeporte() {
		return deporte;
	}
	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	} 
}