package solution;

import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

    /**
     * https://www.codewars.com/kata/52f78966747862fc9a0009ae/train/java
     * https://pt.wikipedia.org/wiki/Nota%C3%A7%C3%A3o_polonesa_inversa
     * */

    private static double operation(String op, double a, double b) {
        if (op.equals("+")) {
            return a + b;
        }
        else if (op.equals("-")) {
            return a - b;
        }
        else if (op.equals("*")) {
            return a * b;
        }
        return a / b;
    }

    private static boolean isNumeric(String num)  {
        try {
            Double.parseDouble(num);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private static double evaluate(String expr) {
        // TODO: Your awesome code here
        if (expr.length() == 0)
            return 0;
        Stack<Double> operands = new Stack<>();
        StringTokenizer tk = new StringTokenizer(expr, " ");
        while (tk.hasMoreTokens()) {
            String t = tk.nextToken();
            if (isNumeric(t)) {
                operands.add(Double.parseDouble(t));
            }
            else if (! t.equals(" ")){
                double a = operands.pop();
                double b = operands.pop();
                double acc = operation(t, b, a);
                operands.add(acc);
            }
        }
        return operands.pop();
    }


    private static double reversePolishNotation(String expr) {
        if (expr.isEmpty())
            return 0.0;
        Stack<Double> operands = new Stack<>();
        Stack<String> operators = new Stack<>();

        for (char c : expr.toCharArray()) {
            boolean pendingOperand = true;
            if ( ! Character.isDigit(c) && c == ' ') {
                operators.add(String.valueOf(c));
                pendingOperand = false;
            }
            else {
                double p = Double.parseDouble(String.valueOf(c));
                if (pendingOperand) {
                    while (!operands.empty()) {
                        double q = operands.pop();
                        String op = operators.pop();
                        p = operation(op, q, p);
                    }
                }
                operands.push(p);
                pendingOperand = true;
            }
        }
        return operands.pop();
    }

    public static void main(String[] args) {
        System.out.println(evaluate("1 3 - 0 +"));
        System.out.println(evaluate("1 3 +"));
        System.out.println(evaluate("1 2 3.5"));
        System.out.println(evaluate("5 1 2 + 4 * + 3 -"));
        System.out.println(evaluate("6 2 3 + - 3 8 2 / + * 2 5 3 +"));
        System.out.println(evaluate("1 2 + 4 * 3 -"));
        System.out.println(evaluate(""));
        System.out.println(evaluate("1 2 3"));
        System.out.println(evaluate("1 3 -"));
        System.out.println(evaluate("4 2 /"));
    }
}
