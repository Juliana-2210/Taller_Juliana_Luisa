package presentacion;

import control.ControlJuego;

import javax.swing.*;
import java.lang.constant.Constable;

public class Runner {
        public static void main(String[] args) {
           /* SwingUtilities.invokeLater(new Runnable() {
              @Override
             public void run() {
              JuegoGUI juego = new JuegoGUI();
             juego.setVisible(true);
             }
             });
             */

           PrincipalGUI prin = new PrincipalGUI();
            prin.setVisible(true);
          //  new ControlJuego().mostrarDatosArchivo();

            //GananciasGUI gan = new GananciasGUI();
           // gan.setVisible(true);

           // ResultadoGUI res = new ResultadoGUI();
           // res.setVisible(true);
        }
    }

