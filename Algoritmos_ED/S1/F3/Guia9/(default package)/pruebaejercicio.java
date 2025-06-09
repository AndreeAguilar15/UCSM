import graph.GraphListEdge;

public class pruebaejercicio {
	public static void main(String[] args) {
        GraphListEdge<Integer, Object> graph = new GraphListEdge<>();

        graph.insertVertex(1);
        graph.insertVertex(2);
        graph.insertVertex(3);
        graph.insertVertex(4);

        graph.insertEdge(1, 2);
        graph.insertEdge(1, 3);
        graph.insertEdge(2, 4);
        graph.insertEdge(3, 4);
        graph.insertEdge(4, 1);

        System.out.println("¿Existe vertice 3? " + graph.searchVertex(3));
        System.out.println("¿Existe arista 1 -> 3? " + graph.searchEdge(1, 3));

        System.out.println("Recorrido BFS desde 1:");
        graph.bfs(1);
    }
}
