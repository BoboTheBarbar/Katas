package validBraces;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BraceChecker {
	protected Map<Character, Character> openingBraceMap;
	protected Map<Character, Character> closingBraceMap;
	protected List<Character> closableBraces;

	public BraceChecker() {
		closableBraces = new ArrayList<>();
		openingBraceMap = Map.ofEntries(
				Map.entry('(', ')'),
				Map.entry('{', '}'),
				Map.entry('[', ']'));

		closingBraceMap = Map.ofEntries(
				Map.entry(')', '('),
				Map.entry('}', '{'),
				Map.entry(']', '['));
	}

	public boolean isValid(String braces) {
		for(Character brace : braces.toCharArray()) {
			if(!nextBraceIsOK(brace)) return false;
		}
		return closableBraces.isEmpty();
	}

	public boolean nextBraceIsOK(Character brace) {
		if(openingBraceMap.containsKey(brace)) {
			return closableBraces.add(brace);
		}
		else if(closableBraces.isEmpty()) {
			return false;
		}
		return attemptClosing(brace);
	}

	protected boolean attemptClosing(Character brace) {
		int lastIndex = closableBraces.size()-1;
		Character matchingBrace = closingBraceMap.get(brace);

		if(closableBraces.get(lastIndex).equals(matchingBrace)) {
			closableBraces.remove(lastIndex);
			return true;
		}
		else {
			return false;
		}
	}
}

