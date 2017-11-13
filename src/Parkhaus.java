import java.util.ArrayList;

public class Parkhaus {

    enum WelcheSchranke {EINGANG,AUSGANG}

    private Kassenautomat automaten[];
    private boolean parkplaetze[];
    private int freieParkplaetze;
    private double preisNormal;
    private double preisDauer;
    private EingangsSchranke eingang;
    private AusgangsSchranke ausgang;
    private boolean istVoll;
    private boolean istGeschlossen;
    private ArrayList<Double[]> widgetList;
    private final int manID;
    private UhrZeit oeffnungzeiten[][];


    public Parkhaus (int managerID) {
        freieParkplaetze = 500;
        manID = managerID;
        automaten = new Kassenautomat[5];
        parkplaetze = new boolean[freieParkplaetze];
        oeffnungzeiten = new UhrZeit[7][2];
        this.eingang = new EingangsSchranke();
        this.ausgang = new AusgangsSchranke();
    }

    public int getID() { return manID; }
    public double getPreis() { return preisNormal; }
    public double getPreisDauer() { return preisDauer; }
    public boolean getVoll() { return istVoll; }
    public int getFreieParkplaetze() { return freieParkplaetze; }
    public boolean getIstGeschlossen() { return istGeschlossen; }
    public Schranke getSchranke(WelcheSchranke welche) {
        return (welche == WelcheSchranke.EINGANG) ? eingang : ausgang;
    }

    private boolean checkID(int id) {
        return (id == getID());
    }

    public boolean getPlatzBesetzt(int platznr) {
        try {
            return parkplaetze[platznr];
        } catch (ArrayIndexOutOfBoundsException e) {
            return true;
        }
    }

    public boolean getAutomatFrei(int autonr) {
        try {
            return automaten[autonr].getIstBesetzt();
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    public ArrayList<Double[]> getWidgetList(int id) {
        if (id != manID)
            return null;
        return widgetList;
    }

    public void setPreis(int id, double newPreis) {
        if (!checkID(id))
            return;
        preisNormal = newPreis;
    }

    public void setPreisDauer(int id, double newPreisDauer) {
        if (!checkID(id))
            return;
        preisDauer = newPreisDauer;

    }

    public void setVoll(int id, boolean voll) {
        if (!checkID(id))
            return;
        istVoll = voll;
    }

    public void setGeschlossen(int id, boolean zu) {
        if (!checkID(id))
            return;
        istGeschlossen = zu;
    }

    public void setPlatzBesetzt(int id, int platznr, boolean besetzt) {
        if (!checkID(id))
            return;
        try {
            parkplaetze[platznr] = besetzt;
        } catch (ArrayIndexOutOfBoundsException e) {
            return;
        }
    }

    public void setAutomatFrei(int autonr, boolean besetzt) {
        try {
            automaten[autonr].setIstBesetzt(besetzt);
        } catch (ArrayIndexOutOfBoundsException e) {
        } finally {
            return;
        }
    }

    public double getKassenBestand(int id) {
        if (!checkID(id))
            return 0;

        double bestand = 0.0;
        for (int i = 0; i < automaten.length; ++i)
            bestand += automaten[i].getGeld(id);

        return bestand;

    }

    public double takeKassenbestand (int id) {
        if (!checkID(id))
            return 0;

        double bestand = 0.0;
        for (int i = 0; i < automaten.length; ++i)
            bestand += automaten[i].eraseGeld(id);

        return bestand;
    }


    // Kasse nicht leeren, nur einen bestimmten Betrag von den Automaten abziehen
    public double takeKassenBestand (int id, double betrag) {
        if (!checkID(id))
            return 0;

        double bestand = 0.0;
        int i = 0;

        // Diese Lösung ist scheiße
        while (bestand != betrag)
            bestand += automaten[(i++)%automaten.length].takeAwayGeld(id,0.01);

        return bestand;
    }

    public void setOeffnungzeiten (UhrZeit zeiten[][]) {

        if (zeiten.length != 7 || zeiten[0].length != 2)
            return;

        oeffnungzeiten = zeiten;
    }




}