package com.pruebassolid;


import com.pruebassolid.controller.MatrizController;
import com.pruebassolid.view.MatrizView;

public class Main {
    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(() -> {
            MatrizView vista = new MatrizView();
            new MatrizController(vista);
            vista.setVisible(true);
        });
}

}
