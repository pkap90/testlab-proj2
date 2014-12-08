package mat;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

// Add MultiplyMatrixByScalar functionality
public class Matrix6_0 {

    public double[][] Value;
    public int rows, columns;

    public Matrix6_0(int rows, int columns, double[] array) {
        this.rows = rows;
        this.columns = columns;
        double[] longerArray = new double[rows * columns];
        System.arraycopy(array, 0, longerArray, 0, array.length);

        Value = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(longerArray, i * columns, Value[i], 0, columns);
        }
    }

    private Matrix6_0(int dimension) {
        this.rows = dimension;
        this.columns = dimension;
        Value = new double[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            Value[i][i] = 1;
        }
    }

    public static Matrix6_0 Identity(int dimension) {
        return new Matrix6_0(dimension);
    }

    public static Matrix6_0 AddMatrices(Matrix6_0 m1, Matrix6_0 m2) {
        if (m1.rows != m2.rows || m1.columns != m2.columns) {
            throw new RuntimeException("Sizes of given Matrices don't match.");
        }

        Matrix6_0 result = new Matrix6_0(m1.rows, m1.columns, new double[]{});
        for (int i = 0; i < m1.rows; i++) {
            for (int j = 0; j < m1.columns; j++) {
                result.Value[i][j] = m1.Value[i][j] + m2.Value[i][j];
            }
        }
        return result;
    }

    public static Matrix6_0 MultiplyMatrixByScalar(Matrix6_0 matrix, double scalar) {
        throw new NotImplementedException();
    }
}
