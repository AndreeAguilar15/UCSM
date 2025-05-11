package Actividad3;
import fase2.Node;
import Actividad1.ExceptionIsEmpty;

public class PriorityQueueLinkSort<E,N extends Comparable<N>> implements PriorityQueue<E,N> {
	class EntryNode{
		E data;
		N priority;
		EntryNode(E data, N priority){
		this.data = data;
		this.priority = priority;
		}
		public String toString() {
		    return "("+data+", prioridad="+priority+")";
		}
	}
	private Node<EntryNode> first;
	private Node<EntryNode> last;
	
	public PriorityQueueLinkSort (){
		this.first = null;
		this.last = null;
	}
	
	public void enqueue(E x, N pr) {
		EntryNode nuevo = new EntryNode(x, pr);
        Node<EntryNode> nuevoNodo = new Node<>(nuevo, null);

        if (isEmpty()) {
            first = last = nuevoNodo;
            return;
        }
        if (pr.compareTo(first.getDato().priority) < 0) {
            nuevoNodo.setSig(first);
            first = nuevoNodo;
            return;
        }
        Node<EntryNode> actual = first;
        while (actual.getSig() != null &&
               pr.compareTo(actual.getSig().getDato().priority) >= 0) {
            actual = actual.getSig();
        }
        nuevoNodo.setSig(actual.getSig());
        actual.setSig(nuevoNodo);
        if (nuevoNodo.getSig() == null) {
            last = nuevoNodo;
        }
	}
	public E dequeue() throws ExceptionIsEmpty {
		if (isEmpty())
			throw new ExceptionIsEmpty();
			E aux = this.first.getDato().data;
			this.first = this.first.getSig();
			if (this.first == null)
			this.last = null;
			return aux;
	}

	public E front() throws ExceptionIsEmpty {
		if (isEmpty())
            throw new ExceptionIsEmpty();
        return first.getDato().data;
	}

	public E back() throws ExceptionIsEmpty {
		if (isEmpty())
        throw new ExceptionIsEmpty();
    return last.getDato().data;
	}

	public boolean isEmpty() {
		return first == null;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<EntryNode> aux = first;
        while (aux != null) {
            sb.append(aux.getDato());
            if (aux.getSig() != null)
                sb.append(", ");
            aux = aux.getSig();
        }
        sb.append("]");
        return sb.toString();
	}
}
