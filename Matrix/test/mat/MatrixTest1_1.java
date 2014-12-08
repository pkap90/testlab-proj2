package mat;

import org.junit.Assert;
import org.junit.Test;

// Write tests for Matrix constructor -> PASS
public class MatrixTest1_1 {

    @Test
    public void testConstructor() {
        Matrix1_1 actual = new Matrix1_1(new double[]{1, 2, 0.1, -2}, 2, 2);

        double[][] expected = new double[][]{{1, 2}, {0.1, -2}};
        Assert.assertArrayEquals(actual.Value, expected);
    }
}
