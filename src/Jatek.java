import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Random;
import static javax.imageio.ImageIO.read;

class Jatek extends JPanel implements ActionListener {
    private final Harcos harcos;
    private final Varazslo varazslo;
    private JLabel allapotLabel;
    private final Timer idozito;
    private BufferedImage varazsloImage;
    private StringBuilder jatekmenet;
    private JTextArea jatekmenetTextArea;



    public Jatek(Harcos harcos, Varazslo varazslo) {
        this.harcos = harcos;
        this.varazslo = varazslo;

        setLayout(new BorderLayout());
        JLabel jatekterLabel = new JLabel();
        allapotLabel = new JLabel();
        jatekmenetTextArea = new JTextArea();
        JScrollPane jatekmenetScrollPane = new JScrollPane(jatekmenetTextArea);
        add(jatekterLabel, BorderLayout.CENTER);
        add(allapotLabel, BorderLayout.SOUTH);
        add(jatekmenetScrollPane, BorderLayout.EAST);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;

        jatekterLabel = new JLabel();
        allapotLabel = new JLabel();
        jatekmenetTextArea = new JTextArea();
        jatekmenetTextArea.setEditable(false);

        add(jatekterLabel, gbc);
        gbc.gridy++;
        add(allapotLabel, gbc);
        gbc.gridy++;
        add(jatekmenetTextArea, gbc);


        idozito = new Timer(1000, this);
        idozito.start();

        try {
            read(Objects.requireNonNull(getClass().getResource("/harcos.png")));
            varazsloImage = read(Objects.requireNonNull(getClass().getResource("/varazslo.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        jatekmenet = new StringBuilder();
    }
    public void game() {
        jatekmenet = new StringBuilder();
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
                    jatekmenet.append(jatekter).append(" --> Harc: H:").append(harcos.getEletero()).append(", V:").append(varazslo.getEletero()).append("\n");
                    System.out.println(jatekter + " --> Harc: H:" + harcos.getEletero() + ", V:" + varazslo.getEletero());
                } else {
                    jatekmenet.append(jatekter).append(" --> H:").append(harcos.getEletero()).append(", V:").append(varazslo.getEletero()).append("\n");
                    System.out.println(jatekter + " --> H:" + harcos.getEletero() + ", V:" + varazslo.getEletero());
                }

                if (harcos.getEletero() <= 0 || varazslo.getEletero() <= 0) {
                    break;
                }
            } catch (HarcException e) {
                jatekmenet.append(e.getMessage());
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
        allapotLabel.setVisible(true);
        idozito.stop();

        jatekmenetTextArea.setText(jatekmenet.toString());
        jatekmenetTextArea.setEditable(false);
        jatekmenetTextArea.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        URL harcosImageURL = getClass().getResource("/harcos.png");
        BufferedImage harcosImage;
        try {
            assert harcosImageURL != null;
            harcosImage = read(harcosImageURL);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // A harcos bal oldalra rajzolása
        int harcosX = getWidth() / 4 - 25 - 50;
        int harcosY = (getHeight() - 100) / 2;
        g2d.drawImage(harcosImage, harcosX, harcosY, 150, 200, null);

        URL varazsloImageURL = getClass().getResource("/varazslo.png");
        try {
            assert varazsloImageURL != null;
            varazsloImage = read(varazsloImageURL);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // A varázsló jobb oldalra rajzolása
        int varazsloX = 3 * getWidth() / 4 - 25 + 50;
        int varazsloY = (getHeight() - 100) / 2;
        g2d.drawImage(varazsloImage, varazsloX, varazsloY, 150, 200, null);

        // Játékmenet szövegének elhelyezése középen
        Font font = new Font("Arial", Font.PLAIN, 16);
        g2d.setFont(font);
        FontMetrics fontMetrics = g2d.getFontMetrics(font);
        int textWidth = fontMetrics.stringWidth(jatekmenetTextArea.getText());
        int textHeight = fontMetrics.getHeight();
        int textX = (getWidth() - textWidth) / 2;
        int textY = (getHeight() + harcosImage.getHeight()) / 2 + textHeight;
        g2d.drawString(jatekmenetTextArea.getText(), textX, textY);
    }
}












