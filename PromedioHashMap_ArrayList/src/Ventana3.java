import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class Ventana3 extends JFrame {
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
    ArrayList<Double> ListaNotasFinales;
    ArrayList<ArrayList<Double>> listaNotas;
    ArrayList<String> listaEstudiantes;
    int cantGanan = 0, cantPierdenSinRecuperar = 0, cantPuedenRecuperar = 0, cantPierden = 0, cantEstudiantesValidados = 0;
    double promedioNotasFinales = 0;

    public Ventana3() {
        imprimir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciar();
            }
        });
    }

    private void iniciar() {
        ingresarDatos();
        validarNota();
        imprimirEstudianteNota();
        imprimirResultados();
    }

    private void ingresarDatos() {
        listaEstudiantes = new ArrayList<String>();
        String nombre = textField1.getText();
        listaEstudiantes.add(nombre);

    }

    public void imprimirEstudianteNota() {

        for (int i = 0; i < listaEstudiantes.size(); i++) {
            System.out.println(listaEstudiantes.get(i) + " : " + ListaNotasFinales.get(i));
        }
    }

    private void imprimirResultados() {
        mosProm.setText(String.valueOf(promedioNotasFinales));
        mosIngre.setText(String.valueOf(cantEstudiantesValidados));
        mosNotas.setText(String.valueOf(cantEstudiantesValidados*3));
        mosApro.setText(String.valueOf(cantGanan));
        mosRepro.setText(String.valueOf(cantPierdenSinRecuperar));
        mosRecu.setText(String.valueOf(cantPuedenRecuperar));
        mosPerde.setText(String.valueOf(cantPierden));

    }



    private void validarNota() {
        double n1 = 0;
        double n2 = 0;
        double n3 = 0;
        ListaNotasFinales = new ArrayList<Double>();

       do {
            n1 = Double.parseDouble(nota1Label.getText());
            if (n1 < 0 || n1 > 5) {
                JOptionPane.showMessageDialog(null, "La nota esta fuera del rango permitido", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } while (n1 < 0 || n1 > 5);

        do {
            n2 = Double.parseDouble(nota2Label.getText());
            if (n2 < 0 || n2 > 5) {
                JOptionPane.showMessageDialog(null, "La nota esta fuera del rango permitido", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }
        } while (n2 < 0 || n2 > 5);

        do {
            n3 = Double.parseDouble(nota3Label.getText());
            if (n3 < 0 || n3 > 5) {
                JOptionPane.showMessageDialog(null, "La nota esta fuera del rango permitido", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }
        } while (n3 < 0 || n3 > 5);


        double promedio = (n1 + n2 + n3) / 3;
        ListaNotasFinales.add(promedio);
        System.out.println(ListaNotasFinales);

        if (promedio >= 3.5) {
            JOptionPane.showMessageDialog(null, "Aprobo con un promedio de  " + promedio);

        } else {
            JOptionPane.showMessageDialog(null, "Reprobo con un promedio de  " + promedio);
            cantPierdenSinRecuperar++;
        }

        for (int i = 0; i < ListaNotasFinales.size(); i++) {
            if (ListaNotasFinales.get(i) >= 3.5) {
                cantGanan++;
            } else {
                cantPierden++;
                if (ListaNotasFinales.get(i) > 2) {
                    cantPuedenRecuperar++;
                } else {
                    cantPierdenSinRecuperar++;
                }
            }
        }

        int suma = 0;
        for (int i = 0; i < ListaNotasFinales.size(); i++) {
            suma += ListaNotasFinales.get(i);
        }
        promedioNotasFinales = suma / ListaNotasFinales.size();
        cantEstudiantesValidados++;

    }


}
