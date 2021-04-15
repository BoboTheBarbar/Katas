package codewars.DuplicateEncoderTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DuplicateEncoderTest {

	@Test
	void test() {
		String word = "abca";
		int k = 0;
		for(char letter : word.toCharArray()) {
			if(word.length() - (word.replace(String.valueOf(letter), "")).length() > 1) {
				continue;
			}
			k++;
		}
		assertEquals(2, k);
	}
	
	@Test
	void encodeTest_simple() {
		String result = DuplicateEncoder.encode("aaab");
		assertEquals(")))(", result);
	}

    @Test
    public void test2() {
    	String result = DuplicateEncoder.encode("Prespecialized");
    	assertEquals(")()())()(()()(", result);
    }
    
    @Test
    public void test3() {
    	String result = DuplicateEncoder.encode("   ()(   ");
    	assertEquals("))))())))", result);
    }
}
