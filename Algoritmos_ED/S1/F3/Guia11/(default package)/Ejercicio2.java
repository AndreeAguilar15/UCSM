import hash.HashC;
import hash.Registerc;

public class Ejercicio2{
    public static void main(String[] args) {
        HashC hashTable = new HashC(6);

        System.out.println("Insertando 12:");
        hashTable.insert(new Registerc(12));
        hashTable.printTable();
        System.out.println("----------------------");

        System.out.println("Insertando 18:");
        hashTable.insert(new Registerc(18));
        hashTable.printTable();
        System.out.println("----------------------");

        System.out.println("Insertando 24:");
        hashTable.insert(new Registerc(24));
        hashTable.printTable();
        System.out.println("----------------------");

        System.out.println("Insertando 30:");
        hashTable.insert(new Registerc(30));
        hashTable.printTable();


    }
}
