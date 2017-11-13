
public class EingangsSchranke extends Schranke {
	
	public Ticket gibtTicket() {
		Ticket t = new Ticket();
		t.setGueltig(true);
		return t;
	}
}
