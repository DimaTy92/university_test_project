package com.example.demo.parser;

import org.springframework.stereotype.Component;

@Component
public class BracketsValueParser {
    private static final String EMPTY = "";
    private static final Character lastBracket = '}';
    private static final Character firstBracket = '{';

    public String parserValueInBrackets(String message) {
        int firstBracketIndex = message.indexOf(firstBracket);
        int lastBracketIndex = message.lastIndexOf(lastBracket);
        if (firstBracketIndex > lastBracketIndex || indexNotFound(firstBracketIndex, lastBracketIndex)) {
            return EMPTY;
        } else {
            return message.substring(firstBracketIndex + 1, lastBracketIndex);
        }
    }

    private boolean indexNotFound(int firstBracketIndex, int lastBracketIndex) {
        return firstBracketIndex == -1 || lastBracketIndex == -1;
    }
}
