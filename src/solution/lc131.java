package solution;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

/**
 * @author linglifan
 * @date 2023/01/28 13:44
 */
public class lc131 {
    List<List<String>> result = new ArrayList<>();
    List<String> temp = new ArrayList<>();
    public List<List<String>> partition(String s) {
        helper(s,0);
        return result;
    }

    public void helper(String s,int startIndex){
        if (startIndex >= s.length()){
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s,startIndex,i)){//是回文字符串
                String str = s.substring(startIndex,i+1);
                temp.add(str);
            }else {
                continue;
            }
            helper(s,i+1);
            temp.remove(temp.size()-1);
        }

    }

    private boolean isPalindrome(String s,int left,int right){
        for (int i = left,j=right;i<j;i++,j--){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
