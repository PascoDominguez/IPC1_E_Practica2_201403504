package jvida;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IngresoTablero extends JFrame {

    private JPanel contenent;
    private JLabel lblTamanio;
    private JLabel lblLife;
    private JTextField txtTamanio;
    private JButton btnCancel, btnStart;
    private Icon icoLife;
    public static int numero;

    public IngresoTablero() {
        this.init_component();
        contenent.setBackground(Color.BLACK);
    }

    public void init_component() {
        setSize(320, 500);
        setLocationRelativeTo(null);
        setTitle("JUEGO DE LA VIDA");
        setResizable(false);
        setVisible(true);

        this.contenent = (JPanel) this.getContentPane();
        this.contenent.setLayout(null);
        this.contenent.setSize(320, 500);

        //-------- COMPONENTES -------------- \\
        //imagen
        this.lblLife = new JLabel();
        this.icoLife = new ImageIcon(getClass().getResource("/imagenes/life.jpg"));
//        Icon icoAdministrador;
        this.lblLife.setIcon(icoLife);
        this.lblLife.setSize(320, 300);
        this.lblLife.setLocation(0, 200);
        this.contenent.add(this.lblLife);
        
        this.lblTamanio = new JLabel("TAMAÑO DEL TABLERO");
        this.lblTamanio.setSize(150, 30);
        this.lblTamanio.setLocation(10, 30);
        this.contenent.add(this.lblTamanio);

        this.txtTamanio = new JTextField();
        this.txtTamanio.setSize(100, 30);
        this.txtTamanio.setLocation(165, 30);
        this.contenent.add(this.txtTamanio);

        this.btnCancel = new JButton("cancelar");
        this.btnCancel.setSize(90, 30);
        this.btnCancel.setLocation(70, 100);
        this.btnCancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btnCancel(e);
            }
        });
        this.contenent.add(this.btnCancel);

        this.btnStart = new JButton("Start");
        this.btnStart.setSize(90, 30);
        this.btnStart.setLocation(170, 100);
        this.btnStart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btnStart(e);
            }
        });
        this.contenent.add(this.btnStart);

    }

    public void btnCancel(ActionEvent e) {
        System.exit(0);
    }

    public void btnStart(ActionEvent e) {
        this.usoTry();
        System.out.println(numero);

    }

    public void usoTry() {
        try {
            numero = Integer.parseInt(this.txtTamanio.getText());
            Jugar miJuego = new Jugar();
            miJuego.show();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar solo numeros");
        }
    }
}
