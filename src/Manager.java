/*
   Manager Klasse
 */

import org.jfree.ui.RefineryUtilities;

import java.util.ArrayList;

public class Manager{

    private final int manID;
    private Parkhaus manParkhaus;
    private double eigeneKasse;

    public Manager(){
        double zufallsZahl = Math.random();
        double zufallsZahl2 = Math.random();
        int ID = (int)(zufallsZahl*1333 + zufallsZahl2*133);
        this.manID = ID;
        manParkhaus = new Parkhaus(manID);
    }

    void setPreise(double preiseNorm, double preiseNacht, double preiseGanzTag){
         double[] preise = new double[3];
         preise[0] = preiseNorm;
         preise[1] = preiseNacht;
         preise[2] = preiseGanzTag;
         manParkhaus.setPreis(preise, manID);
    }

    void setGeschlossen(boolean statusAendern){
         if((statusAendern == true) && manParkhaus.getIstGeschlossen() == false){
             manParkhaus.setGeschlossen(manID, statusAendern);
         }
         if((statusAendern == false) && manParkhaus.getIstGeschlossen() == true){
             manParkhaus.setGeschlossen(manID, statusAendern);
         }
    }

    void setOeffnungszeiten(double[][] zeiten){
        manParkhaus.setOeffnungszeiten(zeiten, manID);
    }

    double getKassenBestand(){
        return manParkhaus.takeKassenbestand(manID);
    }
    double takeKassenBestand(double money){
        double geld = manParkhaus.takeKassenbestand(manID, money);
        eigeneKasse += geld;
        return geld;
    }

    //wird noch überdacht
    void makeDiagramm(String laenge){
        ArrayList<Double[]> liste = manParkhaus.getWidgetList(manID);
       // Widget.makeListe(liste, laenge);
    }
    void erstelleGraph(){
        gibAnWidget(manParkhaus.getWidgetList(manID));
    }
    private void gibAnWidget(ArrayList<Double[]> arrayList){
        Widget chart = new Widget("Einnahmen/Zeit",
                "Verteilung der Einnahmen", arrayList);
        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );
    }


}