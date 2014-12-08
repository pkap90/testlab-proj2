package mat;

// Auto-completion of Matrix with 0 when given array is too short to fill the Matrix
public class Matrix2_1 {

    public double[][] Value;
    public int rows, columns;

    public Matrix2_1(double[] array, int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        double[] longerArray = new double[rows * columns];
        System.arraycopy(array, 0, longerArray, 0, array.length);

        Value = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(longerArray, i * columns, Value[i], 0, columns);
        }
    }
}
