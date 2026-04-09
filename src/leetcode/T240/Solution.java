package leetcode.T240;

public class Solution {
    public static void main(String[] args) {
        System.out.println("HelloWorld");
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length-1;
        while(i<matrix.length&&j>=0){
            if(matrix[i][j]==target){
                return true;
            }
            else if(matrix[i][j]>target){
                j--;
            }
            else{
                i++;
            }
        }
        return false;
    }
}
