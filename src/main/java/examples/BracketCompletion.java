package examples;

import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author Lakith Dharmarathna
 * Date : 07/07/2022
 */
public class BracketCompletion {
    public static void main(String[] args) {
        String[] code = "{(([])[])[]]}".split("");
        Stack<String> stack = new Stack<>();

        for (String s : code) {

            if (stack.isEmpty() && isOpenBracket(s)) {
                stack.push(s);
            } else if (stack.isEmpty() && !isOpenBracket(s)) {
                stack.push(s);
                break;
            } else if (isOpenBracket(s)) {
                stack.push(s);
            } else if (s.equals(getClosingBracket(stack.peek()))) {
                stack.pop();
            }else{
                break;
            }
        }

        if (stack.isEmpty()) {
            System.out.println("balanced");
        } else {
            System.out.println("Unbalanced");
        }

    }

    static boolean isOpenBracket(String bracket) {
        return List.of("{", "[", "(").contains(bracket);
    }

    static String getClosingBracket(String bracket) {
        return Map.of("(", ")", "{", "}", "[", "]").get(bracket);
    }
}
