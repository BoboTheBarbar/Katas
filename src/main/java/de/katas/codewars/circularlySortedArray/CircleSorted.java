package de.katas.codewars.circularlySortedArray;

@SuppressWarnings("java:S120")
public class CircleSorted {


    public boolean isCircleSorted(int[] a) {

        int i1 = findBreakpoint(a, 0);
        int i2 = findBreakpoint(a, i1);
        return i1 == i2;
    }

    private int findBreakpoint(int[] array, int startIndex) {
        int prevIndex = startIndex;
        int currentIndex = (startIndex + 1) % array.length;
        while (array[prevIndex] <= array[currentIndex]) {
            if (currentIndex == startIndex) return currentIndex;
            prevIndex = currentIndex;
            currentIndex = (currentIndex + 1) % array.length;
        }
        return currentIndex;
    }
}
