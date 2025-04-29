public class Main {
    public static void main(String[] args) {
        GestorDeTareas<Tarea> gestor = new GestorDeTareas<>();

        gestor.agregar(new Tarea("Hacer la compra", 2));
        gestor.agregar(new Tarea("Estudiar para el examen", 1));
        gestor.agregar(new Tarea("Limpiar la casa", 3));
        gestor.agregar(new Tarea("Hacer ejercicio", 2));

        System.out.println("Tareas:");
        gestor.imprimirTareas();

        gestor.eliminarTarea(new Tarea("Limpiar la casa", 3));

        System.out.println("\nTareas despues de eliminar 'Limpiar la casa':");
        gestor.imprimirTareas();

        Tarea tareaPrioritaria = gestor.obtenerTareaMasPrioritaria();
        System.out.println("\nTarea mas prioritaria: "+tareaPrioritaria);

        gestor.invertirTareas();
        System.out.println("\nTareas después de invertir:");
        gestor.imprimirTareas();

        System.out.println("\nNúmero total de tareas: "+gestor.contarTareas());
    }
}
