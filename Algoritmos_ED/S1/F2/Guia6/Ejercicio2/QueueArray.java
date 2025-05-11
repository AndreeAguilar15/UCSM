package Ejercicio2;
import Actividad1.ExceptionIsEmpty;
import Actividad2.Queue;

public class QueueArray<E> implements Queue<E> {
    private E[] array;
    private int first;
    private int last;
    private int size;  //cantidad de elementos actuales
    private int capacity; //capacidad maxima

    public QueueArray(int capacity) {
        this.capacity = capacity;
        this.array = (E[]) new Object[capacity];
        this.first = 0;
        this.last = 0;
        this.size = 0;
    }

    public void enqueue(E x) {
        if (size == capacity) {
            throw new RuntimeException("Cola llena");
        }
        array[last] = x;
        last = (last + 1) % capacity;
        size++;
    }

    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty();
        }
        E dato = array[first];
        array[first] = null;
        first = (first + 1) % capacity;
        size--;
        return dato;
    }

    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty();
        }
        return array[first];
    }

    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty();
        }
        int backIndex = (last - 1 + capacity) % capacity;
        return array[backIndex];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            int index = (first + i) % capacity;
            sb.append(array[index]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
