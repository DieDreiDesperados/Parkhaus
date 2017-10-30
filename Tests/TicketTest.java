import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TicketTest {

	Ticket t1;
	Ticket t2;
	Ticket t3;
	
	@Before
	public void setUp(){
		this.t1 = new Ticket();
		this.t2 = new Ticket();
		this.t3 = new Ticket();
	}
	
	@Test
	public void Ticket_Ticket_False(){
		assertEquals(t1.getGueltig(), false);
	}
	
	@Test
	public void Ticket_setAnkunft_False(){
		t1.setAnkunft();
		assertEquals(t1.getGueltig(), false);
	}
	
	@Test
	public void Ticket_SetZahlzeit_TRUE(){
	
		t2.setAnkunft();
		t2.setZahlzeit();
		assertEquals(t2.getGueltig(), true);
		
		t3.setZahlzeit();
		assertEquals(t3.getGueltig(), true);
		
		//TODO : Bezahlt aber nach 15 min noch nicht ausgefahren
	}
	
	@Test
	public void Ticket_getStunden_1(){
		assertEquals(t1.getStunden(), 1);
		
		t1.setZahlzeit(System.currentTimeMillis() / 1000 + 61*60);
		assertEquals(t1.getStunden(), 2);
		
		t1.setZahlzeit(System.currentTimeMillis() / 1000 + 59*60);
		assertEquals(t1.getStunden(), 1);
	}
	

}
