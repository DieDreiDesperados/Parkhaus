/* Klasse, das eine Uhrzeit beschreibt
 * (Für Öffnungszeiten)
 *
 */

public class UhrZeit {
    private int stunden;
    private int minuten;

    // Konstruktoren (Überschlag muss behandelt werden)
    public UhrZeit (int stunden, int minuten) {
        this.minuten = minuten%60;
        this.stunden = (stunden + (minuten/60))%24;
    }
    public UhrZeit (int minuten) { new UhrZeit(0,minuten); }
    public UhrZeit() { new UhrZeit(0); }

    // Getter und Setter
    public int getStunden(){ return stunden; }
    public int getMinuten(){ return minuten; }
    public void setStunden(int stunden) { this.stunden = (stunden%24); }
    public void setMinuten(int minutes) { this.minuten = (minutes%60); }

    // Additionsfunktion
    void add(UhrZeit other){
        int newminutes = this.getMinuten() + other.getMinuten();
        int newhours = this.getStunden() + other.getStunden();

        // Behandlung Überschlag (z.B: 23 + 2 Stunden = 1 Tag 1 Stunde)
        this.setStunden((newhours + (newminutes/60))%24);
        this.setMinuten(newminutes%60);

    }

    public boolean equals(UhrZeit other){
        return (this.getMinuten() == other.getMinuten()
                && this.getStunden() == other.getStunden());
    }

    @Override
    public String toString(){
        return "" + stunden + ":" + minuten;
    }



}
