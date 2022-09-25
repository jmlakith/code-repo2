package amazon.nagarroInterviews;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Stack;

/**
 * @author Lakith Dharmarathna
 * Date : 26/07/2022
 */
public class StackExercise {

    private static Map<String, String> brackets = Map.of("(", ")", "{", "}", "[", "]");

    public static void main(String[] args) {

        String inputStr = "{}[]{}";

        Deque<String> stack = new ArrayDeque<>();

        for (String str : inputStr.split("")) {
            if (stack.isEmpty() && !isOpenBracket(str)) {
                break;
            } else if (isOpenBracket(str)) {
                stack.push(str);
            } else if (matchBracket(stack.peek(), str)) {
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            System.out.println("Balanced");
        } else {
            System.out.println("Unbalanced");
        }

    }

    private static boolean matchBracket(String peek, String str) {
        return str.equals(brackets.get(peek));
    }

    private static boolean isOpenBracket(String str) {
        return brackets.containsKey(str);
    }

}
