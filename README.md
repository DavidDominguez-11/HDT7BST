# Hoja de trabajo No. 7
Algoritmos y Estructura de Datos  David Dominguez 23712    

Implementación de árboles binarios de búsqueda

Este proyecto implementa un traductor de inglés a español utilizando un árbol binario de búsqueda (BST) para almacenar las asociaciones de palabras en el diccionario.

## Clases

### Clase `Main`

Esta clase contiene el método principal del programa. Se encarga de leer el archivo de diccionario, construir el árbol binario de búsqueda con las asociaciones de palabras en inglés y español, imprimir el diccionario en orden y traducir un texto en inglés utilizando el diccionario.

### Clase `Association`

La clase `Association` representa una asociación entre una clave y un valor. En este proyecto, se utiliza para almacenar las asociaciones entre palabras en inglés y español en el diccionario. Esta clase implementa la interfaz `Comparable` para permitir la comparación de asociaciones basadas en la clave.

### Clase `BinaryTree`

La clase `BinaryTree` implementa un árbol binario de búsqueda. Cada nodo del árbol contiene un elemento de tipo genérico `E`, que debe ser comparable. La clase proporciona métodos para insertar elementos en el árbol, recorrer el árbol en orden, buscar elementos en el árbol y traducir palabras utilizando el árbol.

### Clase `BinaryTreeTest`

La clase `BinaryTreeTest` contiene pruebas unitarias para la clase `BinaryTree`. Se incluyen pruebas para verificar el correcto funcionamiento de los métodos `insert` y `search` del árbol binario. Estas pruebas utilizan el framework de pruebas JUnit para realizar las verificaciones necesarias.

## Uso
1. Ejecuta la clase `Main` para iniciar el programa.
Asegúrate de proporcionar los archivos de diccionario (`diccionario.txt`) y el texto a traducir (`texto.txt`) en los directorios correspondientes.  

Tener en cuenta que, por alguna razon, aveces no reconoce el package com.example;
si se da este error, solo borrarlo y volverlo a agregar.


## Pruebas

Se han incluido pruebas unitarias para verificar el funcionamiento de los métodos `insert` y `search` de la clase `BinaryTree`. Estas pruebas se encuentran en la clase `BinaryTreeTest`.

Para ejecutar las pruebas, puedes utilizar un entorno de desarrollo que admita JUnit o ejecutarlas desde la línea de comandos con Maven:


