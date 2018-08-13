import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RotateMatrixTest {
    private int[][] matrix;

    @Test
    public void testCreateMatrix(){
        matrix = createMatrix(4);
        Assert.assertEquals(2, matrix[0][2]);
        Assert.assertEquals(0, matrix[0][0]);
        Assert.assertEquals(4, matrix[1][0]);
        Assert.assertEquals(15, matrix[3][3]);
    }

    @Test
    public void testRotateRight(){
        matrix = createMatrix(4);
        RotateMatrix.printMatrix(matrix);
        RotateMatrix.rotate(matrix);
        RotateMatrix.printMatrix(matrix);
        Assert.assertEquals(0, matrix[0][3]);
        Assert.assertEquals(4, matrix[0][2]);
    }


    private int[][] createMatrix(int n){
        int count = 0;
        int[][] result = new int[n][];
        for(int i = 0; i < n; i++){
            int[] row = new int[n];
            for(int j = 0; j < n; j++){
                row[j] = count;
                count++;
            }
            result[i] = row;
        }

        return result;
    }

}
