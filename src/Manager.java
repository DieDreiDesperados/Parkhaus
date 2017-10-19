/*
   Manager Klasse
 */

public class Manager{

    private final int manID;
    private Parkhaus manParkhaus;
    private double eigeneKasse;

    public Manager(){
        double zufallsZahl = Math.random();
        double zufallsZahl2 = Math.random();
        int ID = zufallsZahl*1333 + zufallsZahl2*133;
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
             manParkhaus.setGeschlossen(manID);
         }
         if((statusAendern == false) && manParkhaus.getIstGeschlossen() == true){
             man.Parkhaus.setGeoeffnet(manID);
         }
    }

    void setOeffnungszeiten(double[7][2] zeiten){
        manParkhaus.setOeffnungszeiten(zeiten, manID);
    }

    double getKassenBestand(){
        return manParkhaus.getKassenBestand(manID);
    }
    double takeKassenBestand(int money){
        double geld = manParkhaus.takeKassenBestand(money, manID);
        eigeneKasse += geld;
        return geld;
    }

    void makeDiagramm(String laenge){
        arrayList<double[]> liste = manParkhaus.getWidgetList(manID);
        Widget.makeListe(liste, laenge);
    }
    void erstelleGraph(){
        gibAnWidget(manParkhaus.getWidgetList(manID));
    }
    private void gibAnWidget(ArrayList<Double[]> arrayList){
        NormalDistributionDemo chart = new NormalDistributionDemo("Einnahmen/Zeit",
                "Verteilung der Einnahmen", arrayList);
        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );
    }


}