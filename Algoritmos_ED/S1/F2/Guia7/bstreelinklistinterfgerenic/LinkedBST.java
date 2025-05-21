package bstreelinklistinterfgeneric;
import bstreeInterface.BinarySearchTree;
import Exceptions.*;
import actividad1.Stack;

public class LinkedBST<E extends Comparable<E>> implements BinarySearchTree<E> {

    class Node {
        public E data;
        public Node left;
        public Node right;

        public Node(E data) {
            this(data, null, null);
        }

        public Node(E data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;
    public LinkedBST() {
        this.root = null;
    }

    public void insert(E data) throws ItemDuplicated {
        root = insertRec(root, data);
    }

    private Node insertRec(Node node, E data) throws ItemDuplicated {
        if (node == null) {
            return new Node(data);
        }
        int cmp = data.compareTo(node.data);
        if (cmp == 0) {
            throw new ItemDuplicated("Elemento duplicado: "+data);
        } else if (cmp < 0) {
            node.left = insertRec(node.left, data);
        } else {
            node.right = insertRec(node.right, data);
        }
        return node;
    }

    public void delete(E data) throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("El arbol está vacio.");
        }
        root = deleteRec(root, data);
    }

    private Node deleteRec(Node node, E data) {
        if (node == null) {
            return null;
        }

        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            node.left = deleteRec(node.left, data);
        } else if (cmp > 0) {
            node.right = deleteRec(node.right, data);
        } else {
            //sin hijos
            if (node.left == null && node.right == null) return null;
            //un solo hijo
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            //dos hijos
            Node minNode = findMin(node.right);
            node.data = minNode.data;
            node.right = deleteRec(node.right, minNode.data);
        }
        return node;
    }

    private Node findMin(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    public E search(E data) throws ItemNotFound {
        Node found = searchRec(root, data);
        if (found == null) throw new ItemNotFound("Elemento no encontrado: " + data);
        return found.data;
    }

    private Node searchRec(Node node, E data) {
        if (node == null) return null;
        int cmp = data.compareTo(node.data);
        if (cmp == 0) return node;
        else if (cmp < 0) return searchRec(node.left, data);
        else return searchRec(node.right, data);
    }

    public String toStringinOrder() {
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        return sb.toString().trim();
    }
    public String toStringpreOrder() {
        StringBuilder sb = new StringBuilder();
        preOrder(root,sb);
        return sb.toString().trim();
    }
    public String toStringpostOrder() {
        StringBuilder sb = new StringBuilder();
        postOrder(root,sb);
        return sb.toString().trim();
    }
    private void inOrder(Node node, StringBuilder sb) {
        if (node != null) {
            inOrder(node.left, sb);
            sb.append(node.data).append(" ");
            inOrder(node.right, sb);
        }
    }
    
    private void preOrder(Node node, StringBuilder sb) {
        if (node != null) {
            sb.append(node.data).append(" ");
            preOrder(node.left, sb);
            preOrder(node.right, sb);
        }
    }
    
    private void postOrder(Node node, StringBuilder sb) {
        if (node != null) {
            postOrder(node.left, sb);
            postOrder(node.right, sb);
            sb.append(node.data).append(" ");
        }
    }

    private Node findMinNode(Node node) throws ItemNotFound {
        if (node == null) {
            throw new ItemNotFound("Subárbol vacío, no se puede encontrar mínimo.");
        }

        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        search(current.data);

        return current;
    }
    
    private Node findMaxNode(Node node) throws ItemNotFound {
        if (node == null) {
            throw new ItemNotFound("Subárbol vacío, no se puede encontrar máximo.");
        }

        Node current = node;
        while (current.right != null) {
            current = current.right;
        }
        search(current.data);

        return current;
    }
    
    public E findMin() throws ItemNotFound {
        return findMinNode(root).data;
    }

    public E findMax() throws ItemNotFound {
        return findMaxNode(root).data;
    }

    public boolean isEmpty() {
        return root == null;
    }
    
    public void destroyNodes() throws ExceptionIsEmpty {
        if (root == null) {
            throw new ExceptionIsEmpty("El arbol ya está vacio.");
        }
        root = null;
    }
    
    public int countAllNodes() {
        return countInternalNodes(root);
    }

    public int countNodes() {
        return countInternalNodes(root);
    }

    private int countInternalNodes(Node node) {
        if (node == null || (node.left == null && node.right == null)) {
            return 0;
        }
        return 1+countInternalNodes(node.left)+countInternalNodes(node.right);
    }
    
    public void drawBST() {
        if (root == null) {
            System.out.println("arbol vacío");
        } else {
            drawTree(root, "", true);
        }
    }
    private void drawTree(Node node, String prefix, boolean isTail) {
        if (node.right != null) {
            drawTree(node.right, prefix + (isTail ? "│   " : "    "), false);
        }

        System.out.println(prefix + (isTail ? "└── " : "┌── ") + node.data);

        if (node.left != null) {
            drawTree(node.left, prefix + (isTail ? "    " : "│   "), true);
        }
    }
    public void parenthesize() {
        if (root == null) {
            System.out.println("Árbol vacío");
        } else {
            parenthesize(root, 0);
        }
    }
    private void parenthesize(Node<E> node, int indent) {
        printIndent(indent);
        System.out.print(node.data);

        if (node.left != null || node.right != null) {
            System.out.println(" (");
            if (node.left != null) {
                parenthesize(node.left, indent + 2);
            }
            if (node.right != null) {
                parenthesize(node.right, indent + 2);
            }
            printIndent(indent);
            System.out.println(")");
        } else {
            System.out.println();
        }
    }

    private void printIndent(int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print(" ");
        }
    }


}
