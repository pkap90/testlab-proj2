package mat;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

// Test MultiplyByScalar funcionality -> FAIL (not implemented)
public class MatrixTest6_0 {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testConstructor() {
        Matrix6_0 actual = new Matrix6_0(2, 2, new double[]{1, 2, 0.1, -2});

        double[][] expected = new double[][]{{1, 2}, {0.1, -2}};
        Assert.assertArrayEquals(expected, actual.Value);
    }

    @Test
    public void testTooShortArray() {
        Matrix6_0 actual = new Matrix6_0(3, 3, new double[]{1, 2, 0.1, -2});

        double[][] expected = new double[][]{{1, 2, 0.1}, {-2, 0, 0}, {0, 0, 0}};
        Assert.assertArrayEquals(expected, actual.Value);
    }

    @Test
    public void testIdentity() {
        Matrix6_0 actual = Matrix6_0.Identity(3);

        double[][] expected = new double[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        Assert.assertArrayEquals(expected, actual.Value);
    }

    @Test
    public void testAddMatrices() {
        Matrix6_0 m1 = new Matrix6_0(2, 2, new double[]{1, 2, 0.1, -2});
        Matrix6_0 m2 = new Matrix6_0(2, 2, new double[]{2, 3, 4, 0.1});

        Matrix6_0 result = Matrix6_0.AddMatrices(m1, m2);

        double[][] expected = new double[][]{{3, 5}, {4.1, -1.9}};
        Assert.assertArrayEquals(expected, result.Value);
    }

    @Test
    public void testAddMatricesWhenWrongSizesThenRuntimeException() {
        exception.expect(RuntimeException.class);

        Matrix6_0 m1 = new Matrix6_0(2, 2, new double[]{2, 3, 4, 0.1});
        Matrix6_0 m2 = new Matrix6_0(3, 2, new double[]{2, 2, 3, 2, 0.1, -2});

        Matrix6_0 result = Matrix6_0.AddMatrices(m1, m2);
    }

    @Test
    public void testMultiplyMatrixByScalar() {
        Matrix6_0 matrix = new Matrix6_0(2, 2, new double[]{5, 1, 0, 4});
        double scalar = 2.1;

        Matrix6_0 result = Matrix6_0.MultiplyMatrixByScalar(matrix, scalar);

        double[][] expected = new double[][]{{10.5, 2.1}, {0, 8.4}};
        Assert.assertArrayEquals(expected, result.Value);
    }
}
