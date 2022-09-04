package sumOfOddNumbers;

public class RowSummer {
	private RowSummer() {}

    public static int rowSumOddNumbers(int n) {
    	int lastRowNumber = getLastNumberFromPyramid(n);
    	int firstRowNumber = 2 + getLastNumberFromPyramid(n-1);
		return getSumOfOddNumbersBetween(firstRowNumber, lastRowNumber);
    }

	public static int getSumOfOddNumbersBetween(int lowerBound, int upperBound) {
		int upperOddNumberIndex = (upperBound-1)/2;
		int lowerOddNumberIndex = (lowerBound-1)/2;
		int upperSumOfOddNumbers = upperOddNumberIndex * (upperOddNumberIndex + 2);	// evaluated sum formula
		int lowerSumOfOddNumbers = lowerOddNumberIndex * (lowerOddNumberIndex + 2);
		return upperSumOfOddNumbers - lowerSumOfOddNumbers + lowerBound;
	}
    
	public static int getLastNumberFromPyramid(int rowsOfPyramid) {
		// adjusted Gauss formula
		return rowsOfPyramid*(rowsOfPyramid + 1) - 1;
	}
}