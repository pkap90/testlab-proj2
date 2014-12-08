package mat;

import org.junit.Assert;
import org.junit.Test;

// Write tests for Matrix constructor -> FAIL (not implemented)
public class MatrixTest1_0 {

    @Test
    public void testConstructor() {
        Matrix1_0 actual = new Matrix1_0(new double[]{1, 2, 0.1, -2}, 2, 2);

        double[][] expected = new double[][]{{1, 2}, {0.1, -2}};
        Assert.assertArrayEquals(actual.Value, expected);
    }
}
