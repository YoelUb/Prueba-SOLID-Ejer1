package com.pruebassolid.model;

public class Matriz {

    private final int[][] elementos;

    public Matriz(int[][] elementos) {
        if (elementos == null || elementos.length == 0 || elementos[0].length == 0) {
            throw new IllegalArgumentException("La matriz no puede ser nula ni vacía.");
        }

        this.elementos = copiarMatriz(elementos);
    }


    private int[][] copiarMatriz(int[][] original) {
        int filas = original.length;
        int columnas = original[0].length;
        int[][] copia = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            if (original[i].length != columnas) {
                throw new IllegalArgumentException("Todas las filas deben tener la misma longitud.");
            }
            System.arraycopy(original[i], 0, copia[i], 0, columnas);
        }
        return copia;
    }

   public void imprimirMatriz(){

        for (int i = 0; i < elementos.length; i++) {
            for (int j = 0; j < elementos[i].length; j++) {
                System.out.print(elementos[i][j] + " ");
            }
            System.out.println();
        }

   }

   public Matriz transpuesta(){

        int filas = elementos.length;
        int columnas = elementos[0].length;
        int[][] transpuesta = new int[columnas][filas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                transpuesta[j][i] = elementos[i][j];
            }
        }
        return new Matriz(transpuesta);

   }

    public int[][] getElementos() {
          return copiarMatriz(elementos);
     }

}
