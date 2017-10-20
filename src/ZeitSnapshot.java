/* Klasse ZeitSnapshot speichert eine Zeit in ein Objekt
 * (Für Ticket!!!!!)
 */

import java.time.LocalDateTime;

public class ZeitSnapshot {

    private final int datum[];

    public ZeitSnapshot (){
        LocalDateTime snapshot = LocalDateTime.now();
        datum = new int[5];
        // {Jahr, Monat, Tag, Stunde, Minute}
        datum[0] = snapshot.getYear();
        datum[1] = snapshot.getMonthValue();
        datum[2] = snapshot.getDayOfMonth();
        datum[3] = snapshot.getHour();
        datum[4] = snapshot.getMinute();
    }

    public int[] getDatum () {
        return datum;
    }

    public int[] getDifferenz(ZeitSnapshot other) {

        int differenz[] = new int[5];

        for (int i = 0; i < datum.length; ++i)
            differenz[i] = Math.abs(datum[i]-other.getDatum()[i]);
        return differenz;

    }

    @Override
    public String toString() {
        char trennzeichen = ':';
        String output = "";
        for (int i = 0; i < datum.length; ++i) {
            output += datum[i];
            output += (i < datum.length - 1) ? trennzeichen : "";
        }

        return output;
    }
}
