package mat;

// Implementation of Matrix constructor
public class Matrix1_1 {

    public double[][] Value;
    public int rows, columns;

    public Matrix1_1(double[] array, int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        Value = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(array, i * columns, Value[i], 0, columns);
        }
    }
}
