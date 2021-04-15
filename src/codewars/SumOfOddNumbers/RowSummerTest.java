package codewars.SumOfOddNumbers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RowSummerTest {

	@Test
    public void test1() {
        assertEquals(1, RowSummer.rowSumOddNumbers(1));
    }

	@Test
	public void test2() {
		assertEquals(27, RowSummer.rowSumOddNumbers(3));
	}
	@Test
    public void test3() {
        assertEquals(74088, RowSummer.rowSumOddNumbers(42));
    }
	
	@Test
	public void testGetLastNumberOfPyramid() {
		assertEquals(11, RowSummer.getLastNumberFromPyramid(3));
	}
	
	@Test
	public void testGetLastNumberOfPyramid2() {
		assertEquals(19, RowSummer.getLastNumberFromPyramid(4));
	}
	
	@Test
	public void testGetSumOfOddNumbers() {
		assertEquals(12, RowSummer.getSumOfOddNumbersBetween(5, 7));
	}
	
	@Test
	public void testGetSumOfOddNumbers2() {
		assertEquals(32, RowSummer.getSumOfOddNumbersBetween(5, 12));
	}
}
