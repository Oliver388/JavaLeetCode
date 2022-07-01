package solution;

import java.util.ArrayList;

public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        ArrayList<Character> temp = new ArrayList<Character>();
        for(int i=0;i<s.length();i++){
            if(temp.contains(s.charAt(i))){
                max = Math.max(temp.size(),max);
                while(temp.get(0) != s.charAt(i)){
                    temp.remove(0);
                }
                temp.remove(0);

            }
            temp.add(s.charAt(i));


        }

        max = Math.max(max,temp.size());
        return max;
    }

    public static void main(String[] args) {

    }
}
