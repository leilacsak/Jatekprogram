import java.util.Random;

class Karakter {
    protected int eletero;
    private int pozicio;

    public Karakter() {
        Random random = new Random();
        this.eletero = random.nextInt(6) + 4; // d6+3 életerő
    }

    public int getEletero() {
        return eletero;
    }

    public void setEletero(int eletero) {
        this.eletero = Math.max(eletero, 0);
    }

    public void tamad(Karakter karakter, StringBuilder jatekter, int ignoredUtkozetPozicio) throws HarcException {
        Random random = new Random();
        int sebzes = random.nextInt(6) + 1; // d6 sebzés
        karakter.setEletero(karakter.getEletero() - sebzes);

        if (karakter.getEletero() <= 0) {

            if (karakter.getEletero() <= 0) {
                if (jatekter.charAt(pozicio) != 'X') {
                    throw new HarcException(jatekter.toString() + " --> H:" + getEletero() + ", V:" + karakter.getEletero() + " A " + karakter.getClass().getSimpleName() + " meghalt! ");
                } else {
                    throw new HarcException(jatekter.toString() + " --> Harc: H:" + getEletero() + ", V:" + karakter.getEletero() + " A " + karakter.getClass().getSimpleName() + " meghalt! ");
                }

            }
        }
    }
}

