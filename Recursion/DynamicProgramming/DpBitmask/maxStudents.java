package Recursion.DynamicProgramming.DpBitmask;

public class maxStudents {
    

    static int maxx(char[][] seats,int pos,int prevRow,int curRow,Integer[][][] dp){
        int n = seats.length;
        int m = seats[0].length;

        if(pos >= n * m){
            return 0;
        }

        int i = pos / n;
        int j = pos % m;

        if(j == 0){
            prevRow = curRow;
            curRow = 0;
        }

        int ans = 0;

        //Not place
        ans = maxx(seats, pos + 1, prevRow, curRow, dp);

        //place student
        if(seats[i][j] == '.'){
            boolean tl = true,tr = true,l = true,r = true;
            
            if(j != 0){
                //Left
                l = ((curRow & (1 << (j - 1))) == 0);
                if(i > 0){
                    //Top-Left
                    tr = ((prevRow & (1 << (j-1))) == 0);
                }
            }

            if(j != n - 1){
                tr = ( (prevRow & (1 << (j + 1))) == 0);
            }

            if(tl && tr && l && r){
                ans = Math.max(ans,maxx(seats, pos + 1, prevRow, curRow | (1 << j), dp));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println((1 << 9));
    }
}
