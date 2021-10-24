public class Automobile extends Transport {

    public int passengers;
    public int passengerCost;

    public Automobile() {
        super("Automobile", "petrol 95");

        this.passengers = 4;
        this.passengerCost = 10;
    }

    public int getTripBill(int minutes) {
        return passengers * passengerCost * minutes;
    }

}
