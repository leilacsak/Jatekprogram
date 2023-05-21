import java.util.Random;

class Harcos extends Karakter implements Tamado {
    public Harcos() {
        super();
    }

    @Override
    public void tamad(Karakter karakter, StringBuilder jatekter, int utkozetPozicio) throws HarcException {
        // Harcos támadási logika
        Random random = new Random();
        int sebzes = random.nextInt(6) + 1; // d6 sebzés
        karakter.setEletero(karakter.getEletero() - sebzes);

        if (karakter.getEletero() <= 0) {
            if (utkozetPozicio != -1) {
                throw new HarcException(jatekter + " --> Harc: H:" + getEletero() + ", V:" + karakter.getEletero() + " A " + karakter.getClass().getSimpleName() + " meghalt! ");
            } else {
                throw new HarcException(jatekter + " --> H:" + getEletero() + ", V:" + karakter.getEletero() + " A " + karakter.getClass().getSimpleName() + " meghalt! ");
            }
        }
    }
}