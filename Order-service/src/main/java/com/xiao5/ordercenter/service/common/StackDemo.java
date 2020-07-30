package com.xiao5.ordercenter.service.common;

import java.util.Stack;

/**
 * @author Wu Tianbing
 * @version V1.0
 * @Description:
 * @className: StackDem
 * @date 2020/7/30/030 11:06
 * @company:西安博达软件股份有限公司
 * @copyright: Copyright (c) 2020
 */
public class StackDemo {

    /**
        给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
        有效字符串需满足：左括号必须与相同类型的右括号匹配，左括号必须以正确的顺序匹配。
        例如，{ [ ( ) ( ) ] } 是合法的，而 { ( [ ) ] } 是非法的。
    */
    public static void main(String[] args) {
        String ss = "{}{}{}{()[]}";
        System.out.println(checkPers(ss));
    }

    /**
     * 校验左边括号
     * @author Wu Tianbing
     * @date 2020-07-30 11:09
     * @param c
     * @return int
     */
    private static int isLeft(char c){
        if (c == '{' || c == '[' || c == '('){
            return 1;
        }
        return 0;
    }

    /**
     * 校验右边括号
     * @author Wu Tianbing
     * @date 2020-07-30 11:14
     * @param p	
     * @param curr	
     * @return int
     */ 
    private static int isPair(char p, char curr){
        if ((p == '{' && curr == '}') || (p == '[' && curr == ']') || (p == '(' && curr == ')')){
            return 1;
        }
        return 0;
    }

    /**
     * 校验
     * @author Wu Tianbing
     * @date 2020-07-30 11:19
     * @param ss
     * @return java.lang.String
     */
    private static String checkPers(String ss){
        Stack stack = new Stack();
        for (int i = 0; i < ss.length(); i ++){
            char curr = ss.charAt(i);
            if (isLeft(curr) == 1){
                stack.push(curr);
            }else {
                if (stack.empty()){
                    return "非法";
                }
                char p = (char) stack.pop();
                if (isPair(p,curr) == 0){
                    return "非法";
                }
            }
        }
        if (stack.empty()){
            return "合法";
        }else {
            return "非法";
        }
    }


}
