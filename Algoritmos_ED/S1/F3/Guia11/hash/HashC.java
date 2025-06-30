package hash;

public class HashC {
    private static class Element {
        Registerc registerc;
        boolean isAvailable;

        public Element() {
            this.registerc = null;
            this.isAvailable = true;
        }
    }

    private Element[] table;
    private int size;

    public HashC(int size) {
        this.size = size;
        table = new Element[size];
        for (int i = 0; i < size; i++) {
            table[i] = new Element();
        }
    }

    private int hash(int key) {
        return key % size;
    }

    public void insert(Registerc reg) {
        int index = hash(reg.getKey());
        int startIndex = index;
        do {
            if (table[index].registerc == null || table[index].isAvailable) {
                table[index].registerc = reg;
                table[index].isAvailable = false;
                return;
            } else if (table[index].registerc.getKey() == reg.getKey()) {
                System.out.println("Clave duplicada: no se puede insertar "+reg);
                return;
            }
            index = (index + 1) % size;
        } while (index != startIndex);
        System.out.println("Tabla llena: no se pudo insertar "+reg);
    }
    
    public Registerc search(int key) {
        int index = hash(key);
        int startIndex = index;

        do {
            if (table[index].registerc != null && !table[index].isAvailable) {
                if (table[index].registerc.getKey() == key) {
                    System.out.println("Clave "+key+" encontrada en posicion "+index+": "+table[index].registerc);
                    return table[index].registerc;
                }
            } else if (table[index].registerc == null && table[index].isAvailable) {
                break;
            }
            index = (index+1) % size;
        } while (index != startIndex);

        System.out.println("Clave "+key+" no encontrada.");
        return null;
    }

    public void delete(int key) {
        int index = hash(key);
        int startIndex = index;

        do {
            if (table[index].registerc != null && !table[index].isAvailable && table[index].registerc.getKey() == key) {
                table[index].isAvailable = true;
                System.out.println("Registro con clave "+key+" eliminado.");
                return;
            }
            index = (index + 1) % size;
        } while (index != startIndex);

        System.out.println("Registro con clave "+key+" no encontrado.");
    }

    public void printTable() {
        for (int i = 0; i < size; i++) {
            System.out.print("Posicion "+i+": ");
            if (table[i].registerc != null && !table[i].isAvailable) {
                System.out.println(table[i].registerc);
            } else {
                System.out.println("Vacio o eliminado");
            }
        }
    }
}

