import java.util.Random;
class Jatek {
    private Harcos harcos;
    private Varazslo varazslo;

    public Jatek(Harcos harcos, Varazslo varazslo) {
        this.harcos = harcos;
        this.varazslo = varazslo;
    }

    public void game() {
        while (harcos.getEletero() > 0 && varazslo.getEletero() > 0) {
            // Háromelemű játéktér véletlenszerű lépéssel
            Random random = new Random();
            StringBuilder jatekter = new StringBuilder("___");
            int harcosPozicio = random.nextInt(3);
            int varazsloPozicio = random.nextInt(3);
            jatekter.setCharAt(harcosPozicio, 'H');
            jatekter.setCharAt(varazsloPozicio, 'V');

            int utkozetPozicio = -1;


            if (harcosPozicio == varazsloPozicio) {
                utkozetPozicio = harcosPozicio;
                harcos.tamad(varazslo);
                varazslo.tamad(harcos);
                System.out.println("Harc: H:" + harcos.getEletero() + ", V:" + varazslo.getEletero());
            }

            if (utkozetPozicio != -1) {
                jatekter.setCharAt(utkozetPozicio, 'X');
            }


            System.out.println(jatekter.toString());

            if (harcos.getEletero() <= 0 || varazslo.getEletero() <= 0) {
                break;
            }

            System.out.println("Következő kör:");

        }

            if (harcos.getEletero() <= 0 && varazslo.getEletero() <= 0) {
                System.out.println("Játék vége: Döntetlen!");
            } else if (harcos.getEletero() > 0) {
                System.out.println("Játék vége: A harcos nyert!");
            } else {
                System.out.println("Játék vége: A varázsló nyert!");
        }
    }
}
