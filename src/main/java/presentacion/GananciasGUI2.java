package presentacion;

import modelo.Juego;
import persistencia.Archivo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class GananciasGUI2 extends JFrame implements ActionListener {

    public JTextField valorApuesta;
    public JLabel titulo;
    public JButton btnApostar;
     private Scanner sc;

   public GananciasGUI2(){
       valorApuesta=new JTextField();
       titulo=new JLabel();
       btnApostar = new JButton();
       sc = new Scanner(System.in);

       setResizable(false);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setSize(700, 700);
       setTitle("Juego Azar");
       getContentPane().setBackground(Color.decode("#D9A404"));
       setLocationRelativeTo(null);
       add(condicionesJuego());
       setVisible(true);

   }

    public JPanel condicionesJuego() {
       JPanel cJuego = new JPanel();
       cJuego.setBounds(200,0,400,600);
       cJuego.setBackground(Color.decode("#07575B"));
       cJuego.setLayout(null);

       titulo.setText("Cuanto quiere apostar");
       titulo.setFont(new Font("Tahoma",Font.ITALIC,18));
       titulo.setBounds(150, 90, 200, 20);
       titulo.setForeground(new Color(255, 255, 255));
       valorApuesta.setBounds(150,110,150,30);

       btnApostar.setText("Apostar");
       btnApostar.setFont(new Font("Microsoft YaHei UI",Font.ITALIC,14));
       btnApostar.setBounds(220,450,100,20);
       btnApostar.setBackground(Color.WHITE);
       btnApostar.addActionListener(this);

       cJuego.add(titulo);
       cJuego.add(valorApuesta);
       cJuego.add(btnApostar);

       return cJuego;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       Object Accion = e.getSource();
        Juego j = new Juego();
       String ruta = "./src/main/java/ArchivosDatos/DatosApuestas";
     //  String datosApuesta = new StringBuilder().append("Id: ").append(j.crearId()).append(" Valor Apostado: ").append(valorApuesta.getText()).toString();
        String datosA = ("id: "+"389"+","+" Valor Apuesta: "+valorApuesta.getText());
        System.out.println(datosA);
        new Archivo().crearArchivoAgregarTexto(ruta,datosA);

    }
}
