import java.util.Random;

class Harcos {
    private int eletero;

    public Harcos() {
        Random random = new Random();
        this.eletero = random.nextInt(6) + 4; // d6+3 életerő
    }

    public int getEletero() {
        return eletero;
    }

    public void setEletero(int eletero) {
        this.eletero = eletero;
    }

    public void tamad(Varazslo varazslo) {
        Random random = new Random();
        int sebzes = random.nextInt(6) + 1; // d6 sebzés
        varazslo.setEletero(varazslo.getEletero() - sebzes);
    }
}