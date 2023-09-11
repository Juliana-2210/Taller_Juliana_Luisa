package presentacion;

import modelo.Juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GananciasGUI extends JFrame {
    private JTextField apuesta;
    private JLabel txt1;
    private JLabel txt2;
    private JLabel txt3;
    private JLabel txt4;

    private JLabel txt5;
    private JButton apostar;

    private JButton atras;
    private String id;
    private double valorApuesta;
    private  double ganancias;

    public GananciasGUI() {
        setTitle("Juego de azar");
        setSize(600, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.decode("#61ACC8"));
        setLayout(new BorderLayout());

        // Crear los componentes
        apuesta = new JTextField();
        apuesta.setBounds(10, 90, 150, 20);

        apostar = new JButton("Apostar");
        atras = new JButton("Atras");
        txt1 = new JLabel("Digite el valor que desea apostar ");
        Font fuente1 = new Font("Arial", Font.ITALIC, 18);
        txt1.setHorizontalAlignment(SwingConstants.CENTER);
        Font fuente = new Font("Arial", Font.PLAIN, 15); // Cambia el tipo de fuente y el tamaño según tus preferencias
        txt5 = new JLabel("CONDICIONES DEL JUEGO");
        txt5.setHorizontalAlignment(SwingConstants.CENTER);
        txt5.setFont(fuente);
        txt1.setFont(fuente1);
        txt2 = new JLabel("Si coinciden las 3 imagenes, gana un 25% sobre el valor apostado");
        txt2.setFont(fuente);
        txt3 = new JLabel("Si coinciden las 2 imagenes, gana un 10% sobre el valor apostado");
        txt3.setFont(fuente);
        txt4 = new JLabel("Si NO coincide ninguna imagenes, pierde todo lo apostado");
        txt4.setFont(fuente);

        apostar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cuando se hace clic en el botón, crea una instancia de JuegoGUI y la muestra
                JuegoGUI juegoGUI = new JuegoGUI();
                juegoGUI.setVisible(true);
            }
        });
        atras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cuando se hace clic en el botón, crea una instancia de JuegoGUI y la muestra
                Object Accion = e.getSource();
                PrincipalGUI principalGUI = new PrincipalGUI();
                principalGUI.setVisible(true);
                Juego j = new Juego();
                apuesta.getText();


                String ruta = "./src/main/java/ArchivosDatos/DatosApuestas";
              //  String RegistrarApuesta = ("Id: "+ j.crearId() +"," + "El Valor Apostado fue: "+ apuesta.getText()+"," +
               //         "Ganancias: "+ganancias+","+" Resultado de la Apuesta: "+78);

            }
        });
        JPanel northPanel = new JPanel(new GridLayout(1, 2));
       // JPanel northPanel = new JPanel();
        northPanel.add(apuesta);

        northPanel.setBackground(Color.decode("#61ACC8"));
        northPanel.add(txt1);

        add(northPanel,BorderLayout.NORTH);
        // Agregar los componentes al panel principal (en el centro y en el sur)
        JPanel centerPanel = new JPanel(new GridLayout(4, 1));
        centerPanel.setBackground(Color.decode("#61ACC8"));
        centerPanel.add(txt5);
        centerPanel.add(txt2);
        centerPanel.add(txt3);
        centerPanel.add(txt4);
        add(centerPanel, BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        southPanel.setBackground(Color.decode("#61ACC8"));
        southPanel.add(apostar);
        southPanel.add(atras);
        add(southPanel, BorderLayout.SOUTH);
    }

}

