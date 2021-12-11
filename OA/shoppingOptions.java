package OA;

public class shoppingOptions {
    int maxComb = 0;
    public void helper(int[] jeans,int[] shoes,int[] skirts,int[] tops,int budget,int currentSpend,int level){
        if(level > 3){
            if(currentSpend <= budget) maxComb++;
            return;
        }
        if(level == 0){
            for(int i = 0;i < jeans.length;i++){
                helper(jeans,shoes,skirts,tops,budget,currentSpend+jeans[i],level+1);
            }
        }else if (level == 1){
            for(int i = 0;i < shoes.length;i++){
                helper(jeans,shoes,skirts,tops,budget,currentSpend+shoes[i],level + 1);
            }
        }else if (level == 2){
            for(int i = 0;i < skirts.length;i++){
                helper(jeans,shoes,skirts,tops,budget,currentSpend+skirts[i],level + 1);
            }
        }else{
            for(int i = 0;i < tops.length;i++){
                helper(jeans,shoes,skirts,tops,budget,currentSpend+tops[i],level + 1);
            }
        }
    }
    public int getOptions(int[] jeans,int[] shoes,int[] skirts,int[] tops,int budget){
        maxComb = 0;
        helper(jeans,shoes,skirts,tops,budget,0,0);
        return maxComb;
    }
    public static void main(String[] args) {
        shoppingOptions options = new shoppingOptions();
        int[] jeans = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13};
        int[] shoes = new int[]{4,5,6,7,8,9};
        int[] skirts = new int[]{2,3,12,13,15,16};
        int[] tops = new int[]{11,12,14,15,16,17,18,19};
        int ans = options.getOptions(jeans,shoes,skirts,tops,1000000);
        System.out.println(ans);
    }
}
