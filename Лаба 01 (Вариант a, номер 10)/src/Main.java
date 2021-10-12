import java.util.Scanner;

public class Main {
    // НОД
    public static int getGCF(int numb1, int numb2) {
        int minN = Math.min(numb1, numb2);

        for (int i = minN; i > 0; i--) {
            if (numb1 % i == 0 && numb2 % i == 0) {
                return i;
            }
        }

        return 1;
    }

    // НОК
    public static int getLCM(int numb1, int numb2) {
        int maxN = Math.max(numb1, numb2);
        int minN = Math.min(numb1, numb2);

        int result = maxN;

        while (result % minN != 0) {
            result += maxN;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please, enter array size: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.print("Pair: " + arr[i] + ", " + arr[j] + "; ");
                System.out.print("GCF: "  + getGCF(arr[i], arr[j]) + "; ");
                System.out.println("LCM: "  + getLCM(arr[i], arr[j]) + "; ");
            }
        }
    }
}
