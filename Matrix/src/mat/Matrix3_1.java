package mat;

// Implement identity Matrix creation
public class Matrix3_1 {

    public double[][] Value;
    public int rows, columns;

    public Matrix3_1(double[] array, int rows, int columns) {
        double[] longerArray = new double[rows * columns];
        System.arraycopy(array, 0, longerArray, 0, array.length);

        Value = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(longerArray, i * columns, Value[i], 0, columns);
        }
    }

    public Matrix3_1(int dimension) {
        this.rows = this.columns = dimension;
        Value = new double[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            Value[i][i] = 1;
        }
    }
}
