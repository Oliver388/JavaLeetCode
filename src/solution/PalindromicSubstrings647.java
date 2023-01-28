package solution;

/**
 * 中心扩散法
 * @author linglifan
 * @date 2022/09/18 13:45
 */
public class PalindromicSubstrings647 {
    int number = 0;
    public int countSubstrings(String s) {
        for (int i=0;i< s.length();i++){
            count(s,i,i);
            count(s,i,i+1);

        }
        return number;
    }

    public void count(String s,int start,int end){
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            number++;
            start--;
            end++;
        }
    }
}
