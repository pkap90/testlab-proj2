package mat;

// Implement Determinant functionality
public class Matrix7_1 {

    public double[][] Value;
    public int rows, columns;

    public Matrix7_1(int rows, int columns, double[] array) {
        this.rows = rows;
        this.columns = columns;
        double[] longerArray = new double[rows * columns];
        System.arraycopy(array, 0, longerArray, 0, array.length);

        Value = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(longerArray, i * columns, Value[i], 0, columns);
        }
    }

    private Matrix7_1(int dimension) {
        this.rows = dimension;
        this.columns = dimension;
        Value = new double[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            Value[i][i] = 1;
        }
    }

    public static Matrix7_1 Identity(int dimension) {
        return new Matrix7_1(dimension);
    }

    public static Matrix7_1 AddMatrices(Matrix7_1 m1, Matrix7_1 m2) {
        if (m1.rows != m2.rows || m1.columns != m2.columns) {
            throw new RuntimeException("Sizes of given Matrices don't match.");
        }

        Matrix7_1 result = new Matrix7_1(m1.rows, m1.columns, new double[]{});
        for (int i = 0; i < m1.rows; ++i) {
            for (int j = 0; j < m1.columns; ++j) {
                result.Value[i][j] = m1.Value[i][j] + m2.Value[i][j];
            }
        }
        return result;
    }

    public static Matrix7_1 MultiplyMatrixByScalar(Matrix7_1 m, double scalar) {
        double[] array = new double[m.rows * m.columns];

        for (int i = 0; i < m.rows; ++i) {
            for (int j = 0; j < m.columns; ++j) {
                array[i * m.rows + j] = m.Value[i][j] * scalar;
            }
        }

        return new Matrix7_1(m.rows, m.columns, array);
    }

    private static double DeterminantHelper(double[][] matrix) {
        double sum = 0;
        int sign;

        if (matrix.length == 1) {
            return matrix[0][0];
        }

        for (int i = 0; i < matrix.length; i++) {
            //create smaller matrix - with values not in same row, column
            double[][] smaller = new double[matrix.length - 1][matrix.length - 1];
            for (int x = 1; x < matrix.length; ++x) {
                for (int y = 0; y < matrix.length; ++y) {
                    if (y < i) {
                        smaller[x - 1][y] = matrix[x][y];
                    } else if (y > i) {
                        smaller[x - 1][y - 1] = matrix[x][y];
                    }
                }
            }
            if (i % 2 == 0) {
                sign = 1;
            } else {
                sign = -1;
            }
            sum += sign * matrix[0][i] * (DeterminantHelper(smaller));
        }
        return sum;
    }

    public static double Determinant(Matrix7_1 matrix) {
        return DeterminantHelper(matrix.Value);
    }
}
