package Recursion.DynamicProgramming.DpBitmask;
/*
    Given a set S, Add, remove and display given set with help of bitmasks
*/

public class ParentProblem {

    final static int MAX_SUBSET_LEN = 31;
    
    static void display(int subset){
        
        System.out.println("Elements in subset");
        for(int bit = MAX_SUBSET_LEN;bit >=0;bit--){
            if((subset & (1 << bit)) != 0){
                System.out.print(bit +" ");
            }
        }
    }

    /*
        remove(11,2)
        11 represents subset = 0 1 1 1 = {4,2,1}
        remove 2 from above subset. 
    */
    static int remove(int subset,int removeVal){
        subset = (subset ^ (1 << (removeVal)));
        return subset;
    }

    static int add(int subset,int addVal){
        subset = (subset ^ (1 << (addVal - 1)));
        return subset;
    }

    public static void main(String[] args) {
        int mask = 15396526;
        display(mask);
        
        for(int i = MAX_SUBSET_LEN;i >= 0;i--){
            if((mask & (1 <<  i)) != 0){
                mask = (mask ^ (1 << i));
            }
        }
        System.out.println();
        System.out.println(mask);
    }
}
