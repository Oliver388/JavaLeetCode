package solution;

import com.sun.org.apache.bcel.internal.generic.DALOAD;

import java.awt.event.FocusEvent;

/**
 * @author linglifan
 * @date 2022/09/01 12:51
 */
public class WordSearch79 {
    /**
     * 思路：
     * 1. 遍历board，找到与word首字母匹配的元素
     * 2. 回溯法分别从上、左、下、右四个方向探索board元素与word的下一位字母匹配
     * 3. 只要一个方向成功，就返回成功
     * @param board
     * @param word
     * @return
     */
    boolean flag = false;
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                boolean flag = check(board,word,0,i,j,visited);
                if (flag) return true;
            }
        }
        return false;
    }

    public boolean check(char[][] board,String word,int stringIndex,int rowIndex,int colIndex,boolean[][] visited){
        if (board[rowIndex][colIndex] != word.charAt(stringIndex)){
            return false;
        }else if (stringIndex == word.length()-1){//如果已经访问到字符串的末尾依然匹配，那么返回true
            return true;
        }
        //上述条件都不成立，那么当前这个格子是和单词的某一位是一样的是成立的
        visited[rowIndex][colIndex] = true;
        //用作方向
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] direction : directions) {
            int newRowIndex = rowIndex + direction[0],newColIndex = colIndex + direction[1];
            if (newRowIndex >=0 && newRowIndex < board.length && newColIndex >=0 && newColIndex < board[0].length){
                if (!visited[newRowIndex][newColIndex]){
                    boolean flag = check(board,word,stringIndex + 1,newRowIndex,newColIndex,visited);
                    if (flag){
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[rowIndex][colIndex] = false;
        return result;
    }

    public static void main(String[] args) {
        WordSearch79 wordSearch79 = new WordSearch79();
    }
}
