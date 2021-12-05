package Arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder1 {
    List<Integer> printAns = new ArrayList<>();
    int matrixSize;
    void traverse(int[][] matrix,int left,int right,int top,int bottom){

        for(int j = left;j <= right && printAns.size() < matrixSize;j++){
            printAns.add(matrix[top][j]);
        }

        for(int i = top + 1;i <= bottom - 1 && printAns.size() < matrixSize;i++){
            printAns.add(matrix[i][right]);
        }

        for(int j = right;j >= left && printAns.size() < matrixSize;j--){
            printAns.add(matrix[bottom][j]);
        }

        for(int i = bottom - 1;i >= top+1 && printAns.size() < matrixSize;i--){
            printAns.add(matrix[i][left]);
        }
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;

        matrixSize = N * M;

        int left = 0;
        int right = M - 1;

        int top = 0;
        int bottom = N - 1;

        while(left <= right && top <= bottom){

            traverse(matrix,left,right,top,bottom);

            left += 1;
            right -= 1;

            top += 1;
            bottom -= 1;
        }

        return printAns;
    }
}
