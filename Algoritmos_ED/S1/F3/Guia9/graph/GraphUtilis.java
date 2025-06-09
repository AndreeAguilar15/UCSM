
 public static <E> int gradoEntrante(GraphLink<E> g, E data) {
     int count = 0;
     for (Vertex<E> v : g.getListVertex()) {
         for (Edge<E> e : v.listAdj) {
             if (e.refDest.getData().equals(data)) {
                 count++;
             }
         }
     }
     return count;
 }

 public static <E> int gradoSaliente(GraphLink<E> g, E data) {
     Vertex<E> v = g.findVertex(data);
     return v != null ? v.listAdj.getSize() : 0;
 }

 //Camino (todos conectados linealmente, sin cerrar ciclo)
 public static <E> boolean esCamino(GraphLink<E> g) {
     int extremos = 0;
     for (Vertex<E> v : g.getListVertex()) {
         int grado = v.listAdj.getSize();
         if (grado == 1) extremos++;
         else if (grado > 2) return false;
     }
     return extremos == 2;
 }

 //Ciclo (todos con grado 2)
 public static <E> boolean esCiclo(GraphLink<E> g) {
     for (Vertex<E> v : g.getListVertex()) {
         if (v.listAdj.getSize() != 2) return false;
     }
     return true;
 }

 public static <E> boolean esRueda(GraphLink<E> g) {
     int n = g.getListVertex().getSize();
     for (Vertex<E> centro : g.getListVertex()) {
         int centroConexiones = centro.listAdj.getSize();
         if (centroConexiones == n - 1) {
             int ciclo = 0;
             for (Vertex<E> v : g.getListVertex()) {
                 if (v != centro && v.listAdj.getSize() == 3) ciclo++;
             }
             return ciclo == n - 1;
         }
     }
     return false;
 }

 //Completo:todos conectados entre sí
 public static <E> boolean esCompleto(GraphLink<E> g) {
     int n = g.getListVertex().getSize();
     for (Vertex<E> v : g.getListVertex()) {
         if (v.listAdj.getSize() != n - 1) return false;
     }
     return true;
 }

 //Representaciones formales
 public static <E> void imprimirFormal(GraphLink<E> g) {
     System.out.print("V = { ");
     for (Vertex<E> v : g.getListVertex()) System.out.print(v.getData() + " ");
     System.out.println("}");

     System.out.print("E = { ");
     for (Vertex<E> v : g.getListVertex()) {
         for (Edge<E> e : v.listAdj) {
             System.out.print("(" + v.getData() + "," + e.refDest.getData() + ") ");
         }
     }
     System.out.println("}");
 }

 public static <E> void imprimirListaAdyacencia(GraphLink<E> g) {
     for (Vertex<E> v : g.getListVertex()) {
         System.out.print(v.getData() + ": ");
         for (Edge<E> e : v.listAdj) System.out.print(e.refDest.getData() + " ");
         System.out.println();
     }
 }

 public static <E> void imprimirMatrizAdyacencia(GraphLink<E> g) {
     List<Vertex<E>> list = new ArrayList<>();
     for (Vertex<E> v : g.getListVertex()) list.add(v);
     int n = list.size();
     int[][] mat = new int[n][n];

     for (int i = 0; i < n; i++) {
         Vertex<E> v = list.get(i);
         for (Edge<E> e : v.listAdj) {
             int j = list.indexOf(e.refDest);
             mat[i][j] = 1;
             if (!g.isDirected()) mat[j][i] = 1;
         }
     }

     System.out.print("    ");
     for (Vertex<E> v : list) System.out.print(v.getData() + " ");
     System.out.println();

     for (int i = 0; i < n; i++) {
         System.out.print(list.get(i).getData() + ": ");
         for (int j = 0; j < n; j++) System.out.print(mat[i][j] + " ");
         System.out.println();
     }
 }

 //Isomorfismo simple por numero de vertices y aristas
 public static <E> boolean esIsomorfo(GraphLink<E> g1, GraphLink<E> g2) {
     return g1.getListVertex().getSize() == g2.getListVertex().getSize()
         && contarAristas(g1) == contarAristas(g2);
 }

 public static <E> int contarAristas(GraphLink<E> g) {
     int total = 0;
     for (Vertex<E> v : g.getListVertex()) total += v.listAdj.getSize();
     return g.isDirected() ? total : total / 2;
 }

 //Conexo usando BFS
 public static <E> boolean esConexo(GraphLink<E> g) {
     if (g.getListVertex().isEmpty()) return true;
     Set<Vertex<E>> visitados = new HashSet<>();
     Queue<Vertex<E>> cola = new LinkedList<>();
     Vertex<E> start = g.getListVertex().getHead().data;
     cola.add(start);

     while (!cola.isEmpty()) {
         Vertex<E> actual = cola.poll();
         if (!visitados.contains(actual)) {
             visitados.add(actual);
             for (Edge<E> e : actual.listAdj) cola.add(e.refDest);
         }
     }
     return visitados.size() == g.getListVertex().getSize();
 }


 public static <E> boolean esPlano(GraphLink<E> g) {
     int n = g.getListVertex().getSize();
     int m = contarAristas(g);
     return m <= 3 * n - 6;
 }

 public static <E> boolean esAutoComplementario(GraphLink<E> g) {
     GraphLink<E> complemento = crearComplemento(g);
     return esIsomorfo(g, complemento);
 }

 private static <E> GraphLink<E> crearComplemento(GraphLink<E> g) {
     GraphLink<E> comp = new GraphLink<>(true);
     for (Vertex<E> v : g.getListVertex()) comp.insertVertex(v.getData());

     for (Vertex<E> v1 : g.getListVertex()) {
         for (Vertex<E> v2 : g.getListVertex()) {
             if (!v1.equals(v2) && g.findEdge(v1.getData(), v2.getData()) == null) {
                 comp.insertEdge(v1.getData(), v2.getData(), null);
             }
         }
     }
     return comp;
 }
}
