package Arrays;
import java.util.*;

public class ReorderLogFiles {
    class LetterLog implements Comparable<LetterLog>{
            String logId;
            String logValue;
            String logString;
            public LetterLog(String _logString){
                this.logString = _logString;
                this.parseString();
            }

            void parseString(){
                String[] values = logString.split("-");
                StringBuilder sb = new StringBuilder();
                for(int i = 1;i < values.length;i++){
                    sb.append(values[i]+"-");
                }
                logValue = sb.toString();
                logId = values[0];
            }

            @Override
            public int compareTo(LetterLog other){
                return this.logValue.compareTo(other.logValue);
            }

        }
        boolean isInteger(String parseString){
            try{
                Integer.parseInt(parseString);
            }catch(NumberFormatException e){
                return false;
            }catch(NullPointerException e){
                return false;
            }
            return true;
        }
        boolean isLogString(String st){
            String checkVar = "";
            for(int i = 0;i < st.length();i++){
                if(st.charAt(i) == '-'){
                    checkVar = st.charAt(i+1)+"";
                    break;
                }
            }
            return !isInteger(checkVar);
        }
        public ArrayList<String> reorderLogs(ArrayList<String> logs) {
            //ArrayList<String> sortedLogs = new ArrayList<>();
            ArrayList<LetterLog> stringLogs = new ArrayList<>();
            ArrayList<String> digitLogs = new ArrayList<>();

            for(String logString : logs){
                if(isLogString(logString) == true){
                    LetterLog obj = new LetterLog(logString);
                    stringLogs.add(obj);
                }else{
                    digitLogs.add(logString);
                }
            }

            Collections.sort(stringLogs);
            ArrayList<String> sortedStringLogs = new ArrayList<>();
            for(LetterLog obj : stringLogs){
                sortedStringLogs.add(obj.logString);
            }
            sortedStringLogs.addAll(digitLogs);
            return sortedStringLogs;
    }

    public static void main(String[] args) {
        ReorderLogFiles rLog = new ReorderLogFiles();
        ArrayList<String> logs = new ArrayList<>();
        logs.add("dig1-8-1-5-1");
        logs.add("let1-art-can");
        logs.add("dig2-3-6");
        logs.add("let2-own-kit-dig");
        logs.add("let3-art-zero");
        //System.out.println("ownkitdig".compareTo("artzero"));
        System.out.println(rLog.reorderLogs(logs));
    }
}
//["dig1-8-1-5-1", "let1-art-can", "dig2-3-6", "let2-own-kit-dig", "let3-art-zero"]


