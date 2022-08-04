class Solution {
    public String[] reorderLogFiles(String[] logs) {
        
        Comparator<String> myComp = new Comparator<String>(){
            @Override
            public int compare(String log1, String log2){
                // split each log into two parts : <identifier, content>

                String[] split1 = log1.split(" ", 2);
                String[] split2 = log2.split(" ", 2);

                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

                // Case 1 : both logs are letter logs
                if( !isDigit1 && !isDigit2){
                    // First compare content ==> then identifier
                    int cmp = split1[1].compareTo(split2[1]);
                    if (cmp != 0)
                        return cmp;
                    return split1[0].compareTo(split2[0]);
                }

                // Case 2 : One of logs is digit logs
                if( !isDigit1 && isDigit2){
                    // Letter log comes before digit log
                    return -1;
                }
                else if( isDigit1 && !isDigit2){
                    return 1;
                }
                // Case 3 : both logs are digit logs
                else{
                    return 0;
                }
            }
        };

        Arrays.sort(logs, myComp);
        return logs;
    }
}