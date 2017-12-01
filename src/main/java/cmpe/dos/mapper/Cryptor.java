package cmpe.dos.mapper;

import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

public class Cryptor {
    
    public static Key newKeyByKeyGenerator(String algorithm) throws NoSuchAlgorithmException {
	KeyGenerator kg = KeyGenerator.getInstance(algorithm);
	Key key = kg.generateKey();
	return key;
    }

    public static Key newKeyBySecretKeySpec(byte[] key, String algorithm) throws NoSuchAlgorithmException {
	return new SecretKeySpec(key, algorithm);
    }

    public static byte[] encrypt(String transformation, Key key, String password) throws Exception {
	Cipher cipher = Cipher.getInstance(transformation);
	cipher.init(Cipher.ENCRYPT_MODE, key);
	return cipher.doFinal(password.getBytes());
    }

    public static String decrypt(String transformation, Key key, byte[] data) throws Exception {
	Cipher cipher = Cipher.getInstance(transformation);
	cipher.init(Cipher.DECRYPT_MODE, key);
	byte[] result = cipher.doFinal(data);
	String word = new String(result);
	return word;
    }
}
