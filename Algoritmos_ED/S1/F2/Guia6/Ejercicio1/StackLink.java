package Ejercicio1;
import Actividad1.ExceptionIsEmpty;
import Actividad1.Stack;
import fase2.Node;

public class StackLink<E> implements Stack<E>{
	private Node<E> tope;
	public StackLink(){
		this.tope=null;
	}
	public void push(E x) {
		tope = new Node<>(x, tope);
	}

	public E pop() throws ExceptionIsEmpty {
		if (isEmpty()) {
            throw new ExceptionIsEmpty();
		}
		E dato=tope.getDato();
        tope = tope.getSig();
        return dato;
	}

	public E top() throws ExceptionIsEmpty {
		if (isEmpty()) {
            throw new ExceptionIsEmpty();
        }
        return tope.getDato();
    }

	public boolean isEmpty() {
		return tope == null;
	}

	public String toString() {
		if (isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        Node<E> aux = tope;
        while (aux != null) {
            sb.append(aux.getDato());
            aux = aux.getSig();
            if (aux != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
