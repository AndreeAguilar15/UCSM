public class Tarea {
	private String titulo;
	private int prioridad;
	public Tarea(String titulo,int prioridad) {
		this.titulo=titulo;
		this.prioridad=prioridad;
	};
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
	@Override
	public String toString() {
		return "Tarea [titulo="+titulo+", prioridad="+prioridad+"]";
	}
	public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Tarea tarea = (Tarea) obj;
        return this.titulo.equals(tarea.titulo) && this.prioridad == tarea.prioridad;
    }
}

