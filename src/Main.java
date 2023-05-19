public class Main {
    public static void main(String[] args) {
        Harcos harcos = new Harcos();
        Varazslo varazslo = new Varazslo();

        Jatek jatek = new Jatek(harcos, varazslo);
        jatek.game();
    }
}
