package TwoPointers;

public class ContainerWithMostWater {


    public static void main(String[] args) {
//        Given n non-negative integers a1, a2, ..., an ,
//                where each represents a point at coordinate (i, ai).
//        n vertical lines are drawn such that the two endpoints of line i
//        is at (i, ai) and (i, 0). Find two lines, which together with x-axis
//        forms a container, such that the container contains the most water.


    }
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int maxArea = Integer.MIN_VALUE;
        while(i != j){
            int area = (j - i) * Math.min(height[j], height[i]);
            if(height[i] < height[j]){
                i++;
            }
            else{
                j--;
            }
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;

    }
}
