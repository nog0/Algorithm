package leetcode.T73;

import java.util.Arrays;
import java.util.HashSet;

public class Solution1 {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> col = new HashSet<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==0){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for(int i:row){
            Arrays.fill(matrix[i], 0);
        }
        for(int i:col){
            for(int j=0;j<matrix.length;j++){
                matrix[j][i] = 0;
            }
        }
    }
}
