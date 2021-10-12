import java.util.Random;
import java.util.Scanner;

public class Main {
        public static int[][] generateRandomArray(int n, int m, int from, int to) {
                Random random = new Random();
                int[][] arr = new int[n][m];

                for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                                arr[i][j] = random.nextInt(to);
                        }
                }

                return arr;
        }

        public static void logArray(int[] arr) {
                for (int item : arr) {
                        System.out.print(item + "\t");
                }
        }

        public static void logArray(int[][] arr) {
                for (int[] item : arr) {
                        logArray(item);
                        System.out.println();
                }
        }

        public static int[][] transparent(int[][] arr) {
                if (arr.length == 0) {
                        return new int[0][0];
                }

                int[][] transparentArray = new int[arr[0].length][arr.length];

                for (int i = 0; i < arr.length; i++) {
                        for (int j = 0; j < arr[i].length; j++) {
                                transparentArray[j][i] = arr[i][j];
                        }
                }

                return transparentArray;
        }

        public static int[][] cloneMatrix(int[][] matrix) {

                int[][] clone = new int[matrix[0].length][matrix.length];

                for (int i = 0; i < matrix.length; i++) {
                        for (int j = 0; j < matrix[i].length; j++) {
                                clone[i][j] = matrix[i][j];
                        }
                }

                return clone;
        }

        public static int getMaxElement(int[] arr) {
                if (arr.length == 0) {
                        return 0;
                }

                int result = arr[0];

                for (int i = 1; i < arr.length; i++) {
                        result = Math.max(result, arr[i]);
                }

                return result;
        }

        public static int getMaxElement(int[][] arr) {
                if (arr.length == 0) {
                        return 0;
                }

                int result = getMaxElement(arr[0]);

                for (int[] rows : arr) {
                        result = Math.max(result, getMaxElement(rows));
                }

                return result;
        }

        public static int[][] removeRow(int index, int[][] arr) {
                int[][] clearedCopy = new int[arr.length-1][arr[0].length];

                for (int i = 0; i < arr.length; i++) {
                        if(index != i) {
                                clearedCopy[i-(i > index ? 1 : 0)] = arr[i];
                        }
                }

                return clearedCopy;
        }

        public static int[][] removeColumn(int index, int[][] arr) {
                return transparent(removeRow(index, transparent(arr)));
        }

        public static ElementPosition getElementPosition(int element, int[][] arr) {
                ElementPosition position = new ElementPosition(element, arr);
                return position;
        }

        public static int[][] removeRowsAndColumns(ElementPosition position, int[][] matrix) {
                int indexOffset = 0;

                int[][] result = cloneMatrix(matrix);

                for (int i = 0; i < position.rowsIndexes.length; i++) {
                        if(position.rowsIndexes[i]) {
                                result = removeRow(i-indexOffset, result);
                                indexOffset++;
                        }
                }

                indexOffset = 0;
                for (int i = 0; i < position.columnsIndexes.length; i++) {
                        if(position.columnsIndexes[i]) {
                                result = removeColumn(i-indexOffset, result);
                                indexOffset++;
                        }
                }

                return result;
        }

        public static int[][] removeElementFromMatrix(int element, int[][] arr) {
                ElementPosition position = getElementPosition(element, arr);
                int[][] processMatrix = removeRowsAndColumns(position, arr);
                return processMatrix;
        }

        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                System.out.print("Please, enter \"n\": ");
                int n = scanner.nextInt();

                int[][] matrix = generateRandomArray(n, n, 0, 100);

                int maxElement = getMaxElement(matrix);

                System.out.println("Original array:");
                logArray(matrix);
                System.out.println("_____________");


                System.out.println("Max element: " + maxElement);
                System.out.println("_____________");
                int[][] processedArray = removeElementFromMatrix(maxElement, matrix);
                System.out.println("Processed matrix:");
                logArray(processedArray);
        }
}
