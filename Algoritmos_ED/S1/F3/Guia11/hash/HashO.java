package hash;
import java.util.LinkedList;

public class HashO {
    private LinkedList<Register>[] table;
    private int size;
    public HashO(int size) {
        this.size = size;
        this.table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % size;
    }

    public void insert(Register reg) {
        int index = hash(reg.getKey());
        for (Register r : table[index]) {
            if (r.getKey() == reg.getKey()) {
                System.out.println("Clave duplicada: no se puede insertar "+reg);
                return;
            }
        }
        table[index].add(reg);
    }

    public Register search(int key) {
        int index = hash(key);
        for (Register r : table[index]) {
            if (r.getKey() == key) {
                System.out.println("Clave "+key+" encontrada en la lista de posicion "+index+": "+r);
                return r;
            }
        }
        System.out.println("Clave "+key+" no encontrada.");
        return null;
    }

    public void delete(int key) {
        int index = hash(key);
        LinkedList<Register> list = table[index];

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getKey() == key) {
                list.remove(i);
                System.out.println("Clave "+key+" eliminada de la lista en posicion "+index);
                return;
            }
        }
        System.out.println("Clave "+key+" no encontrada para eliminar.");
    }


    public void printTable() {
        for (int i = 0; i < size; i++) {
            System.out.print("Posición "+i+": ");
            if (table[i].isEmpty()) {
                System.out.println("Vacío");
            } else {
                for (Register r : table[i]) {
                    System.out.print(r+" ");
                }
                System.out.println();
            }
        }
    }
}

