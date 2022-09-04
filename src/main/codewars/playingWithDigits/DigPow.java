package playingWithDigits;

@SuppressWarnings("java:S2184")
public class DigPow {
    private DigPow() {
    }

    public static long digPow(int n, int p) {
        long x = getSum(Integer.toString(n), p);
        if (x % n == 0) {
            return x / n;
        } else {
            return -1;
        }
    }

    private static long getSum(String n, int p) {
        long x = 0;
        for (int k = 0; k < n.length(); k++) {
            x += Math.pow(Character.getNumericValue(n.charAt(k)), p + k);
        }
        return x;
    }
}
