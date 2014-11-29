package Brackets;

import org.junit.Test;

import static org.junit.Assert.*;

public class BracketsWordTest {

    @Test
    public void testIsBracketWord() throws Exception {
            BracketsWord bracketsWord = new BracketsWord();
            String[] testCases = new String[]{
                "sklgjd", "", "{egftw}", "{fe[vd]}",  "{{[([])]}}",
                "{fe[]}",  "{fe[()]}",  "sakjla", "(aa)abba", "(dsfb{bbaa}[]fgb)rg",
            };

            for (String testCase : testCases) {
                assertEquals("For string " + testCase + " expected output " + true, true, bracketsWord.IsBracketWord(testCase));
            }

            String[] testCasesWrong = new String[]{
                    "sklg)(jd", "[{", "egftw}", "{fevd]}",  "{{[([])]}}}",
                    "{fe]}",  "{fe[()}",  "sakjlaa", "(aa)aba", "(dsfb{bbaa}[]fgba)rg",
            };

            for (String testCase : testCasesWrong) {
                assertEquals("For string " + testCase + " expected output " + false, false, bracketsWord.IsBracketWord(testCase));
            }

    }
}