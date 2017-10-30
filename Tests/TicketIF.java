import java.security.Timestamp;

public interface TicketIF {
	/*//Wie solle ein Datum mit int gespeichert werden?
	//Ticket kann so direkt bezahlt werden und ist noch nach Stunden gültig.
	public void setGueltig(boolean value);
	public int getDatum();
	*/
	
	public void setAnkunft();
	public void setZahlzeit();
	public boolean getGueltig();
	public void setGueltig(boolean value);
	public int getStunden();
	
}

