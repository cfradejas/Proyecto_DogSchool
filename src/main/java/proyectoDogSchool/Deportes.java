package proyectoDogSchool;

public class Deportes {

	private int id;
	private String deporte;
	private String orden;
	
	public Deportes(int id, String deporte, String orden) {
		this.id = id;
		this.deporte = deporte;
		this.orden = orden;
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

	public String getOrden() {
		return orden;
	}

	public void setOrden(String orden) {
		this.orden = orden;
	}

	@Override
	public String toString() {
		return "Deportes [id=" + id + ", deporte=" + deporte + ", orden=" + orden + "]";
	}
}