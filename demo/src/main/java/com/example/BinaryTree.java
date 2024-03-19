package com.example;
/**
 * BinaryTree
 */
class BinaryTree<E extends Comparable<? super E>> {
    private static class Node<E> {
        E data;
        Node<E> left;
        Node<E> right;

        public Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    private Node<E> root;

    public BinaryTree() {
        root = null;
    }

    public void insert(E data) {
        root = insert(root, data);
    }

    private Node<E> insert(Node<E> node, E data) {
        if (node == null) {
            node = new Node<>(data);
        } else if (data.compareTo(node.data) < 0) {
            node.left = insert(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = insert(node.right, data);
        }
        return node;
    }

    public void InOrder() {
        InOrder(root);
    }

    private void InOrder(Node<E> node) {
        if (node != null) {
            InOrder(node.left);
            System.out.print(node.data + " ");
            InOrder(node.right);
        }
    }

    public boolean search(E data) {
        return search(root, data);
    }

    private boolean search(Node<E> node, E data) {
        if (node == null) {
            return false;
        } else if (data.compareTo(node.data) == 0) {
            return true;
        } else if (data.compareTo(node.data) < 0) {
            return search(node.left, data);
        } else {
            return search(node.right, data);
        }
    }

    // Método para traducir una palabra usando el árbol binario
    public String translate(String word) {
        return translate(root, word);
    }

    private String translate(Node<E> node, String word) {
        if (node == null) {
            return "*" + word + "*"; // Si la palabra no está en el diccionario, devuelve la palabra original entre asteriscos
        } else if (word.compareToIgnoreCase((String) node.data) == 0) {
            return (String) node.data; // Si la palabra está en el diccionario, devuelve su traducción
        } else if (word.compareToIgnoreCase((String) node.data) < 0) {
            return translate(node.left, word); // Busca en el subárbol izquierdo
        } else {
            return translate(node.right, word); // Busca en el subárbol derecho
        }
    }
}