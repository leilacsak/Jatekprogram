import java.util.Random;
// A harcos karaktere mint az egyik játékos.
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
        if (eletero > 0) {
            this.eletero = eletero;
        } else {
            this.eletero = 0;
        }
    }

    public void tamad(Varazslo varazslo) {
        Random random = new Random();
        int sebzes = random.nextInt(6) + 1; // d6 sebzés
        varazslo.setEletero(varazslo.getEletero() - sebzes);
    }
}