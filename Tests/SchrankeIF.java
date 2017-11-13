public interface SchrankeIF {

    void geheHoch() throws Exception;
    void geheRunter() throws Exception;
    void changePosition() throws Exception;
    boolean checkTicketBezahl(Ticket value);
}
