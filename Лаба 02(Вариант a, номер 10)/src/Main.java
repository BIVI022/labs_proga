import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please, enter rows amount: ");
        int rowsAmount = scanner.nextInt();

        String[] rowsArray = new String[rowsAmount];
        String[] sortArray = new String[rowsAmount];

        for (int i = 0; i < rowsAmount; i++) {
            rowsArray[i] = scanner.next();
        }

        boolean isSorted = false;
        String tempRow;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < rowsArray.length - 1; i++) {
                if (rowsArray[i].length() > rowsArray[i + 1].length()) {
                    isSorted = false;

                    tempRow = rowsArray[i];
                    rowsArray[i] = rowsArray[i + 1];
                    rowsArray[i + 1] = tempRow;
                }
            }
        }

        for (int i = 0; i < rowsArray.length; i++) {
            System.out.println("Row: " + rowsArray[i] + "; Length: " + rowsArray[i].length());
        }
    }

}
