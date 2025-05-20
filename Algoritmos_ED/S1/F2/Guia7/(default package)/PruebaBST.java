import Exceptions.*;
import bstreelinklistinterfgeneric.LinkedBST;

public class PruebaBST {
	public static void main(String[] args) {
        LinkedBST<Integer> bst = new LinkedBST<>();

        try {
            bst.insert(400);
            bst.insert(100);
            bst.insert(700);
            bst.insert(50);
            bst.insert(200);
            bst.insert(75);


            System.out.println("Recorrido inOrder: "+bst.toStringinOrder());
            System.out.println("\nRecorrido preOrder: "+bst.toStringpreOrder());
            System.out.println("\nRecorrido postOrder: "+bst.toStringpostOrder());
         
            try {
                System.out.println("\nValor mínimo en el árbol: " + bst.findMin());
                System.out.println("Valor máximo en el árbol: " + bst.findMax());
            } catch (ItemNotFound e) {
                System.out.println("Error: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
