import Actividad1.ExceptionIsEmpty;
import Ejercicio1.StackLink;
import Actividad1.Stack;

public class TestStackLink {
	public static void main(String[] args) {
		Stack<Integer> pilaEnteros = new StackLink<>();
        pilaEnteros.push(10);
        pilaEnteros.push(20);
        pilaEnteros.push(30);
        System.out.println("Pila de enteros: "+pilaEnteros);

        try {
            System.out.println("Tope: "+pilaEnteros.top());
            System.out.println("Elemento eliminado: "+pilaEnteros.pop());
            System.out.println("Pila actualizada: "+pilaEnteros);
        } catch (ExceptionIsEmpty e) {
            System.err.println("Excepcion capturada: "+e.getMessage());
        }

        Stack<String> pilaStrings = new StackLink<>();
        pilaStrings.push("Laptop");
        pilaStrings.push("Mouse");
        pilaStrings.push("Teclado");
        System.out.println("\nPila de strings: " + pilaStrings);

        try {
            System.out.println("Tope: "+pilaStrings.top());
            System.out.println("Elemento eliminado: "+pilaStrings.pop());
            System.out.println("Pila actualizada: "+pilaStrings);
        } catch (ExceptionIsEmpty e) {
            System.err.println("Excepcion capturada: "+e.getMessage());
        }

        // Stack de Doubles
        Stack<Double> pilaDoubles = new StackLink<>();
        pilaDoubles.push(3.14);
        pilaDoubles.push(2.71);
        pilaDoubles.push(1.61);
        System.out.println("\nPila de doubles: " + pilaDoubles);

        try {
            System.out.println("Tope: "+pilaDoubles.top());
            System.out.println("Elemento eliminado: "+pilaDoubles.pop());
            System.out.println("Pila actualizada: "+pilaDoubles);
            while (!pilaDoubles.isEmpty()) {
                System.out.println("Eliminando pila: "+pilaDoubles.pop());
            }
            System.out.println("Intentando acceder al top de una pila vacia");
            System.out.println(pilaDoubles.top());
        } catch (ExceptionIsEmpty e) {
            System.err.println("Excepción capturada: "+e.getMessage());
        }
    }
	
}
