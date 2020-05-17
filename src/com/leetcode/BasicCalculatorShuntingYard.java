package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 224. Basic Calculator
 * https://leetcode.com/problems/basic-calculator/
 */
public class BasicCalculatorShuntingYard {

    public static int calculate(String s) {
        int r = evalRPN(infixToPostfix(s.replaceAll(" ","")));
        return r;
    }

    /**
     * Parsing/RPN calculator algorithm
     * https://rosettacode.org/wiki/Parsing/RPN_calculator_algorithm#Java_2
     * @param exprlist
     */
    private static int evalRPN(List<String> exprlist){
        LinkedList<Integer> stack = new LinkedList<Integer>();
        System.out.println("Input\tOperation\tStack after");

        for (String token : exprlist) {
            System.out.print(token+"\t");
            Integer tokenNum = null;
            try{
                tokenNum = Integer.parseInt(token);
            }catch(NumberFormatException e){}
            if(tokenNum != null){
                System.out.print("Push\t\t");
                stack.push(Integer.parseInt(token+""));
            }else if(token.equals("*")){
                System.out.print("Operate\t\t");
                int secondOperand = stack.pop();
                int firstOperand = stack.pop();
                stack.push(firstOperand * secondOperand);
            }else if(token.equals("/")){
                System.out.print("Operate\t\t");
                int secondOperand = stack.pop();
                int firstOperand = stack.pop();
                stack.push(firstOperand / secondOperand);
            }else if(token.equals("-")){
                System.out.print("Operate\t\t");
                int secondOperand = stack.pop();
                int firstOperand = stack.pop();
                stack.push(firstOperand - secondOperand);
            }else if(token.equals("+")){
                System.out.print("Operate\t\t");
                int secondOperand = stack.pop();
                int firstOperand = stack.pop();
                stack.push(firstOperand + secondOperand);
            }else if(token.equals("^")){
                System.out.print("Operate\t\t");
                int secondOperand = stack.pop();
                int firstOperand = stack.pop();
                stack.push(new Double(Math.pow(firstOperand, secondOperand)).intValue());
            }else{//just in case
                System.out.println("Error");
                return 0;
            }
            System.out.println(stack);
        }
        int r = stack.pop();
        System.out.println("Final answer: " + r);
        return r;
    }

    /**
     * Parsing/Shunting-yard algorithm
     * https://rosettacode.org/wiki/Parsing/Shunting-yard_algorithm#Java
     * @param infix
     * @return
     */
    private static List<String> infixToPostfix(String infix) {
        /* To find out the precedence, we take the index of the
           token in the ops string and divide by 2 (rounding down).
           This will give us: 0, 0, 1, 1, 2 */
        List<String> list = new ArrayList<String>();
        final String ops = "-+/*^";

        Stack<Integer> stack = new Stack<Integer>();

        StringTokenizer st = new StringTokenizer(infix,"[\\^\\*\\+\\-/()]",true);
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (token.isEmpty())
                continue;
            char c = token.charAt(0);
            int idx = ops.indexOf(c);

            // check for operator
            if (idx != -1) {
                if (stack.isEmpty())
                    stack.push(idx);

                else {
                    while (!stack.isEmpty()) {
                        int prec2 = stack.peek() / 2;
                        int prec1 = idx / 2;
                        if (prec2 > prec1 || (prec2 == prec1 && c != '^'))
                            list.add( ops.charAt(stack.pop()) + "" );
                        else break;
                    }
                    stack.push(idx);
                }
            }
            else if (c == '(') {
                stack.push(-2); // -2 stands for '('
            }
            else if (c == ')') {
                // until '(' on stack, pop operators.
                while (stack.peek() != -2)
                    list.add( ops.charAt(stack.pop())+"" );
                stack.pop();
            }
            else {
                list.add( token );
            }
        }
        while (!stack.isEmpty())
            list.add( ops.charAt(stack.pop())+"" );
        return list;
    }

    public static void main(String[] args) {
//        String infix = "1 + 1".replaceAll(" ","");
//        String infix = " 2-1 + 2 ".replaceAll(" ","");
//        System.out.printf("infix:   %s%n", infix);
//        List<String> exprlist = infixToPostfix(infix);
//        System.out.printf("postfix: %s%n", exprlist.stream().map(Object::toString).collect(Collectors.joining(" ")));

//        String s = "1 + 1";
//        String s = " 2-1 + 2 ";
//        String s = "(1+(4+5+2)-3)+(6+8)";
        String s = "3 + 4 * 2 / ( 1 - 5 ) ^ 2 ^ 3";
        System.out.println( s + " = " + calculate(s) );
    }
}
