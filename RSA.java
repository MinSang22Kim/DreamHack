import java.math.BigInteger;

public class RSA {
    public static void main(String[] args) {

        // M = C^d mod N, ed = 1 mod (p-1)(q-1)
        BigInteger n = new BigInteger("3174654383");
        BigInteger e = new BigInteger("65537");
        BigInteger C = new BigInteger("2487688703");
        BigInteger p = null;
        BigInteger q = null;
        BigInteger euler_phi_function = null; // 오일러 피함수
        BigInteger d = null; // e의 역수
        BigInteger M = null; // plaintext

        BigInteger i = new BigInteger("2");
        while(i.compareTo(n) <= 0){
            if(n.remainder(i).equals(new BigInteger("0"))){
                p = i;
                q = n.divide(p);
                euler_phi_function = p.subtract(BigInteger.ONE).
                        multiply(q.subtract(BigInteger.ONE)); // (p-1)(q-1)
                break;
            }
            i=i.add(BigInteger.ONE);
        }

        d = e.modPow(new BigInteger("-1"), euler_phi_function);
        M = C.modPow(d, n);

        System.out.println("p = " + p);
        System.out.println("q = " + q);
        System.out.println("euler_phi_function = (p-1)*(q-1) = " + euler_phi_function);
        System.out.println("\nPlaintext = " + M);
        System.out.println("d = " + d);
    }
}
