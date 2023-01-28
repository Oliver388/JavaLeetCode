package solution;

import java.text.BreakIterator;
import java.util.List;

/**
 * @author linglifan
 * @date 2022/09/05 18:49
 */
public class WordBreak139 {
    /**
     * 动态规划 背包问题
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        //judge[i]表示索引[0,i-1]的字符串是否可以被wordDict拆分
        boolean[] judge = new boolean[n+1];
        judge[0] = true;
        for (int i=1;i<=n;i++){
            for (int j=0;j<i;j++){
                // [0, i] 的字符串可被拆分，当前仅当任一子串 [0, j] 及 [j, i] 可被拆分
                if (judge[j] && wordDict.contains(s.substring(j,i))){
                    judge[i] = true;
                    break;
                }
            }
        }
        return judge[n];

    }

    public static void main(String[] args) {
        WordBreak139 wordBreak139 = new WordBreak139();

    }
}
