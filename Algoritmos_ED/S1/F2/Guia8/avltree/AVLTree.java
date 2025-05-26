package avltree;
import Exceptions.*;
import bstreelinklistinterfgeneric.LinkedBST;

public class AVLTree<E extends Comparable<E>> extends LinkedBST<E> {
    protected class NodeAVL extends Node {
        protected int bF;

        public NodeAVL(E data) {
            super(data); 
            this.bF = 0;
        }

        public String toString() {
            return data + " (BF=" + bF + ")";
        }
    }
    private boolean height;

    public AVLTree() {
        super();
        this.height = false;
    }
    public void insert(E x) throws ItemDuplicated {
        this.height = false;
        this.root = insert(x, (NodeAVL)this.root);
    }

    protected Node insert(E x, NodeAVL node) throws ItemDuplicated {
        NodeAVL fat = node;

        if (node == null) {
            this.height = true;
            fat = new NodeAVL(x);
        } else {
            int resC = node.data.compareTo(x);
            if (resC == 0) 
                throw new ItemDuplicated(x + " ya se encuentra en el árbol...");

            if (resC < 0) {
                fat.right = insert(x, (NodeAVL)node.right);
                if (this.height) {
                    switch (fat.bF) {
                        case -1:
                            fat.bF = 0;
                            this.height = false;
                            break;
                        case 0:
                            fat.bF = 1;
                            this.height = true;
                            break;
                        case 1:
                            fat = balanceToLeft(fat);
                            this.height = false;
                            break;
                    }
                }
            } else { //insertar en el subárbol izquierdo
                fat.left = insert(x, (NodeAVL)node.left);
                if (this.height) {
                    switch (fat.bF) {
                        case 1:
                            fat.bF = 0;
                            this.height = false;
                            break;
                        case 0:
                            fat.bF = -1;
                            this.height = true;
                            break;
                        case -1:
                            fat = balanceToRight(fat);
                            this.height = false;
                            break;
                    }
                }
            }
        }
        return fat;
    }
    private NodeAVL balanceToLeft(NodeAVL node) {
        NodeAVL hijo = (NodeAVL) node.right;
        
        switch (hijo.bF) {
            case 1: //Rotacion simple a la izquierda
                node.bF = 0;
                hijo.bF = 0;
                node = rotateSL(node);
                break;
            
            case -1: //Rotacion doble derecha-izquierda
                NodeAVL nieto = (NodeAVL) hijo.left;
                switch (nieto.bF) {
                    case -1:
                        node.bF = 0;
                        hijo.bF = 1;
                        break;
                    case 0:
                        node.bF = 0;
                        hijo.bF = 0;
                        break;
                    case 1:
                        node.bF = 1;
                        hijo.bF = 0;
                        break;
                }
                nieto.bF = 0;
                node.right = rotateSR(hijo);
                node = rotateSL(node);
                break;
        }
        return node;
    }

    private NodeAVL balanceToRight(NodeAVL node) {
        NodeAVL hijo = (NodeAVL) node.left;

        switch (hijo.bF) {
            case -1: //Rotacion simple a la derecha
                node.bF = 0;
                hijo.bF = 0;
                node = rotateSR(node);
                break;

            case 1: //Rotacion doble izquierda-derecha
                NodeAVL nieto = (NodeAVL) hijo.right;
                switch (nieto.bF) {
                    case 1:
                        node.bF = 0;
                        hijo.bF = -1;
                        break;
                    case 0:
                        node.bF = 0;
                        hijo.bF = 0;
                        break;
                    case -1:
                        node.bF = -1;
                        hijo.bF = 0;
                        break;
                }
                nieto.bF = 0;
                node.left = rotateSL(hijo);
                node = rotateSR(node);
                break;
        }
        return node;
    }
    private NodeAVL rotateSL(NodeAVL node){
        NodeAVL p = (NodeAVL)node.right;
        node.right = p.left;
        p.left = node;
        node = p;
        return node;
    }
    private NodeAVL rotateSR(NodeAVL node) {
        NodeAVL p = (NodeAVL) node.left;
        node.left = p.right;
        p.right = node;
        node = p;
        return node;
    }
    public void inOrder() {
        inOrder((NodeAVL) root);
        System.out.println();
    }

    private void inOrder(NodeAVL node) {
        if (node != null) {
            inOrder((NodeAVL) node.left);
            System.out.print(node + " ");
            inOrder((NodeAVL) node.right);
        }
    }


}
