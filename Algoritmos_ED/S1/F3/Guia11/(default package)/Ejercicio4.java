import hash.HashC;
import hash.Registerc;

public class Ejercicio4 {
    public static void main(String[] args) {
        HashC hashTable = new HashC(7);

        hashTable.insert(new Registerc(5));
        hashTable.insert(new Registerc(12));
        hashTable.insert(new Registerc(19));

        System.out.println("Tabla: ");
        hashTable.printTable();
        System.out.println("----------------------------");

        //Eliminar clave 12
        hashTable.delete(12);

        System.out.println("Tabla después de eliminar 12:");
        hashTable.printTable();
        System.out.println("----------------------------");

        hashTable.search(19);
    }
}
