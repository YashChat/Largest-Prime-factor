public class Part2 {
    public static long largestPrimeFactor(long num) {
        long largestprimefactor = Integer.MIN_VALUE;
       largestprimefactor = largestPrimeFactor(num, 2, largestprimefactor);
        return largestprimefactor;
    }

    //recursive helper method
    private static long largestPrimeFactor(long num, long divisor, long max) {
        while (num % divisor == 0) {
            num = num / divisor;
            if (max < divisor) {
                max = divisor;
            }
        }
        if (num == 1) {
            return max;
        }
        if (num % divisor != 0) {
            divisor = getNextPrimeNumber(divisor);
            if (divisor > Math.sqrt(num)) {
                return num;
            }
            max = largestPrimeFactor(num, divisor, max);
        }

        return max;
    }

    private static long getNextPrimeNumber(long next_prime_number) {
        ++next_prime_number;
        for (long i = 2; i < next_prime_number; i++) {
            if (next_prime_number % i == 0) {
                next_prime_number++;
                i = 2;
            }
            else {
                continue;
            }
        }
        return next_prime_number;
    }
}