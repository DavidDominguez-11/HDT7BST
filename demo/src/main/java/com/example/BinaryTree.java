package com.example;

import java.util.function.Consumer;

/**
 * Implementación de un árbol binario.
 * @author David Dominguez
 * @version 1.0
 * @since 2024-03-19
 *
 * @param <E> El tipo de datos que contendrá el árbol binario, debe ser comparable.
 */
class BinaryTree<E extends Comparable<? super E>> {
    /**
     * Clase interna que representa un nodo en el árbol binario.
     *
     * @param <E> El tipo de datos que contendrá el nodo.
     */
    static class Node<E> {
        E data;
        Node<E> left;
        Node<E> right;

        /**
         * Constructor de la clase Node.
         *
         * @param data Los datos almacenados en el nodo.
         */
        public Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    private Node<E> root; // La raíz del árbol binario

    /**
     * Constructor de la clase BinaryTree.
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Inserta un elemento en el árbol binario.
     *
     * @param data El elemento a insertar.
     */
    public void insert(E data) {
        root = insert(root, data);
    }

    /**
     * Método auxiliar para insertar un elemento en el árbol binario.
     *
     * @param node El nodo actual en el que se está considerando insertar el elemento.
     * @param data El elemento a insertar.
     * @return El nodo resultante después de la inserción.
     */
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

    /**
     * Recorre el árbol binario en orden y realiza una acción en cada nodo.
     *
     * @param action La acción a realizar en cada nodo.
     */
    public void InOrder(Consumer<Node<E>> action) {
        InOrder(root, action);
    }

    /**
     * Método auxiliar para recorrer el árbol binario en orden y realizar una acción en cada nodo.
     *
     * @param node   El nodo actual en el recorrido.
     * @param action La acción a realizar en cada nodo.
     */
    private void InOrder(Node<E> node, Consumer<Node<E>> action) {
        if (node != null) {
            InOrder(node.left, action);
            action.accept(node);
            InOrder(node.right, action);
        }
    }

    /**
     * Busca un elemento en el árbol binario.
     *
     * @param data El elemento a buscar.
     * @return true si el elemento está presente en el árbol, false en caso contrario.
     */
    public boolean search(E data) {
        return search(root, data);
    }

    /**
     * Método auxiliar para buscar un elemento en el árbol binario.
     *
     * @param node El nodo actual en la búsqueda.
     * @param data El elemento a buscar.
     * @return true si el elemento está presente en el árbol, false en caso contrario.
     */
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

    /**
     * Traduce una palabra utilizando el árbol binario.
     *
     * @param word La palabra a traducir.
     * @return La traducción de la palabra, o la palabra original entre asteriscos si no se encuentra en el diccionario.
     */
    public String translate(String word) {
        return translate(root, word.toLowerCase());
    }

    /**
     * Método auxiliar para traducir una palabra utilizando el árbol binario.
     *
     * @param node El nodo actual en la búsqueda.
     * @param word La palabra a traducir.
     * @return La traducción de la palabra, o la palabra original entre asteriscos si no se encuentra en el diccionario.
     */
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
