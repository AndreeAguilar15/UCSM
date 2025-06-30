import hash.HashC;
import hash.Registerc;

public class Ejercicio1 {
    public static void main(String[] args) {
        HashC hashTable = new HashC(7);

        hashTable.insert(new Registerc(3));
        hashTable.insert(new Registerc(10));
        hashTable.insert(new Registerc(17));
        hashTable.insert(new Registerc(24));

        System.out.println("Tabla hash final:");
        hashTable.printTable();
    }
}
