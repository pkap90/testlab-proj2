package mat;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

// Test Wrong Size of Matrices -> PASS 
public class MatrixTest5_1 {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testConstructor() {
        Matrix5_1 actual = new Matrix5_1(2, 2, new double[]{1, 2, 0.1, -2});

        double[][] expected = new double[][]{{1, 2}, {0.1, -2}};
        Assert.assertArrayEquals(expected, actual.Value);
    }

    @Test
    public void testTooShortArray() {
        Matrix5_1 actual = new Matrix5_1(3, 3, new double[]{1, 2, 0.1, -2});

        double[][] expected = new double[][]{{1, 2, 0.1}, {-2, 0, 0}, {0, 0, 0}};
        Assert.assertArrayEquals(expected, actual.Value);
    }

    @Test
    public void testIdentity() {
        Matrix5_1 actual = Matrix5_1.Identity(3);

        double[][] expected = new double[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        Assert.assertArrayEquals(expected, actual.Value);
    }

    @Test
    public void testAddMatrices() {
        Matrix5_1 m1 = new Matrix5_1(2, 2, new double[]{1, 2, 0.1, -2});
        Matrix5_1 m2 = new Matrix5_1(2, 2, new double[]{2, 3, 4, 0.1});

        Matrix5_1 result = Matrix5_1.AddMatrices(m1, m2);

        double[][] expected = new double[][]{{3, 5}, {4.1, -1.9}};
        Assert.assertArrayEquals(expected, result.Value);
    }

    @Test
    public void testAddMatricesWhenWrongSizesThenRuntimeException() {
        exception.expect(RuntimeException.class);

        Matrix5_1 m1 = new Matrix5_1(2, 2, new double[]{2, 3, 4, 0.1});
        Matrix5_1 m2 = new Matrix5_1(3, 2, new double[]{2, 2, 3, 2, 0.1, -2});

        Matrix5_1 result = Matrix5_1.AddMatrices(m1, m2);
    }
}
