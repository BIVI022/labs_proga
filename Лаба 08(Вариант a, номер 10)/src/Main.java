import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String str = "";

        while ( true ) {
            String input = scanner.nextLine();
            if ( input.isEmpty() ) {
                break;
            }
            str += input + "\n";
        }

        String[] strArr = str.split("\n");

        System.out.println("Origin:\n" + str);
        System.out.println("Please, enter line number to replace:");
        int lineNumber = scanner.nextInt();
        System.out.println("Please, enter text:");
        scanner.nextLine();
        String newLine = scanner.nextLine();
        System.out.println(">>>>: " + newLine);

        strArr[lineNumber-1] = newLine;
        System.out.println("___________");
        System.out.println("New:\n");
        System.out.println(String.join("\n", strArr));
    }

}
