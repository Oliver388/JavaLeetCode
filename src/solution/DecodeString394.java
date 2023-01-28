package solution;

import java.time.OffsetDateTime;
import java.util.ArrayDeque;

/**
 * @author linglifan
 * @date 2022/10/02 09:44
 */
public class DecodeString394 {
    public String decodeString(String s) {
        ArrayDeque<StringBuilder> stack = new ArrayDeque<>();
        ArrayDeque<Integer> numStack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for (int i=0;i<s.length();i++){
            if (Character.isDigit(s.charAt(i))){
                num = num * 10 + s.charAt(i) - '0';
            }else if (s.charAt(i) == '['){
                numStack.push(num);
                num = 0;
                stack.push(sb);
                sb = new StringBuilder();
            }else if (Character.isLetter(s.charAt(i))){
                sb.append(s.charAt(i));
            }else {
                //如果遇到的是右括号']'，那么先弹出数字，再弹出之前存在stack里面的字符串（即左括号之前的字符串），
                //将弹出的字符串根据次数（numstack弹出的数字）后面添加括号内的字符串相应的次数，括号内的字符串是sb；
                int times = numStack.pop();
                StringBuilder temp = stack.pop();
                for (int j=0;j<times;j++){
                    temp.append(sb);
                }
                //这个sb之后也能添加的stack里面
                sb = temp;
            }
        }
        return sb.toString();
    }
}
