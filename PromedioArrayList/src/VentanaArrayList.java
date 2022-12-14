import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaArrayList extends JFrame {
    public JPanel panel;
    private JLabel titulo;
    private String nombre;
    private JTextField nota1Label;
    private JTextField nota2Label;
    private JTextField nota3Label;
    private JTextField textField1;
    private JLabel PromedioLabel;
    private JLabel IngresadosLabel;
    private JLabel notasLabel;
    private JLabel aprobadosLabel;
    private JLabel reprobadosLabel;
    private JLabel RecuperarLabel;
    private JLabel perdedorLabel;
    private JLabel mosProm;
    private JLabel mosIngre;
    private JLabel mosNotas;
    private JLabel mosApro;
    private JLabel mosRepro;
    private JLabel mosRecu;
    private JLabel mosPerde;
    private JButton imprimir;
    private JLabel mosFinal;

    int cantGanan = 0, cantpierden = 0, cantRecupera = 0, cantNoRecupera = 0,cantEstudiantesValidados = 0;
    double n1, n2, n3, promedio;
    String nombreAlumno;
    ArrayList<Double> notaFinal = new ArrayList<Double>();
    ArrayList<String> nombres = new ArrayList<String>();

    public VentanaArrayList() {
        imprimir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procesos();
                imprimirDatos();
            }
        });
    }

    public void procesos() {
        nombres.add(nombreAlumno = textField1.getText());
        n1=Double.parseDouble(nota1Label.getText());
        n2=Double.parseDouble(nota2Label.getText());
        n3=Double.parseDouble(nota3Label.getText());
        n1 = Double.parseDouble(nota1Label.getText());
        if (n1 < 0 || n1 > 5) {
            JOptionPane.showMessageDialog(null, "La nota 1 esta fuera del rango permitido", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        n2 = Double.parseDouble(nota2Label.getText());
        if (n2 < 0 || n2 > 5) {
            JOptionPane.showMessageDialog(null, "La nota 2 esta fuera del rango permitido", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }

        n3 = Double.parseDouble(nota3Label.getText());
        if (n3 < 0 || n3 > 5) {
            JOptionPane.showMessageDialog(null, "La nota 3 esta fuera del rango permitido", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }

        notaFinal.add(promedio = (n1+n2+n3)/3);
        cantEstudiantesValidados++;


        if (promedio>=3.5) {
            cantGanan++;
        }else if (promedio>=3.0 && promedio<3.5) {
           cantpierden++;
        }if (promedio > 2.0 && promedio < 3.5) {
            cantRecupera++;
        }else if (promedio < 2.0) {
            cantNoRecupera++;
        }
    }
    public void imprimirDatos() {
        for (int i = 0; i < nombres.size(); i++) {
            mosProm.setText(String.valueOf(notaFinal.get(i)));
        }
        mosIngre.setText(String.valueOf(cantEstudiantesValidados));
        mosNotas.setText(String.valueOf(cantEstudiantesValidados*3));
        mosApro.setText(String.valueOf(cantGanan));
        mosRepro.setText(String.valueOf(cantpierden));
        mosRecu.setText(String.valueOf(cantRecupera));
        mosPerde.setText(String.valueOf(cantNoRecupera));

        for (int i = 0; i < nombres.size(); i++) {
            mosFinal.setText("Nombre: " + nombres.get(i) + " | notas: " + notaFinal.get(i));
        }


    }
}


