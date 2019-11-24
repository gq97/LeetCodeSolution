import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LeetCode227_BasicCalculatorII {
    private Map<String, Integer> prior;
    public boolean isDigital(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public int calculate(String s) {
        prior = new HashMap<>();
        prior.put("+", 0);
        prior.put("-", 0);
        prior.put("/", 1);
        prior.put("*", 1);
        char[] str = s.toCharArray();
        Deque<String> queue = new LinkedList<>();
        for(int i = 0; i < s.length(); i++) {
            if(str[i] == ' ') {
                continue;
            } else if (str[i] >= '0' && str[i] <= '9') {
                int j = i, num = str[i] - '0';
                for(; j < s.length(); j++) {
                    try {
                        num = Integer.parseInt(s.substring(i, j+1));
                    } catch (NumberFormatException e) {
                        break;
                    }
                }
                queue.add("" + num);
                i = j-1;
            } else if(str[i] == '+' || str[i] == '-' || str[i] == '/' || str[i] == '*') {
                queue.add("" + str[i]);
            }
        }
        Deque<String> postExpression = new LinkedList<>();
        Deque<String> opStack = new LinkedList<>();
        while(!queue.isEmpty()) {
            String temp = queue.pop();
            if(isDigital(temp.charAt(0))) {
                postExpression.add(temp);
            } else {
                if(opStack.isEmpty() || prior.get(opStack.getLast()) < prior.get(temp)) {
                    opStack.add(temp);
                } else {
                    while(!opStack.isEmpty() && prior.get(opStack.getLast()) >= prior.get(temp)) {
                        postExpression.add(opStack.removeLast());
                    }
                    opStack.add(temp);
                }
            }
        }
        while(!opStack.isEmpty()) {
            postExpression.add(opStack.removeLast());
        }
        int result = 0, num = 0;
        Deque<Integer> numStack = new LinkedList<>();
        while(!postExpression.isEmpty()) {
            String temp = postExpression.pop();
            try {
                num = Integer.parseInt(temp);
            } catch(NumberFormatException e) {
                int num2 = numStack.removeLast();
                int num1 = numStack.removeLast();
                int tempResult = 0;
                if(temp.equals("+")) {
                    tempResult = num1 + num2;
                } else if(temp.equals("-")) {
                    tempResult = num1 - num2;
                } else if(temp.equals("*")) {
                    tempResult = num1 * num2;
                } else if(temp.equals("/")) {
                    tempResult = num1 / num2;
                } else {
                    return -1;
                }
                numStack.add(tempResult);
                continue;
            }
            numStack.add(Integer.parseInt(temp));
        }
        return numStack.isEmpty() ? 0 : numStack.pop();
    }
    public static void main(String[] args) {
        LeetCode227_BasicCalculatorII solution = new LeetCode227_BasicCalculatorII();
        System.out.println(solution.calculate("3+2*2"));
        System.out.println(solution.calculate(" 3/2 "));
        System.out.println(solution.calculate(" 3+5 / 2 "));
        System.out.println(solution.calculate("8+4-6*2"));
    }
}
