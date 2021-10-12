import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Cashbox cashbox = new Cashbox(new Ticket[]{
                new Ticket(
                    100,
                    new Train(1, new Date(2021, 9, 14, 6, 22), 50, "Minsk")
                ),
                new Ticket(
                    110,
                    new Train(2, new Date(2021, 9, 14, 15, 00), 34, "Minsk")
                ),
                new Ticket(
                    90,
                    new Train(3, new Date(2021, 9, 14, 6, 22), 125, "Minsk")
                ),
        });

        Customer ivan = new Customer("Ivan", 25);
        ArrayList<Ticket> tickets = cashbox.makeRequest("Minsk", new Date(2021, 9, 14, 6, 22));
        System.out.println("Available trains:");
        for(Ticket ticket : tickets){
             ticket.train.showInfo();
            System.out.println("________________");
        }
        System.out.println("Enter train number:");
        int trainNumber = scanner.nextInt();

        for(Ticket ticket : tickets){
            if(ticket.train.getNumber() == trainNumber) {
                Order order = new Order(ticket, ivan);
                cashbox.addOrder(order);
                System.out.println("Bill: ");
                System.out.println("<--------->");
                System.out.println("Customer: " + order.customer.name);
                System.out.println("Cost: " + order.ticket.cost + "$");
                System.out.println("<--------->");
            }
        }
    }

}
