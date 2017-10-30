import java.security.Timestamp;

public class Ticket implements TicketIF {

	private long Ankunftszeit = 0;
	private long Zahlzeit = 0;
	private boolean Gueltig = false;

	public Ticket(){
		setAnkunft();
	}
	
	//Setz die Ankunftzseit auf die aktuelle Zeit
	public void setAnkunft() {
		this.Ankunftszeit = AktuelleZeit();
		this.Zahlzeit = this.Ankunftszeit;
	}

	//Setzt die Zahlzeit auf die aktuelle Zeit
	public void setZahlzeit() {
		//Setzt die Bezahlzeit
		this.Zahlzeit = AktuelleZeit();
	}
	
	//Setzt die Variable Ankunft auf eine uebergebene Zeit
	public void setAnkunft(long Ankunft){
		this.Ankunftszeit = Ankunft;
	}
	
	//Setzt die Zahlzeit auf eine uebergebene Zeit
	public void setZahlzeit(long Zahlzeit){
		this.Zahlzeit = Zahlzeit;
	}
	
	//Ermittelt die aktuelle Zeit
	private long AktuelleZeit(){
		return System.currentTimeMillis() / 1000;
	}

	//überprüft ob Ticket noch in der Ausfahrtszeit ist
	public boolean getGueltig() {
		if(AktuelleZeit() <= (Zahlzeit+54000) && this.Gueltig == true){
			return true;
		}
		else{
			return false;
		}
	}
	
	//Gibt die Anzahl der zu bezahlenden Stunden an.
	public int getStunden(){
		float f =(float) (((this.Zahlzeit - this.Ankunftszeit) / 60 / 60)+ 0.5);
		return Math.round(f);
		
	}
	
	//Setzt die Variable ab ob Ticket gueltig ist oder nicht
	public void setGueltig(boolean value){
		this.Gueltig = value;
	}
}
