package mat;

import org.junit.Assert;
import org.junit.Test;

public class MatrixTest {
    
    @Test
    public void testConstructor() {
        Matrix actual = new Matrix(new double[] {1, 2, 0.1, -2}, 2, 2); 
        
        double[][] expected = new double[][] {{1, 2}, {0.1, -2}};
        Assert.assertArrayEquals(expected, actual.Value);
    }
    
    @Test
    public void testTooShortArray() {
        Matrix actual = new Matrix(new double[] {1, 2, 0.1, -2}, 3, 3); 
        
        double[][] expected = new double[][] {{1, 2, 0.1}, {-2, 0, 0}, {0, 0, 0}};
        Assert.assertArrayEquals(expected, actual.Value);
    }
    
    @Test
    public void testIdentity() {
        Matrix actual = new Matrix(3); 
        
        double[][] expected = new double[][] {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        Assert.assertArrayEquals(expected, actual.Value);
    }    
    
    @Test
    public void testAddMatrix() {
        Matrix matrix1 = new Matrix(new double[] {1, 2, 0.1, -2}, 2, 2);
        Matrix matrix2 = new Matrix(new double[] {2, 3, 4, 0.1}, 2, 2); 
        
        matrix1.AddMatrix(matrix2);
        
        double[][] expected = new double[][] {{3, 5}, {4.1, -1.9}};
        Assert.assertArrayEquals(expected, matrix1.Value);
    }
}

/*
package mat;

import org.junit.Assert;
import org.junit.Test;

public class MatrixTest {
    
    @Test
    public void testConstructor() {
        Matrix actual = new Matrix(new double[] {1, 2, 0.1, -2}, 2, 2); 
        
        double[][] expected = new double[][] {{1, 2}, {0.1, -2}};
        Assert.assertArrayEquals(actual.Value, expected);
    }    
}

package mat;

import org.junit.Assert;
import org.junit.Test;

public class MatrixTest {
    
    @Test
    public void testConstructor() {
        Matrix actual = new Matrix(new double[] {1, 2, 0.1, -2}, 2, 2); 
        
        double[][] expected = new double[][] {{1, 2}, {0.1, -2}};
        Assert.assertArrayEquals(actual.Value, expected);
    }
    
    @Test
    public void testTooShortArray() {
    Matrix actual = new Matrix(new double[] {1, 2, 0.1, -2}, 3, 3); 
        
    double[][] expected = new double[][] {{1, 2, 0.1}, {-2, 0, 0}, {0, 0, 0}};
    Assert.assertArrayEquals(actual.Value, expected);
    }
}
package mat;

import org.junit.Assert;
import org.junit.Test;

public class MatrixTest {
    
    @Test
    public void testConstructor() {
        Matrix actual = new Matrix(new double[] {1, 2, 0.1, -2}, 2, 2); 
        
        double[][] expected = new double[][] {{1, 2}, {0.1, -2}};
        Assert.assertArrayEquals(actual.Value, expected);
    }
    
    @Test
    public void testTooShortArray() {
        Matrix actual = new Matrix(new double[] {1, 2, 0.1, -2}, 3, 3); 
        
        double[][] expected = new double[][] {{1, 2, 0.1}, {-2, 0, 0}, {0, 0, 0}};
        Assert.assertArrayEquals(actual.Value, expected);
    }
    
    @Test
    public void testIdentity() {
        Matrix actual = new Matrix(3); 
        
        double[][] expected = new double[][] {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        Assert.assertArrayEquals(actual.Value, expected);
    }
}


*/