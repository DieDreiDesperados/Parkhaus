/* Klasse, das einen Kassenautomaten beschreibt
 */

public class Kassenautomat {

    private boolean istBesetzt;
    private double geldBestand;
    private Parkhaus meinParkhaus;

    public Kassenautomat(Parkhaus hierBinIch) {
        istBesetzt = false;
        geldBestand = 0;
        meinParkhaus = hierBinIch;
    }

    // ID-Check: Fragt auch der Manager die Methoden ab?
    private boolean checkID(int id) {
        return (id == meinParkhaus.getID())
    }

    // Ist der Automat besetzt?
    public boolean getIstBesetzt() {
        return istBesetzt;
    }

    // Besetzung umstellen
    public void setIstBesetzt(boolean besetzt) {
        istBesetzt = besetzt;
    }

    // Kleingeldstand ablesen
    public double getGeld (int id) {
        if (!checkID(id))
            return -1 // Vielleicht lieber eine Exception werfen?

        return geldBestand;
    }

    // Einen bestimmten Betrag vom Automaten abziehen
    public double takeAwayGeld (int id, double wert) {
        if (!checkID(id) || wert < 0 || wert > getGeld(id))
            return 0;

        geldBestand -= wert;
        return wert;
    }

    // Einen bestimmten Betrag zum Geldbestand hinzufügen
    private void addGeld(double wert) {
        geldBestand += wert;
    }

    // Kasse leeren
    public double eraseGeld (int id) {
        double kaChing = getGeld(id);
        takeAwayGeld(id,kaChing);
        return kaChing;
    }

    // Nehme ein Ticket an und prüfe es, ziehe Betrag ein usw.
    public void checkTicket (Ticket t) {
        setIstBesetzt(true);
        if (!t.getGueltig() || t.getBezahlt()) {
            setIstBesetzt(false);
            return;
        }

        addGeld(berechnePreis(t));
        t.setBezahlt(true);
        setIstBesetzt(false);
        return;

    }

    // Berechne Preis anhand Parkdauer
    private double berechnePreis (Ticket t) {
        return meinParkhaus.getPreis() * t.getStunden(); // Stunde vielleicht auch mit direktem Zugriff?
    }


}