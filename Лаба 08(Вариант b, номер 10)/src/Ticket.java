public class Ticket {

    public int cost;
    public Train train;

    public Ticket(int cost, Train train) {
        this.cost = cost;
        this.train = train;
    }

    public String toString() {
        String str = "{\n";

        str += "\t\"cost\": " + cost + ",\n";
        str += "\t\"train\":" + train.toString() ;
        str += "\n}";

        return str;
    }

}
