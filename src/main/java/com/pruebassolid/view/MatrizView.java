package com.pruebassolid.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MatrizView extends JFrame {
    private JTextArea inputArea = new JTextArea(5, 20);
    private JTextArea outputArea = new JTextArea(5, 20);
    private JButton transponerBtn = new JButton("Transponer");

    public MatrizView() {
        setTitle("Transposición de Matriz");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        outputArea.setEditable(false);
        JPanel panelCentral = new JPanel(new GridLayout(1, 2));
        panelCentral.add(new JScrollPane(inputArea));
        panelCentral.add(new JScrollPane(outputArea));

        add(new JLabel("Ingrese la matriz (números separados por espacios y filas por líneas):"), BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
        add(transponerBtn, BorderLayout.SOUTH);
    }

    public void addTransponerListener(ActionListener listener) {
        transponerBtn.addActionListener(listener);
    }

    public String getInputText() {
        return inputArea.getText();
    }

    public void setOutputText(String texto) {
        outputArea.setText(texto);
    }

    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}
