import java.util.ArrayList;
import java.util.Date;

interface OrderControl {
    Cashbox.Order addOrder(Ticket ticket, Customer customer);
}

public class Cashbox {

    public Ticket[] availableTickets;
    private ArrayList<Order> orders;
    private OrderControl orderControl;

    public Cashbox(Ticket[] tickets) {
        availableTickets = tickets;
        orders = new ArrayList();

        orderControl = new OrderControl() {
            public Order addOrder(Ticket ticket, Customer customer) {
                Order order = new Order(ticket, customer);
                orders.add(order);
                return order;
            }
        };
    }

    public Order addOrder(Ticket ticket, Customer customer) {
        return orderControl.addOrder(ticket, customer);
    }

    public ArrayList<Order> getOrders() {
        return orders;
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


    public class Order {

        public Ticket ticket;
        public Customer customer;

        public Order(Ticket ticket, Customer customer) {
            this.ticket = ticket;
            this.customer = customer;
        }

    }

}
