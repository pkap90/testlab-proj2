package mat;

// Implementation of AddMatrices
public class Matrix4_1 {

    public double[][] Value;
    public int rows, columns;

    public Matrix4_1(int rows, int columns, double[] array) {
        this.rows = rows;
        this.columns = columns;
        double[] longerArray = new double[rows * columns];
        System.arraycopy(array, 0, longerArray, 0, array.length);

        Value = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(longerArray, i * columns, Value[i], 0, columns);
        }
    }

    private Matrix4_1(int dimension) {
        this.rows = dimension;
        this.columns = dimension;
        Value = new double[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            Value[i][i] = 1;
        }
    }

    public static Matrix4_1 Identity(int dimension) {
        return new Matrix4_1(dimension);
    }

    public static Matrix4_1 AddMatrices(Matrix4_1 m1, Matrix4_1 m2) {
        Matrix4_1 result = new Matrix4_1(m1.rows, m1.columns, new double[]{});
        for (int i = 0; i < m1.rows; i++) {
            for (int j = 0; j < m1.columns; j++) {
                result.Value[i][j] = m1.Value[i][j] + m2.Value[i][j];
            }
        }
        return result;
    }
}
