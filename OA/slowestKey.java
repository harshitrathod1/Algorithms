package OA;

public class slowestKey {

    public char getSlowKey(int[] keyTimes,String s){

        int lastTime = 0;
        int maxDuration = -1;
        char slowestKey = s.charAt(0);
        int it = 0;

        for(int time : keyTimes){
            int currentDuration = time - lastTime;
            if(currentDuration > maxDuration){
                maxDuration = currentDuration;
                slowestKey = s.charAt(it);
            }else if(currentDuration == maxDuration) {
                char currentKey = s.charAt(it);
                if(currentKey > slowestKey) slowestKey = currentKey;
            }
            lastTime = time;
            it++;
        }
        return slowestKey;
    }

    public static void main(String[] args) {
        slowestKey sk = new slowestKey();
        int[] times = new int[]{9,29,49,50};
        String keys = "cbcd";

        System.out.println(sk.getSlowKey(times,keys)+"");
    }
}
