package solution;

import java.util.ArrayList;

/**
 * @id 3
 * @author linglifan
 * @date 2022/07/01
 */
public class LongestSubstring {

    /**
     * 本质上就是维护一个list集合，如果新加入集合的字符之前出现过，那么就从头去掉元素直至重复的那个字符
     * 时间复杂度: O(N),便利一遍字符串
     * 空间复杂度：O(字符集大小)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        ArrayList<Character> temp = new ArrayList<Character>();
        for(int i=0;i<s.length();i++){
            if(temp.contains(s.charAt(i))){

                max = Math.max(temp.size(),max);//遇到新加进来的字符之前存在过集合，那么就要先判断一下最长长度
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
        LongestSubstring longestSubstring = new LongestSubstring();
        System.out.println();
    }
}
