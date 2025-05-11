package actividad1;

public class ExceptionIsEmpty extends Exception {
    public ExceptionIsEmpty() {
        super("La pila está vacía");
    }

    public ExceptionIsEmpty(String mensaje) {
        super(mensaje);
    }
}
