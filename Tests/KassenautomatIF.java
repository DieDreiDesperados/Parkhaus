public interface KassenautomatIF {
	public double berechnePreis();
	public Ticket checkTicket();
	public double getGeld();
	public double eraseGeld(int value);
	public boolean getIsBesetzt();
}
