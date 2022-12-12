import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("VentanaArrayList");
        frame.setContentPane(new VentanaArrayList().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}