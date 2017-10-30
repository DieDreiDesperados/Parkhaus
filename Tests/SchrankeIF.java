public interface SchrankeIF {

    void geheHoch() throws Exception;
    void geheRunter() throws Exception;
    Ticket gibtTicket();
    void changePosition() throws Exception;
    boolean checkTicketBezahl(Ticket value);
    void TakeTicket(Ticket value);
    Ticket spucktTicketAus(Ticket value);
}
