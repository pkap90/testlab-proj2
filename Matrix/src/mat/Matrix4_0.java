package mat;

// add AddMatrices funcionallity
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Matrix4_0 {

    public double[][] Value;
    public int rows, columns;

    public Matrix4_0(int rows, int columns, double[] array) {
        this.rows = rows;
        this.columns = columns;

        double[] longerArray = new double[rows * columns];
        System.arraycopy(array, 0, longerArray, 0, array.length);

        Value = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(longerArray, i * columns, Value[i], 0, columns);
        }
    }

    private Matrix4_0(int dimension) {
        this.rows = this.columns = dimension;
        Value = new double[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            Value[i][i] = 1;
        }
    }

    public static Matrix4_0 Identity(int dimension) {
        return new Matrix4_0(dimension);
    }

    public static Matrix4_0 AddMatrices(Matrix4_0 m1, Matrix4_0 m2) {
        throw new NotImplementedException();
    }
}
