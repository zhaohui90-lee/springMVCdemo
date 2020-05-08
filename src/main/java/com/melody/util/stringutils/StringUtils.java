package com.melody.util.stringutils;

/**
 * @Author: melody
 * @Date: 2020-04-29
 */
public class StringUtils {
    public static void main(String[] args) {
        String mongo = "mango";
        String s = "abc" + mongo + "def" + 47;
        System.out.println(s);

        int x = 5;
        double y = 0.1565156;
        System.out.printf("Row 1: [%d %f]\n",x,y);


    }

    public String implicit(String[] fields){
        StringBuilder result = new StringBuilder();
        for (String field : fields) {
            result.append(field);
        }
        return result.toString();
    }


}
