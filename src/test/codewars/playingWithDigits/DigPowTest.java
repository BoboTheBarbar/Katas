package playingWithDigits;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DigPowTest {

	@Test
	void testDigPow() {
		long k = DigPow.digPow(89, 1);
		assertEquals(1, k);
	}

}
