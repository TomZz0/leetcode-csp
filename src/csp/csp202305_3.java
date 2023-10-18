package csp;

import java.util.Scanner;

/**
 * @author wzh
 * @date 2023年09月02日 9:59
 * Description:
 */
public class csp202305_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = Integer.parseInt( in.nextLine());
        int x = 0;
        int index = 0;
        boolean flag = true;
        int orilen = 0;
        int outNum = 0;
        StringBuilder s = new StringBuilder();
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.isEmpty()) {
                break; // 遇到空行时停止读取
            }
            s.append(line);
        }

        //处理得到引导区原始数据长度
        while (true) {
            char a = s.charAt(index++);
            char b = s.charAt(index++);
            String bin = trans(a, b);
            orilen += cal(bin.substring(1)) * (int) Math.pow(128, x);
            if (bin.charAt(0) == '0') break;
            x++;
        }
        while (index<s.length() && outNum < orilen) {
            char a = s.charAt(index++);
            char b = s.charAt(index++);
            String bin = trans(a, b);
            int pos = bin.length() - 2;
            String last2 = bin.substring(pos);
            if (last2.equals("00")) {
                int len = cal(bin.substring(0, pos));
                if (len + 1 <= 60) {
                    //len+1 就是字节数 输出即可
                    for (int i = 1; i <= len + 1; i++) {
                        System.out.print(s.charAt(index++));
                        System.out.print(s.charAt(index++));
                        outNum++;
                        if (outNum % 8 == 0) System.out.print('\n');
                    }
                } else {
                    int v = 0;
                    int numOfByte = len + 1 - 60;
                    for (int i = 0; i < numOfByte; i++) {
                        a = s.charAt(index++);
                        b = s.charAt(index++);
                        String trans = trans(a, b);
                        int cal = cal(trans);
                        v += cal;
                    }
                    for (int i = 1; i <= v + 1; i++) {
                        System.out.print(s.charAt(index++));
                        System.out.print(s.charAt(index++));
                        outNum++;
                        if (outNum % 8 == 0) System.out.print('\n');
                    }
                }
            }else {
                break;
            }
        }
    }

    private static int cal(String substring) {
        int res = 0;
        int len = substring.length() - 1;
        for (int i = len; i >= 0; i--) {
            if (substring.charAt(i) == '1') res += (int) Math.pow(2, len - i);
        }
        return res;
    }

    private static String trans(char a, char b) {
        StringBuilder sb = new StringBuilder();
        int res = (a >= '0' && a <= '9' ? a - '0' : a - 'a' + 10) * 16 + (b >= '0' && b <= '9' ? b - '0' : b - 'a' + 10);
        int x = 7;
        while (x >= 0) {
            if (res >= (int) Math.pow(2, x)) {
                res -= (int) Math.pow(2, x);
                sb.append('1');
            } else sb.append('0');
            x--;
        }
        return sb.toString();
    }
}
