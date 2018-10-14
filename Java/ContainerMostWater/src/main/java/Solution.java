import java.util.Arrays;

public class Solution {

    /**
     * Dynamic Programming:
     * - Make the list into a double array:
     * - Col and Row are the indices
     * - The array stores the max volume between the two indices
     * - Build the array by descending diagonally from left to right
     * - Each cell comparison consist of comparing the current value to the cells above and to the right
     * - While building the array, store the value of max
     */
    public int optimal(int[] heights) {
        int max = 0;
        int[][] list = new int[heights.length][];
        Arrays.fill(list, new int[heights.length]);
        for (int i = 0; i < heights.length; i++) {
            for (int j = i; j >= 0; j--) {
                int len = i - j;
                int curr = len * Math.min(heights[i], heights[j]);
                list[i][j] = curr;
                max = (list[i][j] > max) ? list[i][j] : max;
                if (len == 0) continue;
                //Check if current value is greater than previous
                list[i][j] = (curr < list[i - 1][j]) ? list[i - 1][j] : list[i][j];
                list[i][j] = (curr < list[i][j + 1]) ? list[i][j + 1] : list[i][j];
                System.out.print(list[i][j]);
            }
            System.out.println();
        }

        return max;
    }


    /**
     * Find the max of each segment individually
     * iterating through every segment lengths while
     * storing the largest volume
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int maxVol = 0;
        int width = 1;
        while (width < height.length) {
            for (int i = 0; i + width < height.length; ++i) {
                int vol = Math.min(height[i], height[i + width]) * width;
                maxVol = Math.max(maxVol, vol);
            }
            width++;
        }
        return maxVol;
    }
}
