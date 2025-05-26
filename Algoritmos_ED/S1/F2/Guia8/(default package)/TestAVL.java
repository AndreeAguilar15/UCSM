import Exceptions.*;
import avltree.AVLTree;

public class TestAVL {
    public static void main(String[] args) {
        AVLTree<Integer> avl = new AVLTree<>();

        try {
            //Rotacion Simple a la Derecha (RSR)
            System.out.println("Insertando 30, 20, 10 para RSR");
            avl.insert(30);
            avl.insert(20);
            avl.insert(10); //Provoca rotacion simple derecha(RSR)

            //Rotacion Simple a la Izquierda (RSL)
            System.out.println("Insertando 40, 50 para RSL");
            avl.insert(40);
            avl.insert(50); //Provoca rotacion simple izquierda(RSL)

            //Rotacion Doble Izquierda-Derecha(RDL)
            System.out.println("Insertando 5 para RDL");
            avl.insert(5); // Provoca desequilibrio izquierda
            System.out.println("Insertando 7 para RDL");
            avl.insert(7); // RDL: 10, 5, 7 (doble rotación)

            //Rotacion Doble Derecha-Izquierda(RDI)
            System.out.println("Insertando 45 para RDI");
            avl.insert(45);
            System.out.println("Insertando 43 para RDI");
            avl.insert(43); //RDI: 40, 50, 45, 43

        } catch (ItemDuplicated e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nArbol AVL final:");
        avl.inOrder();
    }
}
