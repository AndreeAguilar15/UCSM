import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.traverse.BreadthFirstIterator;

public class GrafoJGraphEjem {

    public static void main(String[] args) {
        //Crear un grafo dirigido con peso
        Graph<String, DefaultWeightedEdge> graph =
                new DefaultDirectedWeightedGraph<>(DefaultWeightedEdge.class);

        //Agregar vértices
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        //Agregar aristas con pesos
        graph.setEdgeWeight(graph.addEdge("A", "B"), 3.0);
        graph.setEdgeWeight(graph.addEdge("A", "C"), 2.0);
        graph.setEdgeWeight(graph.addEdge("B", "D"), 4.0);
        graph.setEdgeWeight(graph.addEdge("C", "D"), 1.0);
        graph.setEdgeWeight(graph.addEdge("D", "E"), 2.5);

        // Imprimir grafo
        System.out.println("Grafo:");
        for (DefaultWeightedEdge edge : graph.edgeSet()) {
            System.out.println(
                graph.getEdgeSource(edge) + " -> " +
                graph.getEdgeTarget(edge) + " (peso: " +
                graph.getEdgeWeight(edge) + ")");
        }

        //Camino mas corto de A a E
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstra =
                new DijkstraShortestPath<>(graph);
        System.out.println("\nCamino más corto de A a E:");
        System.out.println(dijkstra.getPath("A", "E"));

        //Recorrido BFS desde A
        System.out.println("\nRecorrido BFS desde A:");
        BreadthFirstIterator<String, DefaultWeightedEdge> bfs =
                new BreadthFirstIterator<>(graph, "A");

        while (bfs.hasNext()) {
            System.out.print(bfs.next() + " ");
        }
    }
}
