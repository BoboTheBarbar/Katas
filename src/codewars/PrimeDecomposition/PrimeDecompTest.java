package codewars.PrimeDecomposition;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class PrimeDecompTest {

	@Test
	void primeToString_test() {
		String prime = PrimeDecomp.primePairToString(5, 3);
		assertEquals("(5**3)", prime);
	}
	
	@Test
	void getPrimeFactors_test() {
		List<Integer> primeFactors = PrimeDecomp.getPrimeFactors(36);
		List<Integer> expected = Arrays.asList(2, 2, 3, 2);
		assertEquals(expected, primeFactors);
	}
	
	@Test
	void factors_test() {
		String primeFactors = PrimeDecomp.factors(36);
		String expected = "(2**2)(3**2)";
		assertEquals(expected, primeFactors);
	}
	
	@Test
	void factors2_test() {
		String primeFactors = PrimeDecomp.factors(7775460);
		String expected = "(2**2)(3**3)(5)(7)(11**2)(17)";
		assertEquals(expected, primeFactors);
	}

}