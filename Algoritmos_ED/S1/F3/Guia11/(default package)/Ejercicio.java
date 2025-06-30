import hash.*;

public class Ejercicio {
	public static void main(String[] args) {
        HashO hashTable = new HashO(5);
        
        hashTable.insert(new Register(10,"Juan"));
        hashTable.insert(new Register(15,"Ana"));
        hashTable.insert(new Register(20,"Luis"));
        hashTable.insert(new Register(25,"Rosa"));
        
        System.out.println("\n---Tabla Hash Abierta---");
        hashTable.printTable();
        
        Register resultado = hashTable.search(20);
        System.out.println("Resultado busqueda: "+(resultado != null ? resultado :"No encontrado"));
        
        resultado = hashTable.search(30);
        System.out.println("Resultado busqueda: "+(resultado != null ? resultado :"No encontrado"));

	}
}
