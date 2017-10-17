/* Klasse, das ein Zeitintervall beschreibt
 * (Für das Ticket?)
 *
 * Für eine Klasse MasterClock muss noch irgendwie daran rumgeschraubt werden
 */

public class Zeit {
    private int tage;
    private int stunden;
    private int minuten;

    // Konstruktoren
    public Zeit(int tage, int stunden, int minuten) {
        this.tage = tage + (stunden/24);
        this.stunden = stunden + (minuten/60);
        this.minuten = minuten%60;
    }
    public Zeit(int stunden, int minuten) { new Zeit(0,stunden,minuten); }
    public Zeit(int stunden) { new Zeit(stunden,0); }
    public Zeit() { new Zeit(0); }

    // Getter und Setter
    public int getStunden(){ return stunden; }
    public int getMinuten(){ return minuten; }
    public int getTage(){ return tage; }
    public void setStunden(int stunden) { this.stunden = stunden; }
    public void setMinuten(int minutes) { this.minuten = minutes; }
    public void setTage(int days) { this.tage = days; }

    // Additionsfunktion
    void add(Zeit other){
        int newdays = this.getTage() + other.getTage();
        int newminutes = this.getMinuten() + other.getMinuten();
        int newhours = this.getStunden() + other.getStunden();

        // Behandlung Überschlag (z.B: 23 + 2 Stunden = 1 Tag 1 Stunde)
        this.setTage(newdays + ((newhours + newminutes/60)/24));
        this.setStunden(newhours + (newminutes/60));
        this.setMinuten(newminutes%60);

    }

    public boolean equals(Zeit other){
        return (this.getTage() == other.getTage()
                && this.getMinuten() == other.getMinuten()
                && this.getStunden() == other.getStunden());
    }

    @Override
    public String toString(){
        return "" + tage + ":" + stunden + ":" + minuten;
    }



}
