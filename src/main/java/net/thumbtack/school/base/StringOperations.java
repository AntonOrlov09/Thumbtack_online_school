package net.thumbtack.school.base;

public class StringOperations {

    public static int getSummaryLength(String[] strings) {
        int summaryLength = 0;
        for (String string : strings) {
            summaryLength += string.length();
        }
        return summaryLength;
    }

    public static String getFirstAndLastLetterString(String string) {
        return string.substring(0, 1) + string.substring(string.length() - 1);
    }

    public static boolean isSameCharAtPosition(String string1, String string2, int index) {
        return string1.charAt(index) == string2.charAt(index);
    }

    public static boolean isSameFirstCharPosition(String string1, String string2, char character) {
        return string1.indexOf(character) == string2.indexOf(character);
    }

    public static boolean isSameLastCharPosition(String string1, String string2, char character) {
        return string1.lastIndexOf(character) == string2.lastIndexOf(character);
    }

    public static boolean isSameFirstStringPosition(String string1, String string2, String str) {
        return string1.indexOf(str) == string2.indexOf(str);
    }

    public static boolean isSameLastStringPosition(String string1, String string2, String str) {
        return string1.lastIndexOf(str) == string2.lastIndexOf(str);
    }

    public static boolean isEqual(String string1, String string2) {
        return string1.equals(string2);
    }

    public static boolean isEqualIgnoreCase(String string1, String string2) {
        return string1.equalsIgnoreCase(string2);
    }

    public static boolean isLess(String string1, String string2) {
        return string1.compareTo(string2) < 0;
    }

    public static boolean isLessIgnoreCase(String string1, String string2) {
        return string1.compareToIgnoreCase(string2) < 0;
    }

    public static String concat(String string1, String string2) {
        return string1.concat(string2);
    }

    public static boolean isSamePrefix(String string1, String string2, String prefix) {
        return string1.startsWith(prefix) && string2.startsWith(prefix);
    }

    public static boolean isSameSuffix(String string1, String string2, String suffix) {
        return string1.endsWith(suffix) && string2.endsWith(suffix);
    }

    public static String getCommonPrefix(String string1, String string2) {
        int count = 0;
        int minLength = Math.min(string1.length(), string2.length());
        for (int i = 0; i < minLength; i++) {
            if ((string1.charAt(i)) == (string2.charAt(i))) {
                count++;
            } else {
                break;
            }
        }
        return string1.substring(0, count);
    }

    public static String reverse(String string) {
        String reverseString = "";
        for (int i = 0; i < string.length(); i++) {
            reverseString = string.charAt(i) + reverseString;
        }
        return reverseString;
    }

    public static boolean isPalindrome(String string) {
        for (int i = 0; i < string.length() / 2; i++) {
            if (string.charAt(i) != string.charAt(string.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeIgnoreCase(String string) {
        return string.equalsIgnoreCase(reverse(string));
    }

    public static String getLongestPalindromeIgnoreCase(String[] strings) {
        String longestPalindromeIgnoreCase = "";
        for (String string : strings) {
            if ((isPalindromeIgnoreCase(string)) && (string.length() > longestPalindromeIgnoreCase.length())) {
                longestPalindromeIgnoreCase = string;
            }
        }
        return longestPalindromeIgnoreCase;
    }

    public static boolean hasSameSubstring(String string1, String string2, int index, int length) {
        if ((length > string1.length() - index) || (length > string2.length() - index)) {
            return false;
        } else {
            return string1.substring(index, index + length).equals(string2.substring(index, index + length));
        }
    }

    public static boolean isEqualAfterReplaceCharacters(String string1, char replaceInStr1, char replaceByInStr1, String string2, char replaceInStr2, char replaceByInStr2) {
        return string1.replace(replaceInStr1, replaceByInStr1).equals(string2.replace(replaceInStr2, replaceByInStr2));
    }

    public static boolean isEqualAfterReplaceStrings(String string1, String replaceInStr1, String replaceByInStr1, String string2, String replaceInStr2, String replaceByInStr2) {
        return string1.replace(replaceInStr1, replaceByInStr1).equals(string2.replace(replaceInStr2, replaceByInStr2));
    }

    public static boolean isPalindromeAfterRemovingSpacesIgnoreCase(String string) {
        return isPalindromeIgnoreCase(string.replace(" ", ""));
    }

    public static boolean isEqualAfterTrimming(String string1, String string2) {
        return string1.trim().equals(string2.trim());
    }

    public static String makeCsvStringFromInts(int[] array) {
        return makeCsvStringBuilderFromInts(array).toString();
    }

    public static String makeCsvStringFromDoubles(double[] array) {
        return makeCsvStringBuilderFromDoubles(array).toString();
    }

    public static StringBuilder makeCsvStringBuilderFromInts(int[] array) {
        StringBuilder sb = new StringBuilder("");
        if (array.length == 0) {
            return sb;
        }
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(",");
            }
        }
        return sb;
    }

    public static StringBuilder makeCsvStringBuilderFromDoubles(double[] array) {
        StringBuilder sb = new StringBuilder();
        if (array.length == 0) {
            return sb;
        }
        for (int i = 0; i < array.length; i++) {
            sb.append(String.format("%.2f", array[i]));
            if (i < array.length - 1) {
                sb.append(",");
            }
        }
        return sb;
    }

    public static StringBuilder removeCharacters(String string, int[] positions) {
        StringBuilder sb = new StringBuilder(string);
        for (int i = 0; i < positions.length; i++) {
            sb.deleteCharAt(positions[i] - i);
        }
        return sb;
    }

    public static StringBuilder insertCharacters(String string, int[] positions, char[] characters) {
        StringBuilder sb = new StringBuilder(string);
        for (int i = 0; i < positions.length; i++) {
            sb.insert(positions[i] + i, characters[i]);
        }
        return sb;
    }

}
