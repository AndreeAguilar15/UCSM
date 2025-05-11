import Actividad1.ExceptionIsEmpty;
import Actividad2.QueueLink;

public class TestQueue {
	public static void main(String[] args) {
        // Pruebas con enteros
        QueueLink<Integer> colaEnteros = new QueueLink<>();
        System.out.println("Cola de Enteros");
        try {
            colaEnteros.enqueue(10);
            colaEnteros.enqueue(20);
            colaEnteros.enqueue(30);

            System.out.println("Contenido: "+colaEnteros);
            System.out.println("Frente: "+colaEnteros.front());
            System.out.println("Final: "+colaEnteros.back());

            while (!colaEnteros.isEmpty()) {
                System.out.println("Eliminando: "+colaEnteros.dequeue());
            }

            //Intentar desencolar desde cola vacía
            System.out.println("Intentando eliminar de cola vacía...");
            colaEnteros.dequeue();

        } catch (ExceptionIsEmpty e) {
            System.err.println("Excepción capturada: " + e.getMessage());
        }

        System.out.println();

        //Pruebas con Strings
        QueueLink<String> colaTexto = new QueueLink<>();
        System.out.println("Cola de Strings");
        try {
            colaTexto.enqueue("Uno");
            colaTexto.enqueue("Dos");
            colaTexto.enqueue("Tres");

            System.out.println("Contenido: " + colaTexto);
            System.out.println("Frente: " + colaTexto.front());
            System.out.println("Final: " + colaTexto.back());

            while (!colaTexto.isEmpty()) {
                System.out.println("Eliminando: " + colaTexto.dequeue());
            }

            //Intentar acceder al frente en una cola vacía
            System.out.println("Intentando ver frente de cola vacía...");
            colaTexto.front();

        } catch (ExceptionIsEmpty e) {
            System.err.println("Excepción capturada (strings): " + e.getMessage());
        }
    }
}
