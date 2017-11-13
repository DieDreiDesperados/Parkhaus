
public class AusgangsSchranke extends Schranke{

	public void nehmeTicket(Ticket vTicket){
		vTicket.setGueltig(false);
	}
}
