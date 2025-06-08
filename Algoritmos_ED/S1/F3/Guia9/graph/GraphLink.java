package graph;
import ListLinked.ListLinked;

public class GraphLink<E> {
	protected ListLinked<Vertex<E>> listVertex;
	public GraphLink() {
		listVertex=new ListLinked<Vertex<E>>();
	}
	
	public void insertVertex(E data) {
		Vertex<E> vertex = new Vertex<>(data);
        if (listVertex.search(vertex) == null) {
            listVertex.add(vertex);
        }
	}
	public void insertEdge(E verOri,E verDes) {
		Vertex<E> origin = listVertex.search(new Vertex<>(verOri));
        Vertex<E> destination = listVertex.search(new Vertex<>(verDes));

        if (origin == null) {
            origin = new Vertex<>(verOri);
            listVertex.add(origin);
        }
        if (destination == null) {
            destination = new Vertex<>(verDes);
            listVertex.add(destination);
        }
        origin.listAdj.add(new Edge<>(destination));
	}

	public void printList() {
		listVertex.printList();
	}
}
