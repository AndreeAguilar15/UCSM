import Actividad1.ExceptionIsEmpty;
import Actividad3.PriorityQueue;
import Actividad3.PriorityQueueLinkSort;

public class TestPriorityQueue {
    public static void main(String[] args) {
        try {
            PriorityQueue<String, Integer> pq1 = new PriorityQueueLinkSort<>();

            pq1.enqueue("Tarea 1", 1);
            pq1.enqueue("Tarea 2", 5);
            pq1.enqueue("Tarea 3", 3);
            pq1.enqueue("Tarea 4", 7);
            pq1.enqueue("Tarea 5", 0); //prioridad mas alta

            System.out.println("Contenido de la cola:");
            System.out.println(pq1);

            System.out.println("Elemento al frente: " + pq1.front());
            System.out.println("Elemento al final: " + pq1.back());

            System.out.println("\nDesencolando todos los elementos:");
            while (!pq1.isEmpty()) {
                System.out.println("- " + pq1.dequeue());
            }

            PriorityQueue<String, Double> pq2 = new PriorityQueueLinkSort<>();

            pq2.enqueue("Proceso A", 2.5);
            pq2.enqueue("Proceso B", 0.5);
            pq2.enqueue("Proceso C", 1.2);

            System.out.println("\nContenido de la segunda cola:");
            System.out.println(pq2);

        } catch (ExceptionIsEmpty e) {
            System.err.println("Excepción capturada: "+e.getMessage());
        }
    }
}
