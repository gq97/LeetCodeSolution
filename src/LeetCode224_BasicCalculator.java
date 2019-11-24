import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class LeetCode224_BasicCalculator {
    public boolean isDigital(char ch) {
        return ch >= '0' && ch <= '9';
    }
    public int calculate2(String s) {
        char[] str = s.toCharArray();
        char lastSign = '+';
        boolean isNeg = false;
        Deque<Boolean> isBracketNeg = new LinkedList<>();
        int result = 0;
        for(int i = 0; i < str.length; i++) {
            if(isDigital(str[i])) {
                int num = 0;
                while(i < str.length && isDigital(str[i])) {
                    num = num * 10 + str[i] - '0';
                    i++;
                }
                if(isBracketNeg.isEmpty() || !isNeg) {
                    if(lastSign == '+') {
                        result += num;
                    } else if(lastSign == '-') {
                        result -= num;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                } else {
                    if(lastSign == '+') {
                        result -= num;
                    } else if(lastSign == '-') {
                        result += num;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                }
                i--;
            } else if(str[i] == '+' || str[i] == '-') {
                lastSign = str[i];
            } else if(str[i] == '(') {
                if(lastSign == '+') {
                    isBracketNeg.add(false);
                } else if(lastSign == '-') {
                    isBracketNeg.add(true);
                    isNeg = !isNeg;
                }
                lastSign = '+';
            } else if(str[i] == ')') {
                if(isBracketNeg.removeLast() == true) {
                    isNeg = !isNeg;
                }
            }
        }
        return result;
    }
    public int calculate(String s) {
        int len = s.length(), sign = 1, result = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                int sum = s.charAt(i) - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    sum = sum * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                result += sum * sign;
            } else if (s.charAt(i) == '+')
                sign = 1;
            else if (s.charAt(i) == '-')
                sign = -1;
            else if (s.charAt(i) == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                result = result * stack.pop() + stack.pop();
            }

        }
        return result;
    }
}