package Exceptions;
public class ExceptionIsEmpty extends Exception {
    public ExceptionIsEmpty() {
        super("La estructura está vacia");
    }

    public ExceptionIsEmpty(String mensaje) {
        super(mensaje);
    }
}
