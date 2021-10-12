import java.util.Date;
public class Train {

    private int number;
    private Date startTime;
    private int seats;
    private String finish;

    public Train(int number, Date startTime, int seats, String finish) {
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

    public void getStartTime(Date time) {
        this.startTime = time;
    }

    public void getSeats(int seats) {
        this.seats = seats;
    }

    public int getNumber() {
        return number;
    }

    public Date getStartTime() {
        return startTime;
    }

    public int getSeats() {
        return seats;
    }

    public String getFinish() {
        return finish;
    }

    public void showInfo() {
        System.out.println("Number: " + number);
        System.out.println("Destination: " + finish);
        System.out.println("Start time: " + startTime);
        System.out.println("Seats: " + seats);
    }
}
