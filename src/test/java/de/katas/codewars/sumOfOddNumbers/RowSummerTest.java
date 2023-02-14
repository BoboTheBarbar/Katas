package de.katas.codewars.sumOfOddNumbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RowSummerTest {

    @Test
    void test1() {
        assertEquals(1, RowSummer.rowSumOddNumbers(1));
    }

    @Test
    void test2() {
        assertEquals(27, RowSummer.rowSumOddNumbers(3));
    }

    @Test
    void test3() {
        assertEquals(74088, RowSummer.rowSumOddNumbers(42));
    }

    @Test
    void testGetLastNumberOfPyramid() {
        assertEquals(11, RowSummer.getLastNumberFromPyramid(3));
    }

    @Test
    void testGetLastNumberOfPyramid2() {
        assertEquals(19, RowSummer.getLastNumberFromPyramid(4));
    }

    @Test
    void testGetSumOfOddNumbers() {
        assertEquals(12, RowSummer.getSumOfOddNumbersBetween(5, 7));
    }

    @Test
    void testGetSumOfOddNumbers2() {
        assertEquals(32, RowSummer.getSumOfOddNumbersBetween(5, 12));
    }
}
