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


    }




