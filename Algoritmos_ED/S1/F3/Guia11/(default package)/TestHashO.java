import hash.*;

public class TestHashO {
    public static void main(String[] args) {
        HashO hashTable = new HashO(11); 

        hashTable.insert(new Register(34, "Ana"));
        hashTable.insert(new Register(3, "Luis"));
        hashTable.insert(new Register(7, "Carlos"));
        hashTable.insert(new Register(30, "Maria"));
        hashTable.insert(new Register(11, "Jose"));
        hashTable.insert(new Register(8, "Lucia"));
        hashTable.insert(new Register(7, "Pedro"));     
        hashTable.insert(new Register(23, "Diana"));
        hashTable.insert(new Register(41, "Julia"));
        hashTable.insert(new Register(16, "Andres"));
        hashTable.insert(new Register(34, "Juan"));     
        System.out.println("\n---Tabla Hash Abierta---");
        hashTable.printTable();

        System.out.println("\nEliminando la clave 30");
        hashTable.delete(30);

        System.out.println("\n---Tabla Hash Abierta---");
        hashTable.printTable();

        System.out.println("\nBuscando la clave 23");
        Register resultado = hashTable.search(23);
        System.out.println("Resultado búsqueda: "+(resultado != null ? resultado :"No encontrado"));
    }
}
