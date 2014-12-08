package mat;

import org.junit.Assert;
import org.junit.Test;

// Implement tests for Too Short Array completion -> PASS (implemented)
public class MatrixTest2_1 {

    @Test
    public void testConstructor() {
        Matrix2_1 actual = new Matrix2_1(new double[]{1, 2, 0.1, -2}, 2, 2);

        double[][] expected = new double[][]{{1, 2}, {0.1, -2}};
        Assert.assertArrayEquals(actual.Value, expected);
    }

    @Test
    public void testTooShortArray() {
        Matrix2_1 actual = new Matrix2_1(new double[]{1, 2, 0.1, -2}, 3, 3);

        double[][] expected = new double[][]{{1, 2, 0.1}, {-2, 0, 0}, {0, 0, 0}};
        Assert.assertArrayEquals(actual.Value, expected);
    }
}
