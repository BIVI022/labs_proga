public class Bicycle extends Transport {

    public int passengers;
    public int passengerCost;

    public Bicycle() {
        super("Bicycle", "");
        this.passengers = 1;
        this.passengerCost = 0;
    }

    public int getTripBill() {
        return 0;
    }

}
