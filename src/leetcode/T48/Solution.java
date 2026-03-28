package leetcode.T48;

public class Solution {
    public static void main(String[] args) {
        new Solution().rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
    public void rotate(int[][] matrix) {
        float mid_row = (matrix.length-1)/2.0f;
        float mid_col = (matrix[0].length-1)/2.0f;
        int mid = (matrix.length-1)/2;
        int mid_ = mid;
        if(matrix.length%2!=0){
            mid_--;
        }
        for(int i=0;i<=mid_;i++){
            for(int j=0;j<=mid;j++){
                float a = mid_row - i;
                float b = mid_col - j;
                int cur = matrix[i][j];
                for(int k=0;k<4;k++){
                    int next_col = 0;
                    int next_row = 0;
                    if(k==0){
                        next_col = (int)(mid_col+a);
                        next_row = (int)(mid_row-b);
                    }
                    if(k==1){
                        next_col = (int)(mid_col+b);
                        next_row = (int)(mid_row+a);
                    }
                    if(k==2){
                        next_col = (int)(mid_col-a);
                        next_row = (int)(mid_row+b);
                    }
                    if(k==3){
                        next_col = (int)(mid_col-b);
                        next_row = (int)(mid_row-a);
                    }
                    int temp = matrix[next_row][next_col];
                    matrix[next_row][next_col] = cur;
                    cur = temp;
                }
            }
        }
    }
}
