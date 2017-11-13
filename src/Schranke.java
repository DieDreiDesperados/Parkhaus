
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
		this.position = SchrankenPos.UNTEN;

	}

//TODO ?????
	public void changePosition() throws Exception {
		if(this.position == SchrankenPos.OBEN){
			this.geheRunter();
		}
		else{
			this.geheHoch();
		}

	}

	public boolean checkTicketBezahl(Ticket vTicket) {
		return vTicket.getGueltig();
	}

	public void nehmeTicket(){}
	
	public Ticket gibtTicket(){
		return null;
	}

}
