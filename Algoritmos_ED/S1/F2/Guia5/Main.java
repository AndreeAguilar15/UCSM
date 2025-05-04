public class Main {
    public static void main(String[] args) {
        GestorDeTareas<Tarea> gestor = new GestorDeTareas<>();

        gestor.agregar(new Tarea("Hacer la compra", 2));
        gestor.agregar(new Tarea("Estudiar para el examen", 1));
        gestor.agregar(new Tarea("Limpiar la casa", 3));
        gestor.agregar(new Tarea("Hacer ejercicio", 2));

        System.out.println("Tareas:");
        gestor.imprimirTareas();

        gestor.completarTarea(new Tarea("Limpiar la casa", 3));

        System.out.println("\nTareas despues de completar 'Limpiar la casa':");
        gestor.imprimirAmbasListas();
        
        System.out.println("\nTareas despues de eliminar 'Hcer la compra':");
        gestor.eliminarTarea(new Tarea("Hacer la compra", 2));
        gestor.imprimirAmbasListas();
        
        Tarea tareaPrioritaria = gestor.obtenerTareaMasPrioritaria();
        System.out.println("\nTarea mas prioritaria: "+tareaPrioritaria);

        gestor.invertirTareas();
        System.out.println("\nTareas después de invertir:");
        gestor.imprimirTareas();

        System.out.println("\nNúmero total de tareas pendientes: "+gestor.contarTareas());
        System.out.println("\nNúmero total de tareas completadas: "+gestor.contarTareasCompletadas());
    }
}
