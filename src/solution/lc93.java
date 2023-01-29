package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author linglifan
 * @date 2023/01/28 15:05
 */
public class lc93 {
    List<String> result = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        helper(s,0,0);
        return result;
    }

    private void helper(String s,int startIndex,int pointNum){
        if (pointNum == 3){
            //判断第四段子字符串是否合法，如果合法就放进result中
            if (isValid(s,startIndex,s.length()-1)){
                result.add(s);
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isValid(s,startIndex,i)){
                s = s.substring(0, i + 1) + '.' + s.substring(i + 1);
                pointNum++;
                helper(s,i+2,pointNum);
                pointNum--;
                s = s.substring(0, i + 1) + s.substring(i + 2);
            }else {
                break;
            }
        }
    }


    private boolean isValid(String s, int start, int end) {
        if (start > end){
            return false;
        }
        if (s.charAt(start) == '0' && start != end){
            return false;
        }

        int sum = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') return false;
            sum = sum * 10 + (s.charAt(i) - '0');
            if (sum < 0 || sum > 255) return false;
        }
        return true;
    }
}
