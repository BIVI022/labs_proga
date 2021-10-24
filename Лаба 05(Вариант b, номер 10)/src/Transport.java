public abstract class Transport {

    public String name;
    public String fuel;

    public int weight;
    public int costPerKg;

    public Transport(String name, String fuel) {
        this.fuel = fuel;
        this.name = name;
    }

    public int getTripBill(int minutes) {
        return weight * costPerKg * minutes;
    }

}
