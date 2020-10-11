package com.jtang.alg.practices;


public class Pattern {
    private boolean matched = false;
    private char[] pattern; // 正则表达式
    private int plen; // 正则表达式长度

    public Pattern(char[] pattern, int plen) {
        this.pattern = pattern;
        this.plen = plen;
    }

    public boolean match(char[] text, int textLen) { // 文本串及长度
        matched = false;
        rmatch(0, 0, text, textLen);
        return matched;
    }

    private void rmatch(int ti, int pj, char[] text, int textLength) {
        if (matched) return; // 如果已经匹配了，就不要继续递归了
        if (pj == plen) { // 正则表达式到结尾了
            if (ti == textLength) matched = true; // 文本串也到结尾了
            return;
        }
        if (pattern[pj] == '*') { // *匹配任意个字符
            for (int k = 0; k <= textLength - ti; ++k) {
                rmatch(ti + k, pj + 1, text, textLength);
            }
        } else if (pattern[pj] == '?') { // ?匹配0个或者1个字符
            rmatch(ti, pj + 1, text, textLength);
            rmatch(ti + 1, pj + 1, text, textLength);
        } else if (ti < textLength && pattern[pj] == text[ti]) { // 纯字符匹配才行
            rmatch(ti + 1, pj + 1, text, textLength);
        }
    }


    public static void main(String[] args){
        String pattern = "ab*d";
        Pattern testPattern = new Pattern(pattern.toCharArray(), 4);
        boolean result = testPattern.match("abcd".toCharArray(), 4);
        System.out.println("result: " + result);
    }
}
