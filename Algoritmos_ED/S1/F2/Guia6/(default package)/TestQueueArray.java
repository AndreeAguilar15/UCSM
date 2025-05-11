import Actividad2.Queue;
import Ejercicio2.QueueArray;
import Actividad1.ExceptionIsEmpty;

public class TestQueueArray {
	  public static void main(String[] args) {
	        //Pruebas con enteros
	        Queue<Integer> colaEnteros = new QueueArray<>(5);
	        System.out.println("Cola de Enteros (Array)");
	        try {
	            colaEnteros.enqueue(10);
	            colaEnteros.enqueue(20);
	            colaEnteros.enqueue(30);

	            System.out.println("Contenido: " + colaEnteros);
	            System.out.println("Frente: " + colaEnteros.front());
	            System.out.println("Final: " + colaEnteros.back());

	            while (!colaEnteros.isEmpty()) {
	                System.out.println("Eliminando: " + colaEnteros.dequeue());
	            }

	            System.out.println("Intentando eliminar de cola vacía...");
	            colaEnteros.dequeue();

	        } catch (ExceptionIsEmpty e) {
	            System.err.println("Excepción capturada: " + e.getMessage());
	        } catch (RuntimeException e) {
	            System.err.println("Excepción de tiempo de ejecución: " + e.getMessage());
	        }

	        System.out.println();

	        //Pruebas con Strings
	        Queue<String> colaTexto = new QueueArray<>(5);
	        System.out.println("Cola de Strings (Array)");
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

	            System.out.println("Intentando ver frente de cola vacía");
	            colaTexto.front();

	        } catch (ExceptionIsEmpty e) {
	            System.err.println("Excepción capturada (strings): " + e.getMessage());
	        } catch (RuntimeException e) {
	            System.err.println("Excepción de tiempo de ejecución: " + e.getMessage());
	        }
	    }
	}
