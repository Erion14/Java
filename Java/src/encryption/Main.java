package encryption;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.SecretKey;

public class Main {
	
	public static void main(String[] args) throws IOException {
		final int keySize = 128;
		
		try {
		FileOperations.createDir();
		String originalText = FileOperations.generateText();
		SecretKey key = EncryptionDecryption.generateKey(keySize);
		
		
		String encryptedText = EncryptionDecryption.encrypt(originalText, key);
		System.out.println("Original Text : " + originalText);
		System.out.println("Encrypted Text: " + encryptedText);
		
		String decryptedText = EncryptionDecryption.decrypt(encryptedText, key);
		System.out.println("Decrypted Text : " + decryptedText);
		
		FileOperations.writeText(encryptedText);
		
		String textFile = FileOperations.readText();
		System.out.println("The text that is saved in the file :" + textFile);
		
		}catch (NoSuchAlgorithmException e){
			
			
		}
	}

}
