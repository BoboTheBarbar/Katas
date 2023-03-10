package de.katas.codewars.commonDenominators;

import java.util.*;

@SuppressWarnings("java:S1104")
public class Fracts {
    private Fracts() {
    }

    public static String convertFrac(long[][] lst) {
        List<PrimeFactorization> denominators = extractDenominatorsAsPrimeFactorizations(lst);
        PrimeFactorization ggN = getCommonDenominator(extractDenominatorsAsPrimeFactorizations(lst));    // Code smell.
        for (int k = 0; k < lst.length; k++) {
            long extender = ggN.toNumber() / denominators.get(k).toNumber();
            lst[k][0] *= extender;
        }
        List<PrimeFactorization> counters = extractCountersAsPrimeFactorizations(lst);
        long commonDivisor = getCommonDivisor(counters, ggN);

        for (int k = 0; k < lst.length; k++) {
            lst[k][0] = counters.get(k).toNumber() / commonDivisor;
            lst[k][1] = ggN.toNumber() / commonDivisor;
        }

        return toString(lst);
    }

    private static List<PrimeFactorization> extractCountersAsPrimeFactorizations(long[][] lst) {
        return getPrimeFactorizations(lst, 0);
    }

    private static List<PrimeFactorization> extractDenominatorsAsPrimeFactorizations(long[][] lst) {
        return getPrimeFactorizations(lst, 1);
    }

    private static List<PrimeFactorization> getPrimeFactorizations(long[][] lst, int fractIndex) {
        List<PrimeFactorization> listOfPrimeFactorization = new ArrayList<>();
        for (long[] longs : lst) {
            PrimeFactorization factorization = new PrimeFactorization(longs[fractIndex]);
            listOfPrimeFactorization.add(factorization);
        }
        return listOfPrimeFactorization;
    }

    private static String toString(long[][] lst) {
        StringBuilder result = new StringBuilder();
        for (long[] longs : lst) {
            result.append("(");
            result.append(longs[0]);
            result.append(",");
            result.append(longs[1]);
            result.append(")");
        }
        return result.toString();
    }

    public static long getCommonDivisor(List<PrimeFactorization> listOfCounters, PrimeFactorization commonDenominator) {
        listOfCounters.add(commonDenominator);
        Iterator<PrimeFactorization> iterator = listOfCounters.iterator();
        PrimeFactorization result = iterator.next();
        while (iterator.hasNext()) {
            result = result.getIntersection(iterator.next());
        }
        return result.toNumber();
    }

    public static PrimeFactorization getCommonDenominator(List<PrimeFactorization> listOfPrimeFactorization) {
        PrimeFactorization commonDenominator = new PrimeFactorization();
        for (int k = 0; !listOfPrimeFactorization.isEmpty(); k++) {
            Integer tmp = getMaximumExponentAtPosition(listOfPrimeFactorization, k);
            Integer e = PrimeFactorization.listOfPrimes.get(k);
            commonDenominator.factorSequence.add(e);
            commonDenominator.exponentSequence.add(tmp);
            listOfPrimeFactorization.removeAll(getFactorizationsThatAreTooShort(listOfPrimeFactorization, k + 1));
        }
        return commonDenominator;
    }

    private static Integer getMaximumExponentAtPosition(List<PrimeFactorization> listOfPrimeFactorization, int index) {
        Optional<PrimeFactorization> maxP = listOfPrimeFactorization.stream().filter(a -> a.exponentSequence.size() > index).max(Comparator.comparing(a -> a.exponentSequence.get(index)));
        if (maxP.isEmpty()) return 0;

        List<Integer> exponentSequence = maxP.get().exponentSequence;
        if (exponentSequence.isEmpty()) {
            return 0;
        } else {
            return exponentSequence.get(index);
        }
    }

    private static List<PrimeFactorization> getFactorizationsThatAreTooShort(List<PrimeFactorization> listOfPrimeFactorization, int index) {
        return listOfPrimeFactorization.stream().filter(p -> p.exponentSequence.size() - 1 < index).toList();
    }


    public static class PrimeFactorization {

        private static final List<Integer> listOfPrimes = new ArrayList<>();
        public List<Integer> factorSequence = new ArrayList<>();
        public List<Integer> exponentSequence = new ArrayList<>(); // Zu Key Value pair ver???ndern.

        public PrimeFactorization() {

        }

        public PrimeFactorization(PrimeFactorization factorization) {
            this.factorSequence = List.copyOf(factorization.factorSequence);
            this.exponentSequence = List.copyOf(factorization.exponentSequence);
        }

        public PrimeFactorization(long number) {
            for (int factor = 2; factor <= number; factor++) {
                if (isPrime(factor)) {
                    int exponent = getExponent(number, factor);
                    add(factor, exponent);
                }
                if (number == toNumber()) {
                    return;
                }
            }
        }

        public void add(int prime, int exponent) {
            this.factorSequence.add(prime);
            this.exponentSequence.add(exponent);
        }

        public PrimeFactorization clone(PrimeFactorization factorization) {
            return new PrimeFactorization(factorization);
        }

        public PrimeFactorization getIntersection(PrimeFactorization comparedFactorization) {
            int factorSize = Math.min(factorSequence.size(), comparedFactorization.factorSequence.size());
            PrimeFactorization intersection = new PrimeFactorization();
            for (int k = 0; k < factorSize; k++) {
                int minExponent = Math.min(this.exponentSequence.get(k), comparedFactorization.exponentSequence.get(k));
                int prime = PrimeFactorization.listOfPrimes.get(k);
                intersection.add(prime, minExponent);
            }
            return intersection;
        }

        private long toNumber() {
            long result = 1;
            for (int i = 0; i < factorSequence.size(); i++) {
                Integer prime = factorSequence.get(i);
                Integer exponent = exponentSequence.get(i);
                result *= Math.pow(prime, exponent);
            }
            return result;
        }

        public boolean isPrime(int factor) {
            if (listOfPrimes.contains(factor)) {
                return true;
            } else {
                return considerToExtendListOfPrimesBy(factor);
            }
        }


        private boolean considerToExtendListOfPrimesBy(int factor) {
            for (Integer prime : listOfPrimes) {
                if (factor % prime == 0) {
                    return false;
                }
            }
            listOfPrimes.add(factor);
            return true;
        }

        private Integer getExponent(long number, int prime) {
            Integer exponent = 0;
            while (number % prime == 0) {
                exponent++;
                number /= prime;
            }
            return exponent;
        }

        @Override
        public String toString() {
            return Long.toString(this.toNumber());
        }
    }

}