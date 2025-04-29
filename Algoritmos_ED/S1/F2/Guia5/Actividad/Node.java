public class Node<T> {
    private T dato;
    private Node<T> siguiente;

    public Node(T dato, Node<T> sig) {
        this.dato = dato;
        this.siguiente = sig;
    }
	public T getDato(){
        return dato;
    }
    public Node<T> getSig(){
        return siguiente;
    }
    public void setDato(T elem){
        dato = elem;
    }
    public void setSig(Node<T> sig){
        this.siguiente = sig;
    } 
}


