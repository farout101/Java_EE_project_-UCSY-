package com.cashnex.security;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.UUID;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class Security {

	private static final String hashedPassword = null;

	static SecretKey secretKey = null;
	static String encryptedBase64 = null;

	//MD-5 hashing
	public static String doHashing(String rawPassword) {

		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(rawPassword.getBytes());

			byte[] resultByteArray = messageDigest.digest();

			StringBuilder sb = new StringBuilder();

			for (byte b : resultByteArray) {
				sb.append(String.format("%02x", b));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";

	}

	public static String hashPassword(String rawPassword) throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

		// Step 1: Choose the encryption algorithm and mode
		String plaintext = rawPassword;
		String algorithm = "AES";
		String transformation = "AES/ECB/PKCS5Padding";
//	    String SECRET_KEY = "Mar";

//	    // Step 2: Create a key for the chosen encryption algorithm
		KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
		try {
			secretKey = keyGenerator.generateKey();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//
//        // Step 2: Create a secret key from the predefined key bytes
//        byte[] keyBytes = SECRET_KEY.getBytes(StandardCharsets.UTF_8);
//        SecretKey secretKey = new SecretKeySpec(keyBytes, algorithm);

		// Step 3: Initialize a cipher object with the key and encryption mode
		Cipher cipher = Cipher.getInstance(transformation);
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);

		byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
		encryptedBase64 = Base64.getEncoder().encodeToString(encryptedBytes);

		return encryptedBase64;
	}

	public static String decryptPassword(String encryptedPassword) throws NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
// Use the same algorithm, transformation, and secret key as in the encryption example

		// Step 1: Choose the same encryption algorithm and mode used during encryption
		String algorithm = "AES";
		String transformation = "AES/ECB/PKCS5Padding";

		// Step 2: Use the same key that was used during encryption
		// In this example, we assume that you have the secret key from the encryption
		// example

		// Step 3: Initialize a cipher object with the key and decryption mode
		Cipher cipher = Cipher.getInstance(transformation);
		cipher.init(Cipher.DECRYPT_MODE, secretKey);

		// Step 4: Decrypt the data using the cipher object
		byte[] encryptedBytes = Base64.getDecoder().decode(encryptedPassword);
		byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
		String decryptedText = new String(decryptedBytes, StandardCharsets.UTF_8);

		System.out.println("Decrypted data: " + decryptedText);
		return decryptedText;
	}
	
	public static String generateVerificationToken() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
