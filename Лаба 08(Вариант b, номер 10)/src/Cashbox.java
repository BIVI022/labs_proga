import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Cashbox {

    public Ticket[] availableTickets;
    private ArrayList<Order> orders;

    public Cashbox(Ticket[] tickets) {
        availableTickets = tickets;
        orders = new ArrayList();
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public ArrayList<Ticket> makeRequest(String destination, Date time) {
        ArrayList<Ticket> tickets = new ArrayList();
        for (int i = 0; i < availableTickets.length; i++) {
            if(availableTickets[i].train.getFinish() == destination) {
                if(availableTickets[i].train.getStartTime().equals(time)) {
                    tickets.add(availableTickets[i]);
                }
            }
        }

        return tickets;
    }

    public String toString() {
        String str = "{\n";

        str += "\"tickets\": [\n";
        for (int i = 0; i < availableTickets.length; i++) {
            str += availableTickets[i].toString();
            if(i != availableTickets.length-1) {
                str += ",\n";
            }
        }
        str += "\n]";

        str += "\n}";

        return str;
    }
}
