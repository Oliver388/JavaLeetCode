package solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author linglifan
 * @date 2023/01/18 14:06
 */
public class lc17 {
    List<String> result = new ArrayList<>();
    StringBuilder temp = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){
            return result;
        }

        String[] list = {"","","abc","def","ghi","jkl","mno","pqrs", "tuv", "wxyz"};
        helper(digits,list,0);
        return result;
    }

    //这个num代表的是digits里面的第几位 例如"23" num=0代表digits里面第0位2
    public void helper(String digits,String[] list,int num){
        if (num == digits.length()){
            result.add(temp.toString());
            return;
        }

        char c = digits.charAt(num);
        String s = String.valueOf(c);
        String current = list[Integer.parseInt(s)];
        for (int i=0;i<current.length();i++){
            temp.append(current.charAt(i));
            helper(digits,list,num+1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public static void main(String[] args) {
        lc17 lc17 = new lc17();
        List<String> strings = lc17.letterCombinations("23");
        System.out.println(strings);
    }
}
