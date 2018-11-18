import java.util.Scanner;
import java.math.BigInteger;
import java.util.Scanner;

public class bigInt {
    public static void main(String[] args) {
        BigInteger number;

        try{
            Scanner sc = new Scanner(System.in);
            number = new BigInteger(sc.next());

            System.out.println(factorial(number).toString());
            sc.close();
        } catch (NumberFormatException ex) {
            System.out.println("Not a number !");
        }

    }

    public static BigInteger factorial(BigInteger n) {
        BigInteger result = BigInteger.ONE;

        while (!n.equals(BigInteger.ZERO)) {
            result = result.multiply(n);
            n = n.subtract(BigInteger.ONE);
        }

        return result;
    }
}
