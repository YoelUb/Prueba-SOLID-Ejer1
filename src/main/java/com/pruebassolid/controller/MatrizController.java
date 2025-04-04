package com.pruebassolid.controller;

import com.pruebassolid.model.Matriz;
import com.pruebassolid.view.MatrizView;
public class MatrizController {
    private MatrizView view;

    public MatrizController(MatrizView view) {
        this.view = view;
        this.view.addTransponerListener(e -> transponerMatriz());
    }

    private void transponerMatriz() {
        try {
            String[] filas = view.getInputText().trim().split("\n");
            int[][] datos = new int[filas.length][];
            for (int i = 0; i < filas.length; i++) {
                String[] valores = filas[i].trim().split("\\s+");
                datos[i] = new int[valores.length];
                for (int j = 0; j < valores.length; j++) {
                    datos[i][j] = Integer.parseInt(valores[j]);
                }
            }

            Matriz matriz = new Matriz(datos);
            Matriz transpuesta = matriz.transpuesta();
            view.setOutputText(formatear(transpuesta.getElementos()));

        } catch (Exception ex) {
            view.mostrarError("Error en el formato de la matriz: " + ex.getMessage());
        }
    }

    private String formatear(int[][] elementos) {
        StringBuilder sb = new StringBuilder();
        for (int[] fila : elementos) {
            for (int val : fila) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
