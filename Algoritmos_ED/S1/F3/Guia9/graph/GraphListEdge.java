
    ArrayList<VertexObj<V, E>> secVertex;
    ArrayList<EdgeObj<V, E>> secEdge;

    public GraphListEdge() {
        this.secVertex = new ArrayList<>();
        this.secEdge = new ArrayList<>();
    }

    public boolean insertVertex(V v) {
        if (searchVertex(v)) return false;
        secVertex.add(new VertexObj<>(v, secVertex.size()));
        return true;
    }

    public boolean insertEdge(V v, V z) {
        if (!searchVertex(v)) insertVertex(v);
        if (!searchVertex(z)) insertVertex(z);

        if (searchEdge(v, z)) return false;

        VertexObj<V, E> v1 = getVertex(v);
        VertexObj<V, E> v2 = getVertex(z);
        secEdge.add(new EdgeObj<>(v1, v2, null, secEdge.size()));
        return true;
    }

    public boolean searchVertex(V v) {
        return secVertex.stream().anyMatch(vertex -> vertex.getInfo().equals(v));
    }

    public boolean searchEdge(V v, V z) {
        return secEdge.stream().anyMatch(edge ->
            (edge.getEndVertex1().getInfo().equals(v) && edge.getEndVertex2().getInfo().equals(z)));
    }

    private VertexObj<V, E> getVertex(V v) {
        for (VertexObj<V, E> vertex : secVertex) {
            if (vertex.getInfo().equals(v)) return vertex;
        }
        return null;
    }

    public void bfs(V v) {
        if (!searchVertex(v)) {
            System.out.println("Vertice no encontrado.");
            return;
        }

        Set<V> visited = new HashSet<>();
        Queue<V> queue = new LinkedList<>();

        queue.add(v);
        visited.add(v);

        while (!queue.isEmpty()) {
            V current = queue.poll();
            System.out.print(current + " ");

            for (EdgeObj<V, E> edge : secEdge) {
                V neighbor = null;
                if (edge.getEndVertex1().getInfo().equals(current)) {
                    neighbor = edge.getEndVertex2().getInfo();
                }

                if (neighbor != null && !visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        System.out.println();
    }
}
