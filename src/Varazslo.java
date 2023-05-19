import java.util.Random;
class Varazslo {
    private int eletero;

    public Varazslo() {
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

    public void tamad(Harcos harcos) {
        Random random = new Random();
        int sebzes = random.nextInt(6) + 1; // d6 sebzés
        harcos.setEletero(harcos.getEletero() - sebzes);
    }
}