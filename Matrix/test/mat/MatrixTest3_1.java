package mat;

import org.junit.Assert;
import org.junit.Test;

// test Identity Matrix creation -> PASS
public class MatrixTest3_1 {

    @Test
    public void testConstructor() {
        Matrix3_1 actual = new Matrix3_1(new double[]{1, 2, 0.1, -2}, 2, 2);

        double[][] expected = new double[][]{{1, 2}, {0.1, -2}};
        Assert.assertArrayEquals(actual.Value, expected);
    }

    @Test
    public void testTooShortArray() {
        Matrix3_1 actual = new Matrix3_1(new double[]{1, 2, 0.1, -2}, 3, 3);
        Matrix3_1 actual2 = new Matrix3_1(new double[]{}, 3, 3);

        double[][] expected = new double[][]{{1, 2, 0.1}, {-2, 0, 0}, {0, 0, 0}};
        double[][] expected2 = new double[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        Assert.assertArrayEquals(actual.Value, expected);
        Assert.assertArrayEquals(actual2.Value, expected2);
    }

    @Test
    public void testIdentity() {
        Matrix3_1 actual = new Matrix3_1(3);

        double[][] expected = new double[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        Assert.assertArrayEquals(actual.Value, expected);
    }
}
