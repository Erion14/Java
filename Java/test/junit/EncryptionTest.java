package junit;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

import javax.crypto.SecretKey;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import encryption.EncryptionDecryption;
import encryption.FileOperations;
@DisplayName("Encryption and Decryption Test")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class EncryptionTest {

	private static final int DEFAULT_KEY_SIZE = 128;
	private static final String ORIGINAL_TEXT ="Test text for the test";
	private static final String FILE_PATH = "data/testFile.txt";
	
	
	private EncryptionDecryption testInstance;
	private FileOperations testInstance2;
	
	@Test
	public void test_Generate_Key() {
		SecretKey key = null;
		try {
			key = testInstance.generateKey(DEFAULT_KEY_SIZE);
		} catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		assertNotNull(key);
	}
	@Test
	public void test_Encrypt_Decrypt() {
		try {
			SecretKey key = testInstance.generateKey(DEFAULT_KEY_SIZE);
			
			String encryptedText = testInstance.encrypt(ORIGINAL_TEXT, key);
			String decryptedText = testInstance.decrypt(encryptedText, key);
			
			
            assertEquals(ORIGINAL_TEXT, decryptedText);

		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
			
		}
	}
	
	@Test
    public void test_Create_Dir_Test() {
        // Given
        File directory = new File("data/");

        // When
        FileOperations.createDir();

        // Then
        assertTrue(directory.exists());
        assertTrue(directory.isDirectory());

        // Clean up: Delete the created directory after the test
        directory.delete();
    }
	
	@Test
	public void test_Read_Write_Test() {
		
		try {
			testInstance2.writeText(ORIGINAL_TEXT);
			String readText = testInstance2.readText();
			
			
			assertEquals(ORIGINAL_TEXT, readText);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		try {
            Files.deleteIfExists(Paths.get(FILE_PATH));
        } catch (IOException e) {
            fail("IOException occurred during clean up: " + e.getMessage());
        }
		
	}

	
	
	

}
