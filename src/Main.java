public class Main {
    public static void main(String[] args) {
        Harcos harcos = new Harcos();
        Varazslo varazslo = new Varazslo();

        Jatek jatekPanel = new Jatek(harcos, varazslo);
        jatekPanel.game();
    }
}

