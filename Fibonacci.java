import java.util.HashMap;
import java.math.BigInteger;
// -------------------------------------------------------------------------
// This program calculates F(n) = F(n-1) + F(n-2) in reclusive fashion.
// A cache is used, which is implemented with a simple HashMap, to prevent
// re-visiting finished answer. Another point to highlight is BigInteger type
// is used because the answers is over the maximun value of type Long.
// Usage (in console): java Fibonacci { a positive integer }
// -------------------------------------------------------------------------
public class Fibonacci {
    static HashMap<BigInteger, BigInteger> map = new HashMap<>();
    static BigInteger TWO = new BigInteger("2");

    static BigInteger f(BigInteger number) {
        if (number.compareTo(BigInteger.ONE) == 1) { // larger than 1
            BigInteger answer = map.get(number);
            if (answer == null) { // if cache miss, calculate and update cache
                answer = f(number.subtract(BigInteger.ONE)).add(f(number.subtract(TWO))); // f(n-1) + f(n-2)
                map.put(number, answer);
            }
            return answer;
        } else if (number.equals(BigInteger.ONE)) { // equal to 1
            return BigInteger.ONE;
        } else { // equal to 0
            return BigInteger.ZERO;
        }
    }

    public static void main(String [] args) {
        try {
            if (args.length != 1) throw new Exception("Please input a parameter");
            BigInteger input = new BigInteger(args[0]);
            if (input.compareTo(BigInteger.ZERO) < 0) throw new Exception ("Please input a positive integer");
            System.out.println(" F(" + input + ") = " + f(input));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}