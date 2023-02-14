package de.katas.codewars.validBraces;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("java:S3415")
class BraceCheckerTest extends BraceChecker {

    @Test
    void test_addQue_empty() {
        Character c = '(';
        BraceChecker testClass = new BraceChecker();
        testClass.nextBraceIsOK(c);

        assertEquals(testClass.closableBraces.get(0), '(');
    }

    @Test
    void test_addQue_notEmpty() {
        Character c = '(';
        BraceChecker testClass = new BraceChecker();
        testClass.closableBraces.add('{');
        testClass.nextBraceIsOK(c);

        assertEquals(testClass.closableBraces.get(1), '(');
    }

    @Test
    void test_reduceQue() {
        Character c = ')';
        BraceChecker testClass = new BraceChecker();
        testClass.closableBraces.add('(');
        testClass.nextBraceIsOK(c);

        assertEquals(testClass.closableBraces.size(), 0);
    }

    @Test
    void test_attemptClosing_true() {
        Character brace = ')';
        BraceChecker testClass = new BraceChecker();
        testClass.closableBraces.add('(');
        assertTrue(testClass.attemptClosing(brace));
        assertEquals(testClass.closableBraces.size(), 0);
    }

    @Test
    void test_attemptClosing_false_openingBrace() {
        Character brace = '}';
        BraceChecker testClass = new BraceChecker();
        testClass.closableBraces.add('(');
        assertFalse(testClass.attemptClosing(brace));
        assertEquals(testClass.closableBraces.size(), 1);
    }

    @Test
    void test_isValid_true() {
        String braces = "[({([])})]";
        BraceChecker testClass = new BraceChecker();
        boolean validation = testClass.isValid(braces);
        assertTrue(validation);
        assertEquals(testClass.closableBraces.size(), 0);
    }

    @Test
    void test_isValid_false_TooManyOpen() {
        String braces = "{[(()";
        BraceChecker testClass = new BraceChecker();
        boolean validation = testClass.isValid(braces);
        assertFalse(validation);
        assertEquals(testClass.closableBraces.size(), 3);
    }

    @Test
    void test_isValid_false_InvalidCloser() {
        String braces = "(((}())))";
        BraceChecker testClass = new BraceChecker();
        boolean validation = testClass.isValid(braces);
        assertFalse(validation);
        assertEquals(testClass.closableBraces.size(), 3);
    }

}