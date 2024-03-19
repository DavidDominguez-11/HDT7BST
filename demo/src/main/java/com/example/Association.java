package com.example;

/**
 * Clase que representa una asociación entre una clave y un valor.
 * 
 * @author David Dominguez
 * @version 1.0
 * @since 2024-03-19
 *
 * @param <K> El tipo de la clave.
 * @param <V> El tipo del valor.
 */
public class Association<K extends Comparable<K>, V> implements Comparable<Association<K, V>> {
    private K key;
    private V value;

    /**
     * Constructor de la clase Association.
     *
     * @param key   La clave de la asociación.
     * @param value El valor de la asociación.
     */
    public Association(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Obtiene la clave de la asociación.
     *
     * @return La clave de la asociación.
     */
    public K getKey() {
        return key;
    }

    /**
     * Obtiene el valor de la asociación.
     *
     * @return El valor de la asociación.
     */
    public V getValue() {
        return value;
    }

    /**
     * Compara esta asociación con otra basada en sus claves.
     *
     * @param other La otra asociación con la que se va a comparar.
     * @return Un valor negativo, cero o un valor positivo si esta asociación es menor, igual o mayor que la otra asociación, respectivamente.
     */
    @Override
    public int compareTo(Association<K, V> other) {
        return this.key.compareTo(other.getKey());
    }
}
