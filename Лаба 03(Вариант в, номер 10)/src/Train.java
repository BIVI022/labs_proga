import java.util.Date;

public class Train {

    private int number;
    private int startTime;
    private Seats seats;
    private String finish;

    public Train(int number, int startTime, Seats seats, String finish) {
        this.number = number;
        this.startTime = startTime;
        this.seats = seats;
        this.finish = finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void getStartTime(int time) {
        this.startTime = time;
    }

    public void getSeats(Seats seats) {
        this.seats = seats;
    }

    public int getNumber() {
        return number;
    }

    public int getStartTime() {
        return startTime;
    }

    public Seats getSeats() {
        return seats;
    }

    public String getFinish() {
        return finish;
    }

    public void showInfo() {
        System.out.println("Number: " + number);
        System.out.println("Destination: " + finish);
        System.out.println("Start time: " + startTime);
        System.out.println("Seats: ");
        System.out.println("  -Common: " + seats.common);
        System.out.println("  -Compartment: " + seats.compartment);
        System.out.println("  -Reserved: " + seats.reserved);
        System.out.println("  -Vip: " + seats.vip);
    }
}
