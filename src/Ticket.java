import java.security.Timestamp;

public class Ticket implements TicketIF {

	private ZeitSnapshot Ankunftszeit;
	private ZeitSnapshot Zahlzeit;
	private boolean Gueltig = false;

	public Ticket(){
		setAnkunft();
	}
	
	//Setz die Ankunftzseit auf die aktuelle Zeit
	public void setAnkunft() {
		this.Ankunftszeit = new ZeitSnapshot();
		this.Zahlzeit = this.Ankunftszeit;
	}

	//Setzt die Zahlzeit auf die aktuelle Zeit
	public void setZahlzeit() {
		//Setzt die Bezahlzeit
		this.Zahlzeit = new ZeitSnapshot();
	}
	
	//Setzt die Variable Ankunft auf eine uebergebene Zeit
	public void setAnkunft(ZeitSnapshot Ankunft){
		this.Ankunftszeit = Ankunft;
	}
	
	//Setzt die Zahlzeit auf eine uebergebene Zeit
	public void setZahlzeit(ZeitSnapshot Zahlzeit){
		this.Zahlzeit = Zahlzeit;
	}
	
	//Ermittelt die aktuelle Zeit
	private long AktuelleZeit(){
		return System.currentTimeMillis() / 1000;
	}

	//überprüft ob Ticket noch in der Ausfahrtszeit ist
	public boolean getGueltig() {
		ZeitSnapshot temp = new ZeitSnapshot();
		if(temp.getDifferenz(this.Zahlzeit)[4] < 15 && this.Gueltig == true){
			return true;
		}
		else{
			return false;
		}
	}
	
	//Gibt die Anzahl der zu bezahlenden Stunden an.
	public int getStunden(){
		if(this.Zahlzeit.getDifferenz(this.Ankunftszeit)[4] > 0  ){
			return this.Zahlzeit.getDifferenz(this.Ankunftszeit)[3]+1;
		}
		else {
			return this.Zahlzeit.getDifferenz(this.Ankunftszeit)[3];
		}
		
	}
	
	//Setzt die Variable ab ob Ticket gueltig ist oder nicht
	public void setGueltig(boolean value){
		this.Gueltig = value;
	}
	
	public String ToString(){
		String str = "Einfahrt: "+this.Ankunftszeit.toString()+" bezahlt: "+this.Zahlzeit.toString()+" gueltig: "+this.Gueltig;
		return str;
	}
}
