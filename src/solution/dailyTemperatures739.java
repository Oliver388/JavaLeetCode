package solution;

import sun.util.resources.en.LocaleNames_en_SG;

import java.util.ArrayDeque;

/**
 * @author linglifan
 * @date 2022/10/06 09:38
 */
public class dailyTemperatures739 {
    /**
     * 暴力双重循环
     * @param temperatures
     * @return
     */
//    public int[] dailyTemperatures(int[] temperatures) {
//        int[] answer = new int[temperatures.length];
//        for (int i=0;i < temperatures.length;i++){
//            for (int j = i+1;j<temperatures.length;j++){
//                if (temperatures[j] > temperatures[i]){
//                    answer[i] = j-i;
//                    break;
//                }
//            }
//        }
//        return answer;
//    }


    /**
     * 单调栈
     */
    public int[] dailyTemperatures(int[] temperatures){
        int len = temperatures.length;
        int[] answer = new int[len];

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        for (int i=0;i<len;i++){
            if (temperatures[i] <= temperatures[stack.peek()]){
                stack.push(i);
            }else {
                while (!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                    answer[stack.peek()] = i-stack.peek();
                    stack.pop();

                }
                stack.push(i);
            }
        }
        return answer;
    }
}
