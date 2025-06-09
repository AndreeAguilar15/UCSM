package graph;
import ListLinked.*;
import java.util.*;


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
	    Node<Vertex<E>> current = listVertex.getHead();
	    while (current != null) {
	        System.out.print(current.data.getData() + " -> ");
	        
	        Node<Edge<E>> edgeNode = current.data.listAdj.getHead();
	        while (edgeNode != null) {
	            System.out.print(edgeNode.data.toString() + " ");
	            edgeNode = edgeNode.next;
	        }
	        System.out.println();
	        current = current.next;
	    }
	}
	
	public boolean searchVertex(E v) {
	    return listVertex.search(new Vertex<>(v)) != null;
	}
	
	public boolean searchEdge(E v, E z) {
	    Vertex<E> vertex = listVertex.search(new Vertex<>(v));
	    if (vertex == null) return false;

	    Edge<E> edge = new Edge<>(new Vertex<>(z));
	    return vertex.listAdj.search(edge) != null;
	}
	
	public boolean removeVertex(E v) {
	    Vertex<E> vertexToRemove = listVertex.search(new Vertex<>(v));
	    if (vertexToRemove == null) return false;

	    //Eliminar aristas entrantes al vertice
	    Node<Vertex<E>> current = listVertex.getHead();
	    while (current != null) {
	        current.data.listAdj.remove(new Edge<>(vertexToRemove));
	        current = current.next;
	    }

	    //Eliminar el vértice de la lista
	    return listVertex.remove(vertexToRemove);
	}
	
	public boolean removeEdge(E v, E z) {
	    Vertex<E> origin = listVertex.search(new Vertex<>(v));
	    if (origin == null) return false;

	    return origin.listAdj.remove(new Edge<>(new Vertex<>(z)));
	}
	

	public void dfs(E v) {
	    Vertex<E> start = listVertex.search(new Vertex<>(v));
	    if (start == null) {
	        System.out.println("Vértice no encontrado.");
	        return;
	    }

	    HashSet<Vertex<E>> visited = new HashSet<>();
	    dfsRecursive(start, visited);
	}

	private void dfsRecursive(Vertex<E> current, HashSet<Vertex<E>> visited) {
	    if (current == null || visited.contains(current)) return;

	    System.out.print(current.getData() + " ");
	    visited.add(current);

	    Node<Edge<E>> edgeNode = current.listAdj.getHead();
	    while (edgeNode != null) {
	        Vertex<E> neighbor = edgeNode.data.refDest;
	        dfsRecursive(neighbor, visited);
	        edgeNode = edgeNode.next;
	    }
	}
	
	public void bfs(E start) {
        Vertex<E> origin = listVertex.search(new Vertex<>(start));
        if (origin == null) {
            System.out.println("El vertice no existe.");
            return;
        }

        Set<Vertex<E>> visited = new HashSet<>();
        Queue<Vertex<E>> queue = new LinkedList<>();
        visited.add(origin);
        queue.offer(origin);

        while (!queue.isEmpty()) {
            Vertex<E> current = queue.poll();
            System.out.print(current.getData() + " ");

            for (Edge<E> edge : current.listAdj) {
                Vertex<E> neighbor = edge.refDest;
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        System.out.println();
    }
	
	public ArrayList<E> bfsPath(E start, E end) {
        Vertex<E> origin = listVertex.search(new Vertex<>(start));
        Vertex<E> goal = listVertex.search(new Vertex<>(end));
        if (origin == null || goal == null) return null;

        Map<Vertex<E>, Vertex<E>> parentMap = new HashMap<>();
        Queue<Vertex<E>> queue = new LinkedList<>();
        Set<Vertex<E>> visited = new HashSet<>();

        queue.offer(origin);
        visited.add(origin);
        parentMap.put(origin, null);

        while (!queue.isEmpty()) {
            Vertex<E> current = queue.poll();
            if (current.equals(goal)) break;

            for (Edge<E> edge : current.listAdj) {
                Vertex<E> neighbor = edge.refDest;
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parentMap.put(neighbor, current);
                    queue.offer(neighbor);
                }
            }
        }
        ArrayList<E> path = new ArrayList<>();
        for (Vertex<E> at = goal; at != null; at = parentMap.get(at)) {
            path.add(0, at.getData());
        }

        return path.get(0).equals(start) ? path : new ArrayList<>();
    }
	
	public void insertEdgeWeight(E verOri, E verDes, int weight) {
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

        origin.listAdj.add(new Edge<>(destination, weight));
    }

    //Ruta más corta
    public ArrayList<E> shortPath(E start, E end) {
        return bfsPath(start, end);
    }

    //Verifica si es conexo
    public boolean isConexo() {
        if (listVertex.isEmpty()) return true;

        Set<Vertex<E>> visited = new HashSet<>();
        Queue<Vertex<E>> queue = new LinkedList<>();
        Vertex<E> first = listVertex.getHead().data;

        queue.offer(first);
        visited.add(first);

        while (!queue.isEmpty()) {
            Vertex<E> current = queue.poll();
            for (Edge<E> edge : current.listAdj) {
                Vertex<E> neighbor = edge.refDest;
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }

        return visited.size() == listVertex.getSize();
    }

    //Dijkstra
    public Stack<E> dijkstra(E start, E end) {
        Vertex<E> origin = listVertex.search(new Vertex<>(start));
        Vertex<E> goal = listVertex.search(new Vertex<>(end));
        if (origin == null || goal == null) return null;

        Map<Vertex<E>, Integer> distances = new HashMap<>();
        Map<Vertex<E>, Vertex<E>> prev = new HashMap<>();
        PriorityQueue<Vertex<E>> pq = new PriorityQueue<>(Comparator.comparingInt(distances::get));
        Set<Vertex<E>> visited = new HashSet<>();

        for (Vertex<E> v : listVertex) {
            distances.put(v, Integer.MAX_VALUE);
        }
        distances.put(origin, 0);
        pq.add(origin);

        while (!pq.isEmpty()) {
            Vertex<E> current = pq.poll();
            if (!visited.add(current)) continue;

            for (Edge<E> edge : current.listAdj) {
                Vertex<E> neighbor = edge.refDest;
                int weight = edge.getWeight();
                int newDist = distances.get(current) + weight;

                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    prev.put(neighbor, current);
                    pq.offer(neighbor);
                }
            }
        }

        //reconstruir camino
        Stack<E> path = new Stack<>();
        for (Vertex<E> at = goal; at != null; at = prev.get(at)) {
            path.push(at.getData());
        }

        if (!path.isEmpty() && path.peek().equals(start)) {
            return path;
        }
        return new Stack<>();
    }
}
