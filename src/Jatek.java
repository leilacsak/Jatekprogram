import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class Jatek extends JPanel implements ActionListener {
    private final Harcos harcos;
    private final Varazslo varazslo;
    private final JLabel jatekterLabel;
    private final JLabel allapotLabel;
    private final Timer idozito;

    public Jatek(Harcos harcos, Varazslo varazslo) {
        this.harcos = harcos;
        this.varazslo = varazslo;
        setLayout(new BorderLayout());
        jatekterLabel = new JLabel();
        allapotLabel = new JLabel();
        add(jatekterLabel, BorderLayout.CENTER);
        add(allapotLabel, BorderLayout.SOUTH);

        idozito = new Timer( 1000, this);
        idozito.start();

    }

    public void game() {

        jatekterLabel.setText("Start!");

        int utkozetPozicio;
        while (true) {
            try {
                Random random = new Random();
                StringBuilder jatekter = new StringBuilder("___");
                int harcosPozicio = random.nextInt(3);
                int varazsloPozicio = random.nextInt(3);
                jatekter.setCharAt(harcosPozicio, 'H');
                jatekter.setCharAt(varazsloPozicio, 'V');

                if (harcosPozicio == varazsloPozicio) {
                    utkozetPozicio = harcosPozicio;
                    jatekter.setCharAt(harcosPozicio, 'X');
                    harcos.tamad(varazslo, jatekter, utkozetPozicio);
                    varazslo.tamad(harcos, jatekter, utkozetPozicio);
                    System.out.println(jatekter + " --> Harc: H:" + harcos.getEletero() + ", V:" + varazslo.getEletero());
                } else {
                    System.out.println(jatekter + " --> H:" + harcos.getEletero() + ", V:" + varazslo.getEletero());
                }

                if (harcos.getEletero() <= 0 || varazslo.getEletero() <= 0) {
                    break;
                }
            } catch (HarcException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
        String allapot;
        if (harcos.getEletero() <= 0 && varazslo.getEletero() <= 0) {
            allapot = "Küzdelem vége: Döntetlen!";
        } else {
        allapot = "Game over...";
    }
        allapotLabel.setText(allapot);
        idozito.stop();
}
    @Override
    public void actionPerformed(ActionEvent e) {
    // A harc állapotát frissíti az időzítő esemény.
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // A játékmezőt rajzolja ki
        // Itt meg kell valósítani a grafikus kirajzolást a játékmezőnek.
    }
}


