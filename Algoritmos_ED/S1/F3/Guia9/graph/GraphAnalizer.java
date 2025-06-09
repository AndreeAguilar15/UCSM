
    private GraphLink<E> graph;

    public GraphAnalyzer(GraphLink<E> graph) {
        this.graph = graph;
    }

    //Grado de un nodo
    public void printDegrees() {
        System.out.println("Grado de cada nodo:");
        Node<Vertex<E>> current = graph.listVertex.getHead();
        while (current != null) {
            int degree = current.data.listAdj.length();
            System.out.println(current.data.getData() + ": G" + degree);
            current = current.next;
        }
    }

    //Es camino: todos los nodos tienen grado 2, excepto 2 extremos con grado 1
    public boolean isPath() {
        int ones = 0, twos = 0;
        Node<Vertex<E>> current = graph.listVertex.getHead();
        while (current != null) {
            int degree = current.data.listAdj.length();
            if (degree == 1) ones++;
            else if (degree == 2) twos++;
            else return false;
            current = current.next;
        }
        int total = graph.listVertex.length();
        return ones == 2 && twos == (total - 2);
    }

    //Es ciclo: todos los nodos tienen grado 2
    public boolean isCycle() {
        Node<Vertex<E>> current = graph.listVertex.getHead();
        while (current != null) {
            if (current.data.listAdj.length() != 2) return false;
            current = current.next;
        }
        return true;
    }

    //Es rueda: un nodo con grado n-1 y el resto con grado 3 (n >= 4)
    public boolean isWheel() {
        int n = graph.listVertex.length();
        if (n < 4) return false;

        int hubCount = 0;
        int spokeCount = 0;
        Node<Vertex<E>> current = graph.listVertex.getHead();
        while (current != null) {
            int degree = current.data.listAdj.length();
            if (degree == n - 1) hubCount++;
            else if (degree == 3) spokeCount++;
            else return false;
            current = current.next;
        }
        return hubCount == 1 && spokeCount == n - 1;
    }

    //Es completo: cada nodo tiene grado n - 1
    public boolean isComplete() {
        int n = graph.listVertex.length();
        Node<Vertex<E>> current = graph.listVertex.getHead();
        while (current != null) {
            if (current.data.listAdj.length() != n - 1) return false;
            current = current.next;
        }
        return true;
    }

    //Metodo para imprimir el tipo
    public void printGraphType() {
        int n = graph.listVertex.length();
        if (isComplete()) {
            System.out.println("Es un grafo completo: K" + n);
        } else if (isWheel()) {
            System.out.println("Es un grafo rueda: W" + n);
        } else if (isCycle()) {
            System.out.println("Es un ciclo: C" + n);
        } else if (isPath()) {
            System.out.println("Es un camino: P" + n);
        } else {
            System.out.println("No es un tipo especial identificado.");
        }
    }
}
