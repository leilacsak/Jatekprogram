import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Harcos harcos = new Harcos();
            Varazslo varazslo = new Varazslo();

            JFrame frame = new JFrame("Jatekprogram GUI");
            Jatek jatekPanel = new Jatek(harcos, varazslo);
            frame.add(jatekPanel);

            JButton startButton = new JButton("Start!");
            startButton.addActionListener(e -> jatekPanel.game());
            frame.add(startButton, BorderLayout.SOUTH);

            frame.setVisible(true);
        });



    }
}

