import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public String validIPAddress(String queryIP) {

        if(queryIP.chars().filter(ch -> ch == '.').count() == 3){
            return ipv4(queryIP) ? "IPv4" : "Neither";
        }
        else if(queryIP.chars().filter(ch -> ch == ':').count() == 7){
            return ipv6(queryIP) ? "IPv6" : "Neither";
        }

        return "Neither";
    }

    public boolean ipv4(String ip){
        String arr[] = ip.split("\\.",-1);
        for(String s : arr){
            if(s.length() == 0 || s.length() > 3)
                return false;
            if(s.charAt(0) == '0' && s.length() != 1)
                return false;
            //Only nums allowed
            for(char c : s.toCharArray()){
                if(!Character.isDigit(c))
                    return false;
            }
            int num = Integer.parseInt(s);
            if(num < 0 || num > 255)
                return false;
        }

        return true;
    }

    public boolean ipv6(String ip){
        String arr[] = ip.split(":",-1);
        HashSet<Character> allowed = new HashSet<>(Arrays.asList('a','b','c','d','e','f',
                                                                    'A','B','C','D','E','F',
                                                                    '0','1','2','3','4','5','6','7','8','9'));

        for(String s : arr){
            if(s.length() == 0 || s.length() > 4)
                return false;
            for(char c : s.toCharArray()){
                if(!allowed.contains(c)){
                    return false;
                }
            }
        }

        return true;

        
        
    }
}