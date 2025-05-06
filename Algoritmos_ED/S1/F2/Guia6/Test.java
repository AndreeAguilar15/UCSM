package actividad1;

public class Test {
    public static void main(String[] args) {
        Stack<Integer> pilaEnteros = new StackArray<>(5);
        try {
            System.out.println("=== Pila de Enteros ===");
            pilaEnteros.push(10);
            pilaEnteros.push(20);
            pilaEnteros.push(30);

            System.out.println("Contenido de la pila: "+pilaEnteros);
            System.out.println("Elemento en el tope: "+pilaEnteros.top());

            System.out.println("Elemento extraído con pop: "+pilaEnteros.pop());
            System.out.println("Contenido tras pop: "+pilaEnteros);

            while (!pilaEnteros.isEmpty()) {
                System.out.println("Eliminando: "+pilaEnteros.pop());
            }
            // Esto debe lanzar ExceptionIsEmpty
            System.out.println("Intentando acceder al tope de una pila vacia");
            System.out.println(pilaEnteros.top());
        } catch (ExceptionIsEmpty e) {
            System.err.println("Excepción capturada: "+e.getMessage());
        }

        // Pila de strings
        Stack<String> pilaStrings = new StackArray<>(3);
        try {
            System.out.println("\n=== Pila de Strings ===");
            pilaStrings.push("Hola");
            pilaStrings.push("Mundo");

            System.out.println("Contenido de la pila: " + pilaStrings);
            System.out.println("Top: " + pilaStrings.top());

            pilaStrings.push("ChatGPT");
            System.out.println("Contenido final: " + pilaStrings);

            //Esto excede la capacidad
            pilaStrings.push("Extra");  //Lanza RuntimeException

        } catch (ExceptionIsEmpty e) {
            System.err.println("Excepción capturada: "+e.getMessage());
        } catch (RuntimeException e) {
            System.err.println("Excepción en tiempo de ejecución: "+e.getMessage());
        }
    }
}
