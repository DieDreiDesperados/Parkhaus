

public class Auto implements AutoIF {

	private boolean istGeparkt = false; //?????
	private Ticket vTicket = null;
	public void fahrtInsParkhaus(Parkhaus vParkhaus) throws Exception {
		this.vTicket = vParkhaus.getSchranke(Parkhaus.WelcheSchranke.EINGANG).gibtTicket();
		vParkhaus.getSchranke(Parkhaus.WelcheSchranke.EINGANG).changePosition();
		vParkhaus.getSchranke(Parkhaus.WelcheSchranke.EINGANG).changePosition();
	}

	@Override
	public void verlasseParkhaus(Parkhaus vParkhaus) throws Exception {
		vParkhaus.getSchranke(Parkhaus.WelcheSchranke.AUSGANG).nehmeTicket();
		if (true == vParkhaus.getSchranke(Parkhaus.WelcheSchranke.AUSGANG).checkTicketBezahl(this.vTicket)){
			vParkhaus.getSchranke(Parkhaus.WelcheSchranke.AUSGANG).changePosition();
			vParkhaus.getSchranke(Parkhaus.WelcheSchranke.AUSGANG).changePosition();
		};
	}

	@Override
	public void bezahleParkhaus() {
		// TODO Auto-generated method stub

	}

}
