package presentacion;
import control.ControlJuego;
import persistencia.Archivo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Principal;
import javax.swing.border.LineBorder;
public class PrincipalGUI extends JFrame {

    private JButton apuestaButton;
    private JButton exitButton;
    private JLabel imagenLabel;

    private JLabel title;

    private JLabel titleLabel;

    private JTextField texto;
    public PrincipalGUI() {
        setTitle("Juego");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 420);

        JPanel JPprincipal = new JPanel();
        JPprincipal.setBounds(0, 0, 600, 400);
        JPprincipal.setBackground(Color.decode("#61ACC8"));
        JPprincipal.setLayout(null);

        titleLabel = new JLabel("!!Prueba Tu Suerte!!");
        titleLabel.setBounds(90, 8, 400, 60);
        Font fuente = new Font("Arial", Font.BOLD, 24);
        titleLabel.setFont(fuente);
        titleLabel.setForeground(Color.DARK_GRAY);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panelTitle = new JPanel();
        title = new JLabel("BIENVENIDO AL JUEGO DE AZAR");
        panelTitle.setBackground(Color.decode("#61ACC8"));
        Font fuente1 = new Font("Arial", Font.BOLD, 20);
        title.setFont(fuente1);
        title.setForeground(Color.decode("#FF5733"));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(panelTitle, BorderLayout.PAGE_START);
        panelTitle.add(title);


        apuestaButton = new JButton("Iniciar apuesta");
        apuestaButton.setBackground(Color.PINK);
        apuestaButton.setBorder(new LineBorder(Color.BLACK, 5));
        apuestaButton.setBounds(220, 250, 160, 40);

        exitButton = new JButton("Salir");
        exitButton.setBackground(Color.PINK);
        exitButton.setBorder(new LineBorder(Color.BLACK, 5));
       exitButton.setBounds(220, 300, 160, 40);



        ImageIcon imagen = new ImageIcon("src/main/resources/image4.png");
        imagenLabel = new JLabel(imagen);
        imagenLabel.setBounds(200, 55, imagen.getIconWidth(), imagen.getIconHeight());

        texto = new JTextField(); // Crea el JTextField
        texto.setBounds(220, 200, 160, 30);

        apuestaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String montoApostar = JOptionPane.showInputDialog(PrincipalGUI.this, "Digite el monto que desee Apostar:");
                if (montoApostar != null) {


                    ControlJuego c = new ControlJuego();
                    String registrarApuesta= ("Id: 001"+c.crearId()+","+"El valor Apostado: "+montoApostar+","+" Ganancias: --"+","+ "ResultadoApuesta: ---");
                    String ruta =  "./src/main/java/ArchivosDatos/DatosApuestas";
                    String ruta2 = "./src/main/java/ArchivosDatos/DatosApuestasTempo";
                    new Archivo().crearArchivoAgregarTexto(ruta,registrarApuesta);
                    new Archivo().SobreescribirArchivo(ruta2,registrarApuesta);


                    JOptionPane.showMessageDialog(PrincipalGUI.this, "Monto apostado: " + montoApostar);
                    JOptionPane.showMessageDialog(PrincipalGUI.this,"CONDICIONES DEL JUEGO\n\n -Si coinciden las 3 imagenes, gana un 25% sobre el valor apostado\n " +
                            "-Si coinciden las 2 imagenes, gana un 10% sobre el valor apostado\n -" +
                            "Si NO coincide ninguna imagenes, pierde todo lo apostado");
                    JuegoGUI juegoGUI = new JuegoGUI();
                    juegoGUI.setVisible(true);
                }
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPprincipal.add(apuestaButton);
        JPprincipal.add(exitButton);
        JPprincipal.add(imagenLabel);
        JPprincipal.add(titleLabel);
        getContentPane().add(JPprincipal);
    }

}
