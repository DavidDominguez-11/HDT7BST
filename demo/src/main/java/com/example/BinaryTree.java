package com.example;

import java.util.function.Consumer;

/**
 * BinaryTree
 */
class BinaryTree<E extends Comparable<? super E>> {
    static class Node<E> {
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

    public void InOrder(Consumer<Node<E>> action) {
        InOrder(root, action);
    }

    private void InOrder(Node<E> node, Consumer<Node<E>> action) {
        if (node != null) {
            InOrder(node.left, action);
            action.accept(node);
            InOrder(node.right, action);
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
        return translate(root, word.toLowerCase());
    }

    private String translate(Node<E> node, String word) {
        if (node == null) {
            return "*" + word + "*"; // Si la palabra no está en el diccionario, devuelve la palabra original entre asteriscos
        } else if (word.compareToIgnoreCase(((Association<String, String>) node.data).getKey()) == 0) {
            return ((Association<String, String>) node.data).getValue(); // Si la palabra está en el diccionario, devuelve su traducción
        } else if (word.compareToIgnoreCase(((Association<String, String>) node.data).getKey()) < 0) {
            return translate(node.left, word); // Busca en el subárbol izquierdo
        } else {
            return translate(node.right, word); // Busca en el subárbol derecho
        }
    }
}