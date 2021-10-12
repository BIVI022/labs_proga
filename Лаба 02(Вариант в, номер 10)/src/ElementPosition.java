public class ElementPosition {

    boolean[] rowsIndexes;
    boolean[] columnsIndexes;

    public ElementPosition(int element, int[][] matrix) {
        rowsIndexes = new boolean[matrix.length];
        columnsIndexes = new boolean[matrix.length];
        for (int i = 0; i < rowsIndexes.length; i++) {
            rowsIndexes[i] = false;
            columnsIndexes[i] = false;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(element == matrix[i][j]) {
                    rowsIndexes[i] = true;
                    columnsIndexes[j] = true;
                }
            }
        }
    }
}
