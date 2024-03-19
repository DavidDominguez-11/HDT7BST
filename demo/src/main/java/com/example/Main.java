package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Crear un diccionario
        BinaryTree<Association<String, String>> dictionary = new BinaryTree<>();


        // Leer el archivo diccionario.txt y agregar palabras al diccionario
        try (BufferedReader reader = new BufferedReader(new FileReader("demo\\src\\main\\java\\com\\example\\diccionario.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",\\s*");
                if (parts.length == 2) {
                    String englishWord = parts[0].substring(1); // Eliminar el paréntesis izquierdo
                    String spanishWord = parts[1].substring(0, parts[1].length() - 1); // Eliminar el paréntesis derecho
                    dictionary.insert(new Association<>(englishWord, spanishWord));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Imprimir el diccionario en orden
        System.out.println("Diccionario en orden:");
        dictionary.InOrder(node -> {
            Association<String, String> association = node.data;
            System.out.println("(" + association.getKey() + ", " + association.getValue() + ")");
        });

        // Traducir un texto en inglés
        try (BufferedReader reader = new BufferedReader(new FileReader("demo\\src\\main\\java\\com\\example\\texto.txt"))) {
            String line;
            StringBuilder translatedText = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    String translatedWord = dictionary.translate(word);
                    translatedText.append(translatedWord).append(" ");
                }
                translatedText.append("\n");
            }
            System.out.println("\nTexto traducido:");
            System.out.println(translatedText.toString().trim());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
