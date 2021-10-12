import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Train[] trains = {
                new Train(1, 11, new Seats(53, 52, 63, 32), "Brest"),
                new Train(2, 14, new Seats(12, 65, 51, 43), "Minsk"),
                new Train(3, 22, new Seats(43, 12, 63, 22), "Gomel"),
                new Train(4, 10, new Seats(73, 35, 22, 4), "Grodno"),
                new Train(5, 6, new Seats(24, 17, 10, 34), "Vitebsk"),
        };

        System.out.println("Enter train destination:");
        String finish = scanner.next().toLowerCase();
        System.out.println("Enter train start time:");
        int startTime = scanner.nextInt();
        for (int i = 0; i < trains.length; i++) {
            if(finish.equals(trains[i].getFinish().toLowerCase())) {
                System.out.println("Train:");
                trains[i].showInfo();
            }
        }
        System.out.println("_____________________________");
        for (int i = 0; i < trains.length; i++) {
            if(finish.equals(trains[i].getFinish().toLowerCase()) && trains[i].getStartTime() > startTime) {
                System.out.println("Train" );
                trains[i].showInfo();
            }
        }
        System.out.println("_____________________________");
        for (int i = 0; i < trains.length; i++) {
            if(finish.equals(trains[i].getFinish().toLowerCase()) && trains[i].getSeats().common > 0) {
                System.out.println("Train" );
                trains[i].showInfo();
            }
        }

    }

}
