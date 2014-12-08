package mat;

// Implement MultiplyMatrixByScalar functionality
public class Matrix6_1 {

    public double[][] Value;
    public int rows, columns;

    public Matrix6_1(int rows, int columns, double[] array) {
        this.rows = rows;
        this.columns = columns;
        double[] longerArray = new double[rows * columns];
        System.arraycopy(array, 0, longerArray, 0, array.length);

        Value = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(longerArray, i * columns, Value[i], 0, columns);
        }
    }

    private Matrix6_1(int dimension) {
        this.rows = dimension;
        this.columns = dimension;
        Value = new double[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            Value[i][i] = 1;
        }
    }

    public static Matrix6_1 Identity(int dimension) {
        return new Matrix6_1(dimension);
    }

    public static Matrix6_1 AddMatrices(Matrix6_1 m1, Matrix6_1 m2) {
        if (m1.rows != m2.rows || m1.columns != m2.columns) {
            throw new RuntimeException("Sizes of given Matrices don't match.");
        }

        Matrix6_1 result = new Matrix6_1(m1.rows, m1.columns, new double[]{});
        for (int i = 0; i < m1.rows; i++) {
            for (int j = 0; j < m1.columns; j++) {
                result.Value[i][j] = m1.Value[i][j] + m2.Value[i][j];
            }
        }
        return result;
    }

    public static Matrix6_1 MultiplyMatrixByScalar(Matrix6_1 m, double scalar) {
        double[] array = new double[m.rows * m.columns];

        for (int i = 0; i < m.rows; i++) {
            for (int j = 0; j < m.columns; j++) {
                array[i * m.rows + j] = m.Value[i][j] * scalar;
            }
        }

        return new Matrix6_1(m.rows, m.columns, array);
    }
}
