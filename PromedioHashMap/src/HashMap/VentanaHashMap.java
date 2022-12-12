package HashMap;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class VentanaHashMap extends JFrame {
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

    double n1,n2,n3;
    int cantGanan=0, cantpierden=0, cantRecupera=0, cantPierden=0 ,cantEstudiantesValidados=0;
    String nombreEstudiante;

    public void imprimirDatos(){
        HashMap<String,Double> notasEstudent = new HashMap<String,Double>();

        nombreEstudiante = textField1.getText();
        n1=Double.parseDouble(nota1Label.getText());
        n2=Double.parseDouble(nota2Label.getText());
        n3=Double.parseDouble(nota3Label.getText());

        double promedio = (n1+n2+n3)/3;
        cantEstudiantesValidados++;


        if (promedio>=3.5) {
            JOptionPane.showMessageDialog(null, "El estudiante " + nombreEstudiante + " ha ganado la materia");
            cantGanan++;
        }else{
            JOptionPane.showMessageDialog(null, "El estudiante "+nombreEstudiante+" reprobo con un promedio de "+promedio);
            cantpierden++;
        }if (promedio > 2.0 && promedio < 3.5) {
            JOptionPane.showMessageDialog(null, "El estudiante " + nombreEstudiante + " puede recuperar");
            cantRecupera++;
        }else if (promedio < 2.0) {
            JOptionPane.showMessageDialog(null, "El estudiante " + nombreEstudiante + " no puede recuperar");
            cantPierden++;
        }


        notasEstudent.put(nombreEstudiante,promedio);
        mosProm.setText(String.valueOf(promedio));
        mosIngre.setText(String.valueOf(cantEstudiantesValidados));
        mosNotas.setText(String.valueOf(cantEstudiantesValidados*3));
        mosApro.setText(String.valueOf(cantGanan));
        mosRepro.setText(String.valueOf(cantpierden));
        mosRecu.setText(String.valueOf(cantRecupera));
        mosPerde.setText(String.valueOf(cantPierden));
    }


    public VentanaHashMap() {
        imprimir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imprimirDatos();
            }
        });
    }
}
