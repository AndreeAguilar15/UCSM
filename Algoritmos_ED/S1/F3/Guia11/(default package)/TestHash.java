import hash.*;


public class TestHash {
    public static void main(String[] args) {
        HashC hashTable = new HashC(15);

        hashTable.insert(new Registerc(34));
        hashTable.insert(new Registerc(3));
        hashTable.insert(new Registerc(7));
        hashTable.insert(new Registerc(30));
        hashTable.insert(new Registerc(11));
        hashTable.insert(new Registerc(8));
        hashTable.insert(new Registerc(7));    
        hashTable.insert(new Registerc(23));
        hashTable.insert(new Registerc(41));
        hashTable.insert(new Registerc(16));
        hashTable.insert(new Registerc(34));  

        System.out.println("\n---Tabla Hash---");
        hashTable.printTable();

        System.out.println("\nEliminando la clave 30");
        hashTable.delete(30);

        System.out.println("\n---Tabla Hash---");
        hashTable.printTable();

        System.out.println("\nBuscando la clave 23");
        Registerc resultado = hashTable.search(23);
        System.out.println("Resultado busqueda: "+(resultado != null ? resultado :"No encontrado"));
    }
}
