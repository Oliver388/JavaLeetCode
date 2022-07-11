package solution;

/**
 * @id 5
 * @author linglifan
 * @date 2022/07/02 12:53
 */
public class LongestPalindrome5 {
    /**
     * 暴力解法
     * 时间复杂度：O(n^3)
     * 空间复杂度：O(1)
     * @param s
     * @return
     */
    public String longestPalindrome(String s){
        int len = s.length();
        int maxlength = 1;
        int begin = 0;
        char[] chars = s.toCharArray();

        if (s == null || s.length()==0){
            return "";
        }
        if (len<2) return s;
        for (int i=0;i<len-1;i++){
            for (int j=i+1;j<len;j++){
                if (j-i+1 > maxlength && isPalindrome(chars,i,j)){
                    maxlength = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxlength);
    }

    /**
     * 判断以left和right为端点的串（包含）是否为回文串
     * @param s
     * @param left
     * @param right
     * @return
     */
    private boolean isPalindrome(char[] s,int left,int right){
        while (left<right){
            if (s[left] != s[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    /**
     * 中心扩展法，依次以每个点作为中心点，向两端扩展寻找最长的长度
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * @param s
     * @return
     */
    public String longestPalindromeMiddle(String s){
        int len = s.length();
        if (len<2) return s;

        int maxlength = 1;
        int begin = 0;
        char[] chars = s.toCharArray();

        for (int i=0;i<len-1;i++){
            int oddLength = longestPalindromeMiddle(chars,i,i);
            int evenLength = longestPalindromeMiddle(chars,i,i+1);
            int res = Math.max(oddLength,evenLength);
            if (res > maxlength){
                maxlength = res;
                begin = i - (maxlength - 1) / 2;
            }
        }
        return s.substring(begin,begin+maxlength);
    }

    /**
     * 返回以left和right为中心的最长回文长度
     * @param s
     * @param left
     * @param right
     * @return
     */
    private int longestPalindromeMiddle(char[] s,int left,int right){
        while (left>=0 && right<s.length && s[left] == s[right]){
            left--;
            right++;
        }
        return right - left - 1;// 退出while时，right和left已经不满足回文条件，因此返回的长度为(right - 1) - (left + 1) + 1 = right - left -1
    }


    /**
     * 动态规划
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n^2)
     * @param s
     * @return
     */
    public String longestPalindromeDP(String s){
        int len = s.length();
        if (len<2){
            return s;
        }
        // 状态dp[i][j]表示子串s[i...j]是否为回文子串
        // 状态转移方程dp[i][j] = s[i] == s[j] && dp[i + 1][j - 1]
        boolean[][] dp = new boolean[len][len];
        for (int z=0;z<len;z++){
            dp[z][z] = true;
        }

        int begin=0;
        int maxlength = 1;
        for (int j=1;j<len;j++){
            for (int i=0;i<j;i++){
                //新的状态不够成区间（长度小于2），dp[i + 1][j - 1]没有意义， j - 1 - (i + 1) + 1 < 2 = j - i < 3 = j - i + 1 < 4，即不用判断长度小于4的字符串（2或3）的子串是否为回文串
                if (s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1])){
                    dp[i][j] = true;
                    if (j-i+1 > maxlength){
                        maxlength = j-i+1;
                        begin =  i;
                    }
                }else{
                    dp[i][j] = false;

                }
            }
        }

        return s.substring(begin,begin+maxlength);
    }


    public static void main(String[] args) {
        LongestPalindrome5 LongestPalindrome5 = new LongestPalindrome5();
        System.out.println(LongestPalindrome5.longestPalindromeDP("cbbd"));
    }


}
