package Recursion.DynamicProgramming.DpOnGrids;

/*
    You are given an n x n grid representing a field of cherries, each cell is one of three 
    possible integers.

    1.) 0 means the cell is empty, so you can pass through,
    2.) 1 means the cell contains a cherry that you can pick up and pass through, or
    3.) -1 means the cell contains a thorn that blocks your way.
    Return the maximum number of cherries you can collect by following the rules below:

    Starting at the position (0, 0) and reaching (n - 1, n - 1) by moving right or down through 
    valid path cells (cells with value 0 or 1).
    After reaching (n - 1, n - 1), returning to (0, 0) by moving left or up through valid path cells.
    When passing through a path cell containing a cherry, you pick it up, and the cell becomes an 
    empty cell 0.
    If there is no valid path between (0, 0) and (n - 1, n - 1), then no cherries can be collected.
*/

class Solution{
    static int maxCherries = 0;
    static void helper(int[][] grid,int x,int y,int c){
        if(x < 0 || y < 0 || x >= grid.length || y >= grid.length || grid[x][y] == -1){
            return;
        }

        if(x == 0 && y == 0){
            maxCherries = Math.max(maxCherries, c);
            return;
        }

        int cherries = grid[x][y];
        grid[x][y] = 0;

        cherryPickup(grid, x - 1, y, c + 1);
        cherryPickup(grid, x, y - 1, c + 1);
        
        grid[x][y] = cherries;
    }

    static void cherryPickup(int[][] grid,int x,int y,int c){
        if(x < 0 || y < 0 || x >= grid.length || y >= grid.length || grid[x][y] == -1){
            return;
        }

        if(x == grid.length - 1 && y == grid.length - 1){
            helper(grid,x,y,c);
        }

        int cherries = grid[x][y];
        grid[x][y] = 0;

        cherryPickup(grid, x + 1, y, c + 1);
        cherryPickup(grid, x, y  + 1, c + 1);
        
        grid[x][y] = cherries;
    }

    //BACKTRACKING SOLUTION
}

/*
    In recursive Solution instead of going first down and coming back up,
    we'll make two calls running each independently towards downward. This will help satisfy
    condition of the given question and help us calculate the required stuff.
*/
class DynamicProgrammingSol{

    static int recursion(int[][] grid,int r1,int c1,int r2,int c2,int n){
        if(r1 >= n || r2 >= n || c1 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1){
            return Integer.MIN_VALUE;
        }

        int cherries = 0;
        if(r1 == r2 && c1 == c2){
            cherries += grid[r1][c1];
        }else{
            cherries += grid[r1][c1] + grid[r2][c2];
        }

        int f1 = recursion(grid, r1, c1 + 1, r2, c2 + 1,n);//hh
        int f2 = recursion(grid, r1 + 1, c1, r2, c2 + 1,n);//vh
        int f3 = recursion(grid, r1 + 1, c1, r2 + 1, c2,n);//vv
        int f4 = recursion(grid, r1, c1 + 1, r2 + 1, c2,n);//hv
        
        cherries += Math.max(Math.max(f1,f2),Math.max(f3,f4));

        return cherries;
    }
}

/*
    0 1 1 1
    0 0 0 1
    1 1 1 1
    1 0 0 1
*/