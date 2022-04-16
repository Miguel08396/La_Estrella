package Models.Class;

public class TiposServicio {
	
	private String tiposServicio;
	private String descripcionTiposServicio;
	private int preciotiposServicio;

	public TiposServicio(String tiposServicio, String descripcionTiposServicio, int preciotiposServicio) {
		this.tiposServicio = tiposServicio;
		this.descripcionTiposServicio = descripcionTiposServicio;
		this.preciotiposServicio = preciotiposServicio;
	}

	public String getTiposServicio() {
		return tiposServicio;
	}

	public void setTiposServicio(String tiposServicio) {
		this.tiposServicio = tiposServicio;
	}

	public String getDescripcionTiposServicio() {
		return descripcionTiposServicio;
	}

	public void setDescripcionTiposServicio(String descripcionTiposServicio) {
		this.descripcionTiposServicio = descripcionTiposServicio;
	}

	public int getPreciotiposServicio() {
		return preciotiposServicio;
	}

	public void setPreciotiposServicio(int preciotiposServicio) {
		this.preciotiposServicio = preciotiposServicio;
	}

}