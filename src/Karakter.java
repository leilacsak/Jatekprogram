import java.util.Random;

class Karakter {
    protected int eletero;

    public Karakter(){
        Random random = new Random();
        this.eletero = random.nextInt(6) + 4; // d6+3 életerő
    }
    public int getEletero() {
        return eletero;
    }
    public void setEletero(int eletero) {
        if (eletero > 0) {
            this.eletero = eletero;
        } else {
            this.eletero = 0;
        }
    }
    public void tamad(Karakter karakter) throws HarcException {
        Random random = new Random();
        int sebzes = random.nextInt(6) + 1; // d6 sebzés
        karakter.setEletero(karakter.getEletero() - sebzes);

        if (karakter.getEletero() <= 0) {
            throw new HarcException(karakter.getClass().getSimpleName() + " meghalt!");
        }
    }
}

