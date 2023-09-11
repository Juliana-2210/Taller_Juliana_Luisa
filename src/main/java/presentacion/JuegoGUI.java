package presentacion;

import persistencia.Archivo;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class JuegoGUI extends JFrame {
    private JLabel[] imagenLabels;
    private JButton iniciarButton;
    private JButton detenerButton;
    private JButton detener1Button;
    private JButton detener2Button;
    private JButton detener3Button;
    private boolean tiempoExcedido = false;
    private Timer[] timers; // Un arreglo de temporizadores, uno para cada imagen
    private int[] currentImageIndices;
    private Timer tiempoLimite;
    private ImageIcon[] imagenes;
    private boolean[] detenidas;// Un arreglo para mantener el estado de detención de cada imagen
    private boolean ganador;

    private boolean estadoBoton = false;


    public JuegoGUI() {
        setTitle("Juego de azar");
        setSize(600, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.decode("#61ACC8"));
        setLayout(new BorderLayout());

        JPanel panelImagenes = new JPanel();
        panelImagenes.setLayout(new GridLayout(1, 3));
        panelImagenes.setBorder(new LineBorder(Color.BLACK, 5));
        panelImagenes.setBackground(Color.decode("#61ACC8"));
        imagenLabels = new JLabel[3];
        for (int i = 0; i < 3; i++) {
            imagenLabels[i] = new JLabel();
            panelImagenes.add(imagenLabels[i]);
        }
        add(panelImagenes, BorderLayout.CENTER);

        JPanel botonesCentro = new JPanel();
        botonesCentro.setLayout(new GridLayout(1, 3));
        botonesCentro.setBackground(Color.decode("#61ACC8"));
        detener1Button = new JButton("Detener 1");
        detener1Button.setBackground(Color.PINK);
        detener1Button.setBorder(new LineBorder(Color.BLACK, 5));
        detener1Button.setBounds(200, 200, 160, 40);
        detener2Button = new JButton("Detener 2");
        detener2Button.setBackground(Color.PINK);
        detener2Button.setBorder(new LineBorder(Color.BLACK, 5));
        detener2Button.setBounds(200, 250, 160, 40);
        detener3Button = new JButton("Detener 3");
        detener3Button.setBackground(Color.PINK);
        detener3Button.setBorder(new LineBorder(Color.BLACK, 5));
        detener3Button.setBounds(350, 250, 160, 40);

        botonesCentro.add(detener1Button);
        botonesCentro.add(detener2Button);
        botonesCentro.add(detener3Button);
        add(botonesCentro, BorderLayout.SOUTH);


        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(Color.decode("#61ACC8"));
        iniciarButton = new JButton("Iniciar");
        iniciarButton.setBackground(Color.PINK);
        iniciarButton.setBorder(new LineBorder(Color.BLACK, 5));
        detenerButton = new JButton("Detener Todo");
        detenerButton.setBackground(Color.PINK);
        detenerButton.setBorder(new LineBorder(Color.BLACK, 5));

        panelBotones.add(iniciarButton);
        panelBotones.add(detenerButton);
        add(panelBotones, BorderLayout.NORTH);


        iniciarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                iniciarCambioImagen();
            }
        });

        detenerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                detenerCambioImagen();
            }
        });

        detener1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                detenerImagen(0);
            }
        });

        detener2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                detenerImagen(1);
            }
        });

        detener3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                detenerImagen(2);
            }
        });

        currentImageIndices = new int[3];
        ganador = false;
        timers = new Timer[3]; // Un temporizador para cada imagen
        detenidas = new boolean[3]; // Un estado de detención para cada imagen
        cargarImagenes();
    }

    private void iniciarCambioImagen() {
        iniciarButton.setEnabled(false);
        detenerButton.setEnabled(true);
        detener1Button.setEnabled(true);
        detener2Button.setEnabled(true);
        detener3Button.setEnabled(true);
        ganador = false;
        tiempoExcedido = false;
        boolean detenerJuego = false;

        tiempoLimite = new Timer(20000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tiempoExcedido = true; // Se ha excedido el límite de tiempo
                detenerCambioImagen();// Detener el cambio de imágenes cuando se excede el tiempo
            }
        });
        tiempoLimite.setRepeats(false); // Evitar que se repita
        tiempoLimite.start();

        for (int i = 0; i < 3; i++) {
            timers[i] = new Timer(100, new ActionListener() { // Cambia cada 100 milisegundos
                private int tiempoTranscurrido = 0;

                @Override
                public void actionPerformed(ActionEvent e) {
                    int index = getIndex(e.getSource());
                    ImageIcon imagen = cargarSiguienteImagen(index);
                    imagenLabels[index].setIcon(imagen);

                    tiempoTranscurrido += 100; // Aumenta el tiempo transcurrido en 100 milisegundos

                    // Ajustar el intervalo del temporizador para ralentizar el cambio de imágenes
                    if (tiempoTranscurrido < 3000) {
                        timers[index].setDelay(100); // Cambio rápido al principio (cada 50 ms)
                    } else if (tiempoTranscurrido < 5000) {
                        timers[index].setDelay(300); // Cambio medio en el medio (cada 100 ms)
                    } else if (tiempoTranscurrido < 7000) {
                        timers[index].setDelay(600);
                    } else if (tiempoTranscurrido < 10000) {
                        timers[index].setDelay(800);
                    } else if (tiempoTranscurrido < 13000) {
                        timers[index].setDelay(1000);
                    } else if (tiempoTranscurrido < 16000) {
                        timers[index].setDelay(1300);
                    } else if (tiempoTranscurrido < 19000) {
                        timers[index].setDelay(1800);
                    } else {
                        timers[index].setDelay(20000); // Cambio lento al final (cada 200 ms)
                    }
                    // Detener el temporizador si se presionó el botón de detener o se alcanzó el límite de tiempo
                    if (detenerJuego || tiempoTranscurrido >= 20000) {
                        detenerCambioImagen();
                    }
                }
            });
            timers[i].start();
        }
    }


    private void detenerCambioImagen() {
        iniciarButton.setEnabled(true);
        detenerButton.setEnabled(false);
        detener1Button.setEnabled(false);
        detener2Button.setEnabled(false);
        detener3Button.setEnabled(false);

        for (int i = 0; i < 3; i++) {
            if (timers[i] != null) {
                timers[i].stop();
                detenidas[i] = true; // Marcar la imagen como detenida
            }
        }

        verificarResultado(); // Verificar el resultado cuando todas las imágenes estén detenidas
    }

    private void detenerImagen(int index) {
        if (timers[index] != null && timers[index].isRunning()) {
            timers[index].stop();
            detenidas[index] = true; // Marcar la imagen como detenida
            verificarResultado(); // Verificar el resultado cuando todas las imágenes estén detenidas
        }
    }

    private int getIndex(Object source) {
        for (int i = 0; i < timers.length; i++) {
            if (source == timers[i]) {
                return i;
            }
        }
        return -1;
    }

    private void verificarResultado() {
        // Verificar si todas las imágenes están detenidas
        boolean todasDetenidas = true;
        for (int i = 0; i < 3; i++) {
            if (!detenidas[i]) {
                todasDetenidas = false;
                break;
            }
        }

        if (todasDetenidas) {
            if (currentImageIndices[0] == currentImageIndices[1] && currentImageIndices[1] == currentImageIndices[2]) {
                JOptionPane.showMessageDialog(this, "¡Ganaste!");
                ganador = true;

                String ruta=  "./src/main/java/ArchivosDatos/DatosApuestasTempo";
                JOptionPane.showMessageDialog(this,new Archivo().ContenidoArchivoString(ruta));

                ResultadoGUI resultadoGUI = new ResultadoGUI();
                resultadoGUI.setVisible(true);
            } else if (currentImageIndices[0] == currentImageIndices[1] || currentImageIndices[1] == currentImageIndices[2] || currentImageIndices[0] == currentImageIndices[2]) {
                JOptionPane.showMessageDialog(this, "¡Ganaste con 2 coincidencias!");
                ganador = true;

                String ruta=  "./src/main/java/ArchivosDatos/DatosApuestasTempo";
                JOptionPane.showMessageDialog(this,new Archivo().ContenidoArchivoString(ruta));


                ResultadoGUI resultadoGUI = new ResultadoGUI();
                resultadoGUI.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(this, "¡Perdiste!");
                ganador = false;
                ResultadoGUI resultadoGUI = new ResultadoGUI();
                resultadoGUI.setVisible(true);
            }
        }else if (tiempoExcedido) {
            JOptionPane.showMessageDialog(this, "¡Se excedió el límite de tiempo! Has perdido.");
            ganador = false;
        }
        }

    private ImageIcon cargarSiguienteImagen(int index) {
        int nextImageIndex;
        do {
            nextImageIndex = new Random().nextInt(imagenes.length);
        } while (nextImageIndex == currentImageIndices[index]);

        currentImageIndices[index] = nextImageIndex;
        return imagenes[nextImageIndex];
    }

    private void cargarImagenes() {
        final String[] imagePaths = {
                "src/main/resources/image1.png",
                "src/main/resources/image2.png",
                "src/main/resources/image3.png"
        };

        imagenes = new ImageIcon[imagePaths.length];
        for (int i = 0; i < imagePaths.length; i++) {
            imagenes[i] = new ImageIcon(imagePaths[i]);
        }
    }
}