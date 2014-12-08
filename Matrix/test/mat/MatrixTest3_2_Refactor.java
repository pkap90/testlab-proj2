package mat;

import org.junit.Assert;
import org.junit.Test;

// Refactoring
public class MatrixTest3_2_Refactor {

    @Test
    public void testConstructor() {
        Matrix3_2 actual = new Matrix3_2(2, 2, new double[]{1, 2, 0.1, -2});

        double[][] expected = new double[][]{{1, 2}, {0.1, -2}};
        Assert.assertArrayEquals(actual.Value, expected);
    }

    @Test
    public void testTooShortArray() {
        Matrix3_2 actual = new Matrix3_2(3, 3, new double[]{1, 2, 0.1, -2});
        Matrix3_2 actual2 = new Matrix3_2(3, 3, new double[]{});

        double[][] expected = new double[][]{{1, 2, 0.1}, {-2, 0, 0}, {0, 0, 0}};
        double[][] expected2 = new double[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        Assert.assertArrayEquals(actual.Value, expected);
        Assert.assertArrayEquals(actual2.Value, expected2);
    }

    @Test
    public void testIdentity() {
        Matrix3_2 actual = Matrix3_2.Identity(3);

        double[][] expected = new double[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        Assert.assertArrayEquals(actual.Value, expected);
    }
}
