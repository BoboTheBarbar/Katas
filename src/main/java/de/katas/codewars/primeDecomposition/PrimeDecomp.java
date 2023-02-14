package de.katas.codewars.primeDecomposition;

import java.util.ArrayList;
import java.util.List;

public class PrimeDecomp {

    private PrimeDecomp() {
    }

    public static String factors(int n) {
        StringBuilder factorization = new StringBuilder();
        List<Integer> factorExponentSequence = getPrimeFactors(n);
        for (int k = 0; k < factorExponentSequence.size(); k += 2) {
            int primeNumber = factorExponentSequence.get(k);
            int primeExponent = factorExponentSequence.get(k + 1);
            factorization.append(primePairToString(primeNumber, primeExponent));
        }
        return factorization.toString();
    }

    public static String primePairToString(int primeNumber, int primeExponent) {
        String prime = "(" + primeNumber;
        if (primeExponent > 1) {
            prime += "**" + primeExponent;
        }
        return prime + ")";
    }

    public static List<Integer> getPrimeFactors(int number) {
        List<Integer> factorExponentSequence = new ArrayList<>();
        for (int factor = 2; factor <= number; factor++) {
            if (number % factor == 0) {
                int exponent = 0;
                while (number % factor == 0) {
                    exponent++;
                    number /= factor;
                }
                factorExponentSequence.add(factor);
                factorExponentSequence.add(exponent);
            }
        }
        return factorExponentSequence;
    }

}
