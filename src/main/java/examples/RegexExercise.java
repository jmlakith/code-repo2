package examples;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Lakith Dharmarathna
 * Date : 12/07/2022
 */
public class RegexExercise {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^\\/(?<userId>\\d+)\\/login$");
        String str = "/123/login";
        Matcher matcher = pattern.matcher(str);

        System.out.println(matcher.find()?matcher.group("userId"):"");


    }
}
