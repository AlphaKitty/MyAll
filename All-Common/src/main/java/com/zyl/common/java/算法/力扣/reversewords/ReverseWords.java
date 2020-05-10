package com.zyl.common.java.算法.力扣.reversewords;

/**
 * "asdf asdf   sdgsde " => "sdgsde asdf asdf"
 */
public class ReverseWords {
    public static void main(String[] args) {
        // List<String> strings = Arrays.asList(input.trim().split(" +"));
        // Collections.reverse(strings);
        // String result = String.join(" ",strings);
        // System.out.println(result);

        String input = "asdf asdf   sdgsde ";
        input = " " + input;

        ReverseWords reverseWords = new ReverseWords();
        char[] inputCharArray = input.toCharArray();
        int length = input.length() - 1;
        // 翻转字符数组
        reverseWords.reverse(inputCharArray, 0, length);
        // 翻转单词
        int end = reverseWords.wordReversePlus(inputCharArray, length);
        // 去掉尾部空格
        String result = new String(inputCharArray).substring(0, end - 1);
        System.out.println(result);

    }

    // private void removeSpaces(char[] reversedCharArray, int n) {
    //     int i = 0;
    //     while (i < n) {
    //         if (reversedCharArray[i] == ' ' && reversedCharArray[i + 1] == ' ')
    //
    //     }
    // }

    private void wordReverse(char[] reversedCharArray, int n) {
        int i = 0, begin;
        while (i < n) {
            while (i < n && reversedCharArray[i] == ' ')
                i++;
            begin = i;
            while (i < n && reversedCharArray[i] != ' ')
                i++;
            reverse(reversedCharArray, begin, i - 1);
        }
    }

    // 单词和单词前面空格减一的空格一同翻转
    private int wordReversePlus(char[] reversedCharArray, int n) {
        int i = 0, begin = 0;
        while (i < n) {
            // 当i下标不是空格 i+1下标是空格 开始翻转
            while ((i < n && reversedCharArray[i] != ' ' && reversedCharArray[i + 1] == ' ')) {
                i++;
                reverse(reversedCharArray, begin, i - 1);
                // 向后找翻转出来的多余空格
                while (i > 0 && reversedCharArray[i] == ' ' && reversedCharArray[i - 1] == ' ')
                    i--;
            }
            if (i > 0 && reversedCharArray[i] == ' ' && reversedCharArray[i - 1] != ' ')
                begin = i + 1;
            i++;
        }
        return begin == 0 ? 1 : begin;
    }

    private void reverse(char[] inputCharArray, int begin, int end) {
        while (begin < end) {
            char t = inputCharArray[begin];
            inputCharArray[begin++] = inputCharArray[end];
            inputCharArray[end--] = t;
        }
    }
}
