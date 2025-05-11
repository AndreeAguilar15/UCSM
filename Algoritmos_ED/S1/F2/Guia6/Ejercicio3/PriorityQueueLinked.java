package Ejercicio3;
import Actividad3.PriorityQueue;
import Actividad1.ExceptionIsEmpty;
import Actividad2.QueueLink;

public class PrioriryQueueLinked<E> implements PriorityQueue<E, Integer> {
    private QueueLink<E>[] colas;
    private int niveles;

    public PrioriryQueueLinked(int niveles) {
        if (niveles <= 0) {
            throw new IllegalArgumentException("La cantidad de prioridades debe ser mayor que cero.");
        }
        this.niveles = niveles;
        this.colas = new QueueLink[niveles];
        for (int i = 0; i < niveles; i++) {
            colas[i] = new QueueLink<>();
        }
    }

    public void enqueue(E x, Integer prioridad) {
        if (prioridad < 0 || prioridad >= niveles) {
            throw new IllegalArgumentException("Prioridad fuera de rango.");
        }
        colas[prioridad].enqueue(x);
    }

    public E dequeue() throws ExceptionIsEmpty {
        for (int i = 0; i < niveles; i++) {
            if (!colas[i].isEmpty()) {
                return colas[i].dequeue();
            }
        }
        throw new ExceptionIsEmpty();
    }

    public E front() throws ExceptionIsEmpty {
        for (int i = 0; i < niveles; i++) {
            if (!colas[i].isEmpty()) {
                return colas[i].front();
            }
        }
        throw new ExceptionIsEmpty();
    }

    public E back() throws ExceptionIsEmpty {
        for (int i = niveles - 1; i >= 0; i--) {
            if (!colas[i].isEmpty()) {
                return colas[i].back();
            }
        }
        throw new ExceptionIsEmpty();
    }

    public boolean isEmpty() {
        for (QueueLink<E> cola : colas) {
            if (!cola.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (int i = 0; i < niveles; i++) {
            sb.append("Prioridad ").append(i).append(": ").append(colas[i]).append("\n");
        }
        sb.append("]");
        return sb.toString();
    }
}
