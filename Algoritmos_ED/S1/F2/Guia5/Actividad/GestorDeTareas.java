public class GestorDeTareas<T> {
	private Node<T> cabeza;
    private int numTareas;

    public GestorDeTareas() {
        cabeza = null;
        numTareas = 0;
    }
	
	public void agregar(T Tarea) {
        Node<T> nuevoNodo = new Node<>(Tarea, null);
		if (cabeza == null) {
			cabeza = nuevoNodo;
        } else {
            Node<T> actual = cabeza;
            while (actual.getSig() != null) {
                actual = actual.getSig();
            }
            actual.setSig(nuevoNodo);
        }
        numTareas++;
    }
	public boolean eliminarTarea(T Tarea) {
		if (cabeza == null) {
            return false;
        }
        if (cabeza.getDato().equals(Tarea)) {
            cabeza = cabeza.getSig();
            numTareas--;
            return true;
        }

        Node<T> actual = cabeza;
        while (actual.getSig()!= null) {
            if (actual.getSig().getDato().equals(Tarea)) {
                actual.setSig(actual.getSig().getSig());
                numTareas--;
                return true;
            }
            actual=actual.getSig();
        }
        return false; 
    }

	public boolean contieneTarea(T Tarea) {
		if (cabeza == null) {
            return false;
        }
        if (cabeza.getDato().equals(Tarea)) {
            return true;
        }

        Node<T> actual = cabeza;
        while (actual.getSig()!= null) {
            if (actual.getSig().getDato().equals(Tarea)) {
                return true;
            }
            actual=actual.getSig();
        }
        return false; 
    }
	
	public void imprimirTareas() {
	   Node<T> actual = cabeza;
	   while (actual != null) {
	       System.out.println(actual.getDato());
	       actual = actual.getSig();
	    }
	}
		
	public int contarTareas() {
		return numTareas;
	}
	public T obtenerTareaMasPrioritaria() {
		if (cabeza == null|| !(cabeza.getDato() instanceof Tarea)) {
            return null;
        }

        Node<T> actual = cabeza;
        Tarea tareaPrioritaria = (Tarea) actual.getDato();

        while (actual != null) {
            if (actual.getDato() instanceof Tarea) {
                Tarea tareaActual = (Tarea) actual.getDato();
                if (tareaActual.getPrioridad() < tareaPrioritaria.getPrioridad()) {
                    tareaPrioritaria = tareaActual;
                }
            }
            actual = actual.getSig();
        }
        return (T) tareaPrioritaria;
	}
	public void invertirTareas() {
        Node<T> anterior = null;
        Node<T> actual = cabeza;
        Node<T> siguiente = null;

        while (actual != null) {
            siguiente = actual.getSig(); 
            actual.setSig(anterior);
            anterior = actual; 
            actual = siguiente; 
        }
        cabeza = anterior;
    }
}

