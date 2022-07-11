package solution;

/**
 * @id 28
 * @author linglifan
 * @date 2022/07/11 14:26
 */
public class ImplementstrStr28 {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        int h = haystack.length(),n = needle.length();
        int rst = 0;
        for (int i=0;i<=h-n;i++){//必须要明白这个i的意思是与needle相同的字符串的第一个位置，而不是haystack的索引，不能小于h
            boolean flag = true;
            for (int j=0;j<n;j++){//heell ll
                if (haystack.charAt(i+j) != needle.charAt(j)){
                    flag = false;
                    break;
                }
            }
            if (flag){
                return i;
            }
        }
        return -1;
    }

}
