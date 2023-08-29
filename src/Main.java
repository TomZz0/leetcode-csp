import java.util.Scanner;
import java.util.Stack;

/**
 * @author wzh
 * @date 2023年06月11日 15:08
 * Description:读取一串字符，不超过100个字符，可能包括括号、数字、字母、标点符号、空格，编程检查这一串字符中的( ) ,[ ],{ }是否匹配。
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();//读入的字符串
        Stack<Character> s1 = new Stack<>();//存储括号的栈
        Stack<Character> s2 = new Stack<>();
        int index = 0;//遍历读入字符串的下标
        char ch;//遍历字符串的每一个字符、后边出栈的每一个括号
        while (index < s.length()) {//将读取到的输入中所有括号入栈
            ch = s.charAt(index);
            if (isBracket(ch))   s1.push(ch); //如果是括号 入栈
            index++;
        }
        while (!s1.isEmpty()) {//s1出栈，进行判断
            char pop = s1.pop();
            if (!s1.isEmpty()&&match(pop, s1.peek())) {
                s1.pop();//与s1栈顶匹配 s1出栈
            } else if (!s2.isEmpty()&&match(s2.peek(),pop)) {
                s2.pop();//与s2栈顶匹配 s2出栈
            } else {
                s2.push(pop);// 都不匹配 放入s2
            }
        }
        if (s2.isEmpty()) System.out.println("yes");
        else System.out.println("no");
    }

    /**
     * 判断字符是否是括号，在判断弹出的右括号是否与s1匹配时，将pop做ch1传入；
     * 在判断弹出的右括号是否与s2匹配时，将pop做ch2传入。仅仅只需把转入参数的相对位置改变一下就可以完成主函数需要的比较功能。
     * @param ch1 括号1
     * @param ch2 括号2
     * @return 是否匹配
     */
    static boolean match(char ch1, char ch2) {
        return  (ch2 == '(' && ch1 == ')')
                ||(ch2 == '[' && ch1 == ']')
                || (ch2 == '{' && ch1 == '}');
    }

    /**
     * 判断ch是否为括号
     * @param ch 待判断的字符
     * @return 返回true 或 false
     */
    static boolean isBracket(char ch){
        return ch == '(' || ch==')' || ch == '[' || ch == ']' || ch =='{' || ch == '}';
    }
}