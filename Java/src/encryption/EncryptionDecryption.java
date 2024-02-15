package encryption;

import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class EncryptionDecryption {
	private static final int DEFAULT_KEY_SIZE = 128; // Default key size for AES encryption

	public static SecretKey generateKey() throws NoSuchAlgorithmException {
		return generateKey(DEFAULT_KEY_SIZE);
	}

	public static SecretKey generateKey(int keySize) throws NoSuchAlgorithmException {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(keySize);
		return keyGenerator.generateKey();
	}

	public static String encrypt(String text, SecretKey key) {
		StringBuilder encryptedText = new StringBuilder();
		for (char c : text.toCharArray()) {
			encryptedText.append((char) (c + getKeyAsInt(key)));
		}
		return encryptedText.toString();
	}
	
	public static String decrypt(String encryptedText, SecretKey key) {
		StringBuilder decryptedText = new StringBuilder();
		for (char c : encryptedText.toCharArray()) {
			decryptedText.append((char) (c- getKeyAsInt(key)));
		}
		return decryptedText.toString();
	}

	private static int getKeyAsInt(SecretKey key) {
		// Convert the key to an integer representation for encryption
		byte[] keyBytes = key.getEncoded();
		int sum = 0;
		for (byte b : keyBytes) {
			sum += b;
		}
		return sum;
	}
}
