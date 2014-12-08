package mat;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

// Test Determinant funcionality -> FAIL (not implemented)
public class MatrixTest7_0 {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testConstructor() {
        Matrix7_0 actual = new Matrix7_0(2, 2, new double[]{1, 2, 0.1, -2});

        double[][] expected = new double[][]{{1, 2}, {0.1, -2}};
        Assert.assertArrayEquals(expected, actual.Value);
    }

    @Test
    public void testTooShortArray() {
        Matrix7_0 actual = new Matrix7_0(3, 3, new double[]{1, 2, 0.1, -2});

        double[][] expected = new double[][]{{1, 2, 0.1}, {-2, 0, 0}, {0, 0, 0}};
        Assert.assertArrayEquals(expected, actual.Value);
    }

    @Test
    public void testIdentity() {
        Matrix7_0 actual = Matrix7_0.Identity(3);

        double[][] expected = new double[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        Assert.assertArrayEquals(expected, actual.Value);
    }

    @Test
    public void testAddMatrices() {
        Matrix7_0 m1 = new Matrix7_0(2, 2, new double[]{1, 2, 0.1, -2});
        Matrix7_0 m2 = new Matrix7_0(2, 2, new double[]{2, 3, 4, 0.1});

        Matrix7_0 result = Matrix7_0.AddMatrices(m1, m2);

        double[][] expected = new double[][]{{3, 5}, {4.1, -1.9}};
        Assert.assertArrayEquals(expected, result.Value);
    }

    @Test
    public void testAddMatricesWhenWrongSizesThenRuntimeException() {
        exception.expect(RuntimeException.class);

        Matrix7_0 m1 = new Matrix7_0(2, 2, new double[]{2, 3, 4, 0.1});
        Matrix7_0 m2 = new Matrix7_0(3, 2, new double[]{2, 2, 3, 2, 0.1, -2});

        Matrix7_0 result = Matrix7_0.AddMatrices(m1, m2);
    }

    @Test
    public void testMultiplyMatrixByScalar() {
        Matrix7_0 matrix = new Matrix7_0(2, 2, new double[]{5, 1, 0, 4});
        double scalar = 2.1;

        Matrix7_0 result = Matrix7_0.MultiplyMatrixByScalar(matrix, scalar);

        double[][] expected = new double[][]{{10.5, 2.1}, {0, 8.4}};
        Assert.assertArrayEquals(expected, result.Value);
    }

    @Test
    public void testDeterminant() {
        Matrix7_0 matrix = new Matrix7_0(4, 4, new double[]{
            1, 5, 6, 2.2,
            3.3, 9, 10, 1,
            7, 9, 3.2, 5.1,
            5, 8, 6.3, 2
        });

        double determinant = Matrix7_0.Determinant(matrix);
        double expected = 60.729;
        Assert.assertEquals(expected, determinant, 0.001);
    }
}
