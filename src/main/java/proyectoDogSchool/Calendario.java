package proyectoDogSchool;

public class Calendario {
	
	private int id;
	private String deporte, fecha, maniana_tarde, infoDia, usuario;

	public Calendario(int id, String deporte, String fecha, String maniana_tarde, String infoDia, String usuario) {
		this.id = id;
		this.deporte = deporte;
		this.fecha = fecha;
		this.maniana_tarde = maniana_tarde;
		this.infoDia = infoDia;
		this.usuario = usuario;
	}
	public Calendario(String deporte, String fecha, String maniana_tarde, String infoDia, String usuario) {
		this.deporte = deporte;
		this.fecha = fecha;
		this.maniana_tarde = maniana_tarde;
		this.infoDia = infoDia;
		this.usuario = usuario;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeporte() {
		return deporte;
	}
	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getManiana_tarde() {
		return maniana_tarde;
	}
	public void setManiana_tarde(String maniana_tarde) {
		this.maniana_tarde = maniana_tarde;
	}
	public String getInfoDia() {
		return infoDia;
	}
	public void setInfoDia(String infoDia) {
		this.infoDia = infoDia;
	}
	@Override
	public String toString() {
		return "Calendario [id=" + id + ", deporte=" + deporte + ", fecha=" + fecha + ", maniana_tarde=" + maniana_tarde
				+ ", infoDia=" + infoDia + ", usuario=" + usuario + "]";
	}
}