import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;

public class AES {
    static String plainText;

    static String key = "8iE3bf1se6N76HGPP8S0Xw==";
    static String IV = "cHml3oX848/0uBwDJtChOA==";

    static byte[] decodingKey = Base64.getDecoder().decode(key);
    static byte[] decodingIV = Base64.getDecoder().decode(IV);

    static String decodeCipher(String ciphertext) throws Exception {
        Cipher cipher = Cipher.getInstance("AES / CBC / PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE,
                new SecretKeySpec(decodingKey, "AES"),
                new IvParameterSpec(decodingIV));

        byte[] plainText = Base64.getDecoder().decode(ciphertext.getBytes());
        return new String(cipher.doFinal(plainText));
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        System.out.println("*** AES 암호문을 복호화하는 프로그램입니다 ***");
        System.out.print("암호문을 입력하시오: ");

        plainText = decodeCipher(scan.next());

        System.out.println("복호화된 평문은 아래와 같습니다.");
        System.out.println(" " + plainText);
    }
}

/** 암호문
 "QDr9NZNG9Bgc3TTnfRuqjjzf/kVSYwbP7F9mR4GQZ/IneIh7HTc/xnwzEeVBcH3pPlIbLFySKZruedJc9X87CGNDJ1f2Dat8BR3Ypbei5Q42xc306/AkSuGsjfqbX9/ELxmdKn7MyvY/Jbc0v0AJHV6odgNzygKRRrFJcUIF/50="
 */