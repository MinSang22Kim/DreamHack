import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CheckAlphabet {
	static char[] alphabet = { 'l', 'n', 'v', 'g', 'c', 'j', 'q', 'a', 'b', 'y', 'i', 'd', 
			'o', 'x', 'h', 'e', 'f', 'k', 't', 'w', 's', 'm', 'p', 'r', 'z', 'u' };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringBuilder decrypt = new StringBuilder();

		System.out.println("해독할 문장을 작성하시오.");

		int[] cnt = new int[26];

		String sentence = br.readLine();
		while (!sentence.isEmpty()) {
			for (int i = 0; i < sentence.length(); i++) {
				char c = Character.toUpperCase(sentence.charAt(i));
				if ('A' <= c && c <= 'Z')
					cnt[c - 'A']++;
			}
			decrypt.append(decryptSentence(sentence) + "\n");
			sentence = br.readLine();
		}

		sb.append("====================================== [ Frequency Count Table ] "
				+ "======================================\n");

		// 알파벳 출력 (1행)
		for (char c = 'A'; c <= 'Z'; c++) {
			sb.append(String.format("%3s ", c));
		}
		sb.append("\n");

		// 빈도 출력 (2행)
		for (int i = 0; i < 26; i++) {
			sb.append(String.format("%3d ", cnt[i]));
		}
		sb.append("\n\n");

		sb.append("============================================= [ Key Table ] "
				+ "======================================================\n");

		// 평문 출력(1행)
		sb.append("plaintext  ");
		for (char c = 'A'; c <= 'Z'; c++) {
			sb.append(String.format("%3s ", c));
		}

		// 암호문 출력(2행)
		sb.append("\nciphertext ");
		for (char c = 'A'; c <= 'Z'; c++) {
			char cipherChar = (char) (c + 11);
			if (cipherChar > 'Z')
				cipherChar = (char) (cipherChar - 26);
			sb.append(String.format("%3s ", cipherChar));
		}

		sb.append("\n\n");

		sb.append("======================================= [ Decrypted Sentences ] "
				+ "====================================\n");
		sb.append(decrypt.toString());

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

	static String decryptSentence(String sentence) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < sentence.length(); i++) {
			char c = sentence.charAt(i);
			if ('A' <= c && c <= 'Z') {
				int index = c - 'A';
				sb.append(alphabet[index]);
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}
}
