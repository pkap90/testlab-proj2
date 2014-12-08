package mat;

public class Matrix {

    public double[][] Value;
    public int rows, columns;
    
    public Matrix (double[] array, int rows, int columns)
    {
        this.rows = rows;
        this.columns = columns;
        double[] longerArray = new double[rows*columns];
        System.arraycopy(array, 0, longerArray, 0, array.length);
        
        Value = new double [rows][columns];
        for (int i=0; i<rows; i++)
            System.arraycopy(longerArray, i*columns, Value[i], 0, columns);
    }  
    
    public Matrix (int dimension)
    {
        this.rows = dimension;
        this.columns = dimension;
        Value = new double[dimension][dimension];
        
        for (int i=0; i<dimension; i++)
            Value[i][i] = 1;
    }
    
    public void AddMatrix(Matrix matrix)
    {
        for (int i=0; i<matrix.rows; i++)
            for (int j=0; j<matrix.columns; j++)
                this.Value[i][j] += matrix.Value[i][j];
    }
}

/*

package mat;

public class Matrix {

    public double[][] Value;
    public Matrix (double[] array, int rows, int columns)
    {
        
    }
}

package mat;

public class Matrix {

    public double[][] Value;
    public Matrix (double[] array, int rows, int columns)
    {
        Value = new double [rows][columns];
        for (int i=0; i<rows; i++)
            System.arraycopy(array, i*columns, Value[i], 0, columns);
    }  
}

package mat;

public class Matrix {

    public double[][] Value;
    public Matrix (double[] array, int rows, int columns)
    {
        double[] longerArray = new double[rows*columns];
        System.arraycopy(array, 0, longerArray, 0, array.length);
        
        Value = new double [rows][columns];
        for (int i=0; i<rows; i++)
            System.arraycopy(longerArray, i*columns, Value[i], 0, columns);
    }  
}
package mat;

public class Matrix {

    public double[][] Value;
    
    public Matrix (double[] array, int rows, int columns)
    {
        double[] longerArray = new double[rows*columns];
        System.arraycopy(array, 0, longerArray, 0, array.length);
        
        Value = new double [rows][columns];
        for (int i=0; i<rows; i++)
            System.arraycopy(longerArray, i*columns, Value[i], 0, columns);
    }  
    
    public Matrix (int dimension)
    {
    }
}

package mat;

public class Matrix {

    public double[][] Value;
    
    public Matrix (double[] array, int rows, int columns)
    {
        double[] longerArray = new double[rows*columns];
        System.arraycopy(array, 0, longerArray, 0, array.length);
        
        Value = new double [rows][columns];
        for (int i=0; i<rows; i++)
            System.arraycopy(longerArray, i*columns, Value[i], 0, columns);
    }  
    
    public Matrix (int dimension)
    {
        Value = new double[dimension][dimension];
        
        for (int i=0; i<dimension; i++)
            Value[i][i] = 1;
    }
}

package mat;

public class Matrix {

    public double[][] Value;
    
    public Matrix (double[] array, int rows, int columns)
    {
        double[] longerArray = new double[rows*columns];
        System.arraycopy(array, 0, longerArray, 0, array.length);
        
        Value = new double [rows][columns];
        for (int i=0; i<rows; i++)
            System.arraycopy(longerArray, i*columns, Value[i], 0, columns);
    }  
    
    public Matrix (int dimension)
    {
        Value = new double[dimension][dimension];
        
        for (int i=0; i<dimension; i++)
            Value[i][i] = 1;
    }
    
    public void AddMatrix(Matrix matrix)
    {
        
    }
}

*/