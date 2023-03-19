package fr.istic.vv;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils
{
    private StringUtils() {}

    /**
     * Checks if the string has matching opening and closing brackets
     *
     * @param str input string to test
     * @return true if all {, [ or ( symbols have their matching }, ], ) symbols (and not overlapping)
     */
    public static boolean isBalanced(String str)
    {
        if (str == null)
        {
            return true;
        }

        String onlySymbols = str.replaceAll("([^\\{\\[\\(\\)\\]\\}])", "");

        String noMatchingClosed = onlySymbols;

        Pattern p = Pattern.compile("(\\(\\))|(\\[\\])|(\\{\\})");
        Matcher m = p.matcher(onlySymbols);

        while (m.find())
        {
            noMatchingClosed = m.replaceAll("");
            m = p.matcher(noMatchingClosed);
        }

        return noMatchingClosed.isEmpty();
    }
}