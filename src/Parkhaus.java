import java.util.ArrayList;

public class Parkhaus {

    private Kassenautomat automaten[];
    private boolean parkplaetze[];
    private double preisNormal;
    private double preisDauer;
    private Schranke eingang;
    private Schranke ausgang;
    private boolean istVoll;
    private boolean istGeschlossen;
    private ArrayList<double[]> widgetList;
    private final int manID;
    private Zeit oeffnungzeiten[];


    public Parkhaus (int managerID) {
        manID = managerID;
        automaten = new Kassenautomat[5];
        parkplaetze = new boolean[500];
        oeffnungzeiten = new Zeit[2];
    }

    public int getID() { return manID; }
    public double getPreis() { return preisNormal; }
    public double getPreisDauer() { return preisDauer; }
    public boolean getVoll() { return istVoll; }
    public boolean getGeschlossen() { return istGeschlossen; }

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

    public ArrayList<double[]> getWidgetList(int id) {
        if (id != manID)
            return null;
        return widgetList;
    }
}