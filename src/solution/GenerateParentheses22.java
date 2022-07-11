package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Deflater;

/**
 * @id 22
 * @author linglifan
 * @date 2022/07/09 22:04
 */
public class GenerateParentheses22 {

    List<String> res = new ArrayList<>();

    /**
     * 回溯算法
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        if (n <= 0) return null;
        dfs("",0,0,n);
        return res;
    }

    private void dfs(String path,int left,int right,int n){
        if (left > n || right > left){
            return;
        }
        if (path.length() == n*2){
            res.add(path);
            return;
        }
        dfs(path+"(",left+1,right,n);
        dfs(path+")",left,right+1,n);
    }

    public static void main(String[] args) {
        GenerateParentheses22 generateParentheses22 = new GenerateParentheses22();
        List<String> strings = generateParentheses22.generateParenthesis(3);
        for (String s :
                strings) {
            System.out.println(s);
        }
    }
}
