package proyectoDogSchool;

/**
 *
 * @author candi
 */
public class Usuarios {
    
    private String usuario, nombre, apellido1, apellido2, correo, contrasenia, pregunta, respuesta, deporte;
    private int telefono;

    public Usuarios(String usuario, String nombre, String apellido1, 
            String apellido2, String correo, String contrasenia, 
            String pregunta, String respuesta, String deporte, int telefono) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.deporte = deporte;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "usuario=" + usuario + ", nombre=" + nombre + 
                ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + 
                ", correo=" + correo + ", contrasenia=" + contrasenia + 
                ", pregunta=" + pregunta + ", respuesta=" + respuesta + 
                ", deporte =" + deporte + ", telefono=" + telefono + '}';
    }
    
    public String getDeporte() {
    	return deporte;
    }
    
    public void setDeporte(String deporte) {
    	this.deporte = deporte;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}