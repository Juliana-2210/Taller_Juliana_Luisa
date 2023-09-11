package presentacion;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultadoGUI extends JFrame {

    private JLabel apuesta;

    private JLabel gana;

    private JLabel saldo;

    private JButton volver;

    private JButton salir;

    private JButton retirar;

    private JLabel result;
    ResultadoGUI(){
        setTitle("Juego de azar");
        setSize(600, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.decode("#61ACC8"));
        setLayout(new BorderLayout());

        apuesta = new JLabel("APOSTASTE: ");
        Font fuente = new Font("Arial", Font.PLAIN, 15);
        apuesta.setFont(fuente);
        gana = new JLabel("GANASTE: + ...");
        gana.setFont(fuente);
        saldo = new JLabel("SALDO TOTAL: +...");
        saldo.setFont(fuente);
        volver = new JButton("Volver a jugar");
        volver.setBackground(Color.PINK);
        volver.setBorder(new LineBorder(Color.BLACK, 5));
        salir = new JButton("Salir");
        salir.setBackground(Color.PINK);
        salir.setBorder(new LineBorder(Color.BLACK, 5));
        retirar = new JButton("Retirar");
        retirar.setBackground(Color.PINK);
        retirar.setBorder(new LineBorder(Color.BLACK, 5));
        result = new JLabel("TUS RESULTADOS ");
        Font fuente1 = new Font("Arial", Font.BOLD, 30);
        result.setFont(fuente1);

        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cuando se hace clic en el botón, crea una instancia de JuegoGUI y la muestra
                PrincipalGUI prinGUI = new PrincipalGUI();
                prinGUI.setVisible(true);
            }
        });
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        retirar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(ResultadoGUI.this, "¡Retiro Exitoso!");
                    System.exit(0);
            }
        });

        JPanel arribaPanel = new JPanel();
        arribaPanel.setBackground(Color.decode("#61ACC8"));
        arribaPanel.add(result);
        add(arribaPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(3, 1));
        centerPanel.setBackground(Color.decode("#61ACC8"));
        centerPanel.add(apuesta);
        centerPanel.add(gana);
        centerPanel.add(saldo);
        add(centerPanel, BorderLayout.CENTER);

        JPanel abajoPanel = new JPanel(new GridLayout(1,3));
        abajoPanel.setBackground(Color.decode("#61ACC8"));

        abajoPanel.add(volver);
        abajoPanel.add(retirar);
        abajoPanel.add(salir);
        add(abajoPanel, BorderLayout.SOUTH);

    }
}
