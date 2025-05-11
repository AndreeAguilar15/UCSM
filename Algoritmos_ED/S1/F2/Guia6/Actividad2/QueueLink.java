package Actividad2;
import Actividad1.ExceptionIsEmpty;
import fase2.Node;

public class QueueLink<E> implements Queue<E>{
	private Node<E> first;
	private Node<E> last;
	public QueueLink(){
	this.first = null;
	this.last = null;
	}
	
	public void enqueue(E x){
		Node<E> aux = new Node<E>(x,null);
		if (this.isEmpty()) {
		this.first = aux;
		}else {
			this.last.setSig(aux);
			this.last = aux;
		}
	}
	public E dequeue() throws ExceptionIsEmpty {
		if (this.isEmpty()) {
            throw new ExceptionIsEmpty();
        }
        E dato = this.first.getDato();
        this.first = this.first.getSig();
        if (this.first == null) {
            this.last = null;
        }
        return dato;
    }
	public E back() throws ExceptionIsEmpty {
		if (this.isEmpty()) {
            throw new ExceptionIsEmpty();
        }
        return this.last.getDato();
	}
	public E front() throws ExceptionIsEmpty {
		if (this.isEmpty()) {
            throw new ExceptionIsEmpty();
        }
        return this.first.getDato();
    }
	public boolean isEmpty() {
		return this.first == null;
	}
	public String toString(){
	StringBuilder sb = new StringBuilder();
    Node<E> aux = this.first;
    sb.append("[");
    while (aux != null) {
        sb.append(aux.getDato());
        if (aux.getSig() != null) {
            sb.append(", ");
        }
        aux = aux.getSig();
    }
    sb.append("]");
    return sb.toString();
	}
}
