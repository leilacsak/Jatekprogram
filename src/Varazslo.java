import java.util.Random;

class Varazslo extends Karakter implements Tamado {
    public Varazslo() {
        super();
    }

    @Override
    public void tamad(Karakter karakter, StringBuilder jatekter, int utkozetPozicio) throws HarcException {
        // Varázsló támadási logika
        Random random = new Random();
        int sebzes = random.nextInt(4) + 1; // d4 sebzés
        karakter.setEletero(karakter.getEletero() - sebzes);

        if (karakter.getEletero() <= 0) {
            if (utkozetPozicio != -1) {
                throw new HarcException(jatekter + " --> Harc: H:" + karakter.getEletero() + ", V:" + getEletero() + " A " + karakter.getClass().getSimpleName() + " meghalt! ");
            } else {
                throw new HarcException(jatekter + " --> H:" + karakter.getEletero() + ", V:" + getEletero() + " A " + karakter.getClass().getSimpleName() + " meghalt! ");
            }
        }
    }
}