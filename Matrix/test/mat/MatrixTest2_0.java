package mat;

import org.junit.Assert;
import org.junit.Test;

// Implement tests for Too Short Array completion -> FAIL (not implemented)
public class MatrixTest2_0 {

    @Test
    public void testConstructor() {
        Matrix1_1 actual = new Matrix1_1(new double[]{1, 2, 0.1, -2}, 2, 2);

        double[][] expected = new double[][]{{1, 2}, {0.1, -2}};
        Assert.assertArrayEquals(actual.Value, expected);
    }

    @Test
    public void testTooShortArray() {
        Matrix1_1 actual = new Matrix1_1(new double[]{1, 2, 0.1, -2}, 3, 3);

        double[][] expected = new double[][]{{1, 2, 0.1}, {-2, 0, 0}, {0, 0, 0}};
        Assert.assertArrayEquals(actual.Value, expected);
    }
}
