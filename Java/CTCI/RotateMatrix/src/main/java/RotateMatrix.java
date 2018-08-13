public class RotateMatrix {

    /**
     * Rotates a matrix clockwise
     *  - Save the first element
     *  - Move each element one at a time
     *  - Move one layer at a time
     *  - There are floor(n/2) layers
     *  - If n is odd, the one tile in the center does not rotate
     * @param matrix
     *
     */
    public static void rotate(int[][] matrix){
        int n = matrix.length;

        for(int layer = 0; layer < n/2; layer++){
            //first = the index of the first element in the layer
            int first = layer;
            int last = n - 1 - layer;

            for(int i = first; i < last; i++){

                //The offset needs to start from 0 for every layer
                int offset = i - first;

                //Save top
                int temp = matrix[first][i];


                //Move left to top
                matrix[first][i] = matrix[last - offset][first];

                //Move bottom to left
                matrix[last - offset][first] = matrix[last][last - offset];

                //Move right to bottom
                matrix[last][last - offset] = matrix[i][last];

                //Move top to right
                matrix[i][last] = temp;
            }
        }
    }


    public static void printMatrix(int[][] matrix){
       for(int i = 0; i < matrix.length; i++){
           for(int j = 0; j < matrix.length; j++){
               System.out.print(matrix[i][j] + "  ");
           }
           System.out.print("\n");
       }

        System.out.print("\n");

    }
}
