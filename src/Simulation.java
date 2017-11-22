// Parkhaussimulation fuer Praesentationszwecke

public class Simulation {

    public static void main() {

        int plaetze = 500;

        Manager manager = new Manager();
        Parkhaus testP = new Parkhaus(manager, plaetze);

        manager.setPreise(1.00, 1.50, 20.00);


        Auto anonymeAutos[] = new Auto[plaetze];

        // Autos parken
        while (true) {
            int randomIndex = 0 + (int)(Math.random() * ((plaetze - 0) + 1));
            Auto temp = anonymeAutos[randomIndex];
            if (!temp.getGeparkt()) {
                temp.fahrtInsParkhaus(testP);
            } else {
                temp.bezahleParkhaus();
                temp.verlasseParkhaus(testP);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }





        }



    }
}
