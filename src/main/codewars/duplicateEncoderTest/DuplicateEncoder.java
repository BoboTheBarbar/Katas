package duplicateEncoderTest;
@SuppressWarnings("java:S120")
public class DuplicateEncoder {
	private DuplicateEncoder() {}

	static String encode(String word) {
		word = word.toLowerCase();
		StringBuilder newWord = new StringBuilder();
		for(char letter : word.toCharArray()) {
			char chosenBrace = occursOnce(letter, word) ? '(' : ')';
			newWord.append(chosenBrace);
		}
		return newWord.toString();
	}

	private static boolean occursOnce(char letter, String word) {
		int lengthDifference = word.length() - (word.replace(String.valueOf(letter), "")).length();
		return lengthDifference == 1;
	}
}
