import java.util.Random;

public class BoolMatrix {

    public int rows;
    public int columns;

    public int[][] matrix;

    public BoolMatrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        randomFill();

    }

    public BoolMatrix() {
        Random random = new Random();
        this.rows = random.nextInt(5);
        this.columns = random.nextInt(5);

        randomFill();
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

    public void randomFill() {
        Random random = new Random();
        matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = random.nextFloat() > 0.5 ? 1 : 0;
            }
        }
    }

    public boolean validateForAdd(BoolMatrix matrix) {
        return matrix.rows == rows && matrix.columns == columns;
    }

    public boolean validateForMultiply(BoolMatrix matrix) {
        return matrix.rows == columns;
    }

    public void add(BoolMatrix matrix) {
        if(!validateForAdd(matrix)) {
            return;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.matrix[i][j] = this.matrix[i][j] == 1 || matrix.matrix[i][j] == 1 ? 1 : 0;
            }
        }
    }

    public void multiply(BoolMatrix matrix) {
        if(!validateForMultiply(matrix)) {
            return;
        }

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < matrix.columns; j++) {
                for(int k = 0; k < columns; k++) {
                    this.matrix[i][j] = this.matrix[i][j] == 1 || this.matrix[i][k] == 1 || matrix.matrix[k][j] == 1 ? 1 : 0;;
                }
            }
        }
        columns = matrix.rows;
    }

    public int getTrueAmount() {
        int amount = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(this.matrix[i][j] == 1) {
                    amount++;
                }
            }
        }

        return amount;
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

    public void inverse() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = matrix[i][j] == 1 ? 0 : 1;
            }
        }
    }

    public void sortByLexicographicOrder() {
        int[][] rowsSortingData = new int[rows][2];

        for (int i = 0; i < rows; i++) {
            int trueAmount = 0;
            for (int j = 0; j < columns; j++) {
                if(matrix[i][j] == 1) {
                    trueAmount++;
                }
            }
            rowsSortingData[i][0] = i;
            rowsSortingData[i][1] = trueAmount;
        }

        boolean isSorted = false;
        int[] tempRow;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < rowsSortingData.length - 1; i++) {
                if (rowsSortingData[i][1] > rowsSortingData[i + 1][1]) {
                    isSorted = false;

                    tempRow = rowsSortingData[i];
                    rowsSortingData[i] = rowsSortingData[i + 1];
                    rowsSortingData[i + 1] = tempRow;
                }
            }
        }

        int[][] cloneMatrix = cloneMatrix(matrix);

        for (int i = 0; i < rows; i++) {
            matrix[i] = cloneMatrix[rowsSortingData[i][0]];
        }

    }

    public static void main(String[] args) {
        BoolMatrix test = new BoolMatrix(3, 3);
        System.out.println("Matrix 1:");
        logArray(test.matrix);
        test.inverse();
        System.out.println("Inverse:");
        logArray(test.matrix);
    }

}
