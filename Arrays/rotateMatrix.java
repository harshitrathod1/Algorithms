package Arrays;

public class rotateMatrix {

    void rotateHelper(int[][] matrix,int sr,int sc,int N){
        int times = N - 1;

        for(int i = sr;i < times;i++){

            int start_row = sr,row = sr;
            int start_col = i,col = sr + times;
            boolean flag = false;
            int var = matrix[start_row][start_col];

            while(true){
                //System.out.println("Here");
                if(row == start_row && col == start_col){
                    break;
                }
                //System.out.println(row+" "+col);

                int temp = matrix[row][col];
                matrix[row][col] = var;
                var = temp;
                if(flag == false){
                    row = row == times ? 0 : row + times;
                    flag = true;
                }else{
                    col = col == times ? 0 : col + times;
                    flag = false;
                }
            }
        }
    }
    public void rotate(int[][] matrix) {
        int N = matrix.length;

        int sr = 0,sc = 0;
        int times = N/2;
        int count = 0;

        while(count < times){
            rotateHelper(matrix,sr,sc,N);
            sr = sr + 1;
            sc = sc + 1;
            count += 1;
            N -= 2;
            //System.out.println("Here");
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
         {5,1,9,11},
         {2,4,8,10},
         {13,3,6,7},
         {15,14,12,16}
        };

        rotateMatrix rm = new rotateMatrix();
        rm.rotate(matrix);

        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;i++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
