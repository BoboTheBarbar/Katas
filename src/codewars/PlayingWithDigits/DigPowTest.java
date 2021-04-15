package codewars.PlayingWithDigits;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DigPowTest {

	@Test
	void testDigPow() {
		long k = DigPow.digPow(89, 1);
		assertEquals(1, k);
	}

}
