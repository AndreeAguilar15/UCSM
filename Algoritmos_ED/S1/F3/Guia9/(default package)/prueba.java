import graph.GraphLink;

public class prueba {
    public static void main(String[] args) {
        GraphLink<Integer> graph = new GraphLink<>();

        graph.insertVertex(1);
        graph.insertVertex(2);
        graph.insertVertex(3);
        graph.insertVertex(4);

        graph.insertEdge(1, 2);
        graph.insertEdge(1, 3);
        graph.insertEdge(2, 4);
        graph.insertEdge(3, 4);
        graph.insertEdge(4, 1); 

        graph.printList();
    }
}
