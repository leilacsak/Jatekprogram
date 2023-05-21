import java.util.Random;

class Jatek {
    private final Harcos harcos;
    private final Varazslo varazslo;

    public Jatek(Harcos harcos, Varazslo varazslo) {
        this.harcos = harcos;
        this.varazslo = varazslo;
    }

    public void game() {

       System.out.println("Start!");

        int utkozetPozicio = -1;
        while (true) {
            try {
                Random random = new Random();
                StringBuilder jatekter = new StringBuilder("___");
                int harcosPozicio = random.nextInt(3);
                int varazsloPozicio = random.nextInt(3);
                jatekter.setCharAt(harcosPozicio, 'H');
                jatekter.setCharAt(varazsloPozicio, 'V');

                if (harcosPozicio == varazsloPozicio) {
                    utkozetPozicio = harcosPozicio;
                    jatekter.setCharAt(harcosPozicio, 'X');
                    harcos.tamad(varazslo, jatekter, utkozetPozicio);
                    varazslo.tamad(harcos, jatekter, utkozetPozicio);
                    System.out.println(jatekter + " --> Harc: H:" + harcos.getEletero() + ", V:" + varazslo.getEletero());
                } else {
                    System.out.println(jatekter + " --> H:" + harcos.getEletero() + ", V:" + varazslo.getEletero());
                }

                if (harcos.getEletero() <= 0 || varazslo.getEletero() <= 0) {
                    break;
                }
            } catch (HarcException e) {
                System.out.println(e.getMessage());
                break;
            }
        }

        if (harcos.getEletero() <= 0 && varazslo.getEletero() <= 0) {
            System.out.println("Küzdelem vége: Döntetlen!");
        }

        System.out.println("Game over...");
    }
}


