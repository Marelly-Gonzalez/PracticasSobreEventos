package eventos;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
// importar paquetes adicionales
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseMotionListener;

public class C extends JFrame {

    public EventosMouseRueda() {
        // EJECUCION 2
        // agregar etiquetas que muestren las coordenadas del puntero del mouse
        /*
        JLabel lblMovedX = new JLabel("Moved x: ");
        lblMovedX.setBounds(25, 10, 100, 30);
        JLabel lblMovedY = new JLabel("y: ");
        lblMovedY.setBounds(230, 10, 100, 30);
        JLabel lblDraggedX = new JLabel("Dragged x: ");
        lblDraggedX.setBounds(25, 40, 110, 30);
        JLabel lblDraggedY = new JLabel("y: ");
        lblDraggedY.setBounds(230, 40, 100, 30);
        */

        JLabel lblSaludo = new JLabel();
        lblSaludo.setBounds(25, 10, 350, 30);

        JLabel lblInstruccion = new JLabel("Ingresa tu nombre: ");
        lblInstruccion.setBounds(25, 165, 200, 30);

        JTextField campoSaludo = new JTextField(200);
        campoSaludo.setBounds(25, 200, 200, 30);

        JButton boton = new JButton("¡Saludar!");
        boton.setBounds(25, 235, 150, 30);

        // anadir un listener pero de tipo Mouse
        // creamos la clase anonima para implementar a la interfaz MouseListener
        MouseListener listener = new MouseListener() {
            // implementar todos los metodos abstractos de la interfaz MouseListener
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.isAltDown()) {
                    lblSaludo.setText("clic + alt");
                    System.out.println("clic + alt");
                } else if (e.isControlDown()) {
                    lblSaludo.setText("clic + Control");
                    System.out.println("clic + Control");
                } else if (e.isShiftDown()) {
                    lblSaludo.setText("clic + Shift");
                    System.out.println("clic + Shift");
                } else if (e.isMetaDown()) {
                    lblSaludo.setText("clic derecho");
                    System.out.println("clic derecho");
                } else {
                    lblSaludo.setText("clic izquierdo");
                    System.out.println("clic izquierdo");
                }

                // para validar que se dio un doble clic
                if (e.getClickCount() == 2) {
                    lblSaludo.setText("doble clic");
                    System.out.println("doble clic");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };

        // agregar un listener para los eventos de la rueda del mouse
        MouseWheelListener wheel = new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                System.out.println("mouse wheel");
                if (e.getPreciseWheelRotation() == -1) {
                    System.out.println("rueda hacia arriba");
                }
                if (e.getPreciseWheelRotation() == 1) {
                    System.out.println("rueda hacia abajo");
                }
            }
        };

        // agregar un listener para los eventos de movimiento del puntero del mouse
        MouseMotionListener motionListener = new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                System.out.println("dragged");
                // SEGUNDA EJECUCION
                // mostrar la coordenada en x e y del puntero del mouse
                // lblDraggedX.setText("Dragged x: " + e.getX());
                // lblDraggedY.setText("y: " + e.getY());
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                System.out.println("moved");
                // SEGUNDA EJECUCION
                // mostrar la coordenada en x e y del puntero del mouse
                // lblMovedX.setText("Moved x: " + e.getX());
                // lblMovedY.setText("y: " + e.getY());
            }
        };

        // agregar el listener al boton y al campoSaludo, mediante el metodo addMouseListener()
        boton.addMouseListener(listener);
        campoSaludo.addMouseListener(listener);

        // agregar el listener de movimiento de la rueda del mouse al campoSaludo
        campoSaludo.addMouseWheelListener(wheel);

        // agregar el listener de movimiento del puntero del mouse al frame
        this.addMouseMotionListener(motionListener);

        add(lblSaludo);
        add(lblInstruccion);
        add(campoSaludo);
        add(boton);

        // SEGUNDA EJECUCION
        // agregar los componentes graficos al frame
        /*
        add(lblMovedX);
        add(lblMovedY);
        add(lblDraggedX);
        add(lblDraggedY);
        */

        setSize(400, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        EventosMouseRueda objEventoMouse = new EventosMouseRueda();
    }
}
