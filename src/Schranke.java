
public class Schranke implements SchrankeIF {

	
	enum SchrankenPos{
		OBEN,
		UNTEN
	}
	
	private SchrankenPos position = SchrankenPos.UNTEN;
	
	@Override
	public void geheHoch() throws Exception {
		this.position = SchrankenPos.OBEN;
	}

	@Override
	public void geheRunter() throws Exception {
		this.SchrankenPos = false;

	}

	@Override
	public Ticket gibtTicket() {
		return new Ticket();

	}

//TODO ?????
	public void changePosition() throws Exception {
		if(this.SchrankenPos = true){
			this.geheRunter();
		}
		else{
			this.geheHoch();
		}

	}

	public boolean checkTicketBezahl(Ticket vTicket) {
		return vTicket.getGueltig();
	}

	public void TakeTicket(Ticket vTicket) {
		vTicket.setGueltig(false);
	}

	public Ticket spucktTicketAus(Ticket vTicket) {
		// TODO Auto-generated method stub
		return null;
	}

	public void TakeTicket() {
		// TODO Auto-generated method stub
	}

}
