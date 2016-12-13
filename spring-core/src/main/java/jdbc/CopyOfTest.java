package jdbc;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.bouncycastle.util.encoders.Base64;

public class CopyOfTest {
	public static void main(String... a) throws NoSuchAlgorithmException,
			ClassNotFoundException, SQLException, InvalidKeyException,
			NoSuchPaddingException, InvalidKeySpecException,
			IllegalBlockSizeException, BadPaddingException {
		DB1 db = new DB1();
		db.dao();

	}
}

class DB1 {
	public void dao() throws ClassNotFoundException, SQLException,
			NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeySpecException, IllegalBlockSizeException,
			BadPaddingException, InvalidKeyException {

		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
		keyGen.initialize(1024);
		KeyPair keyPair = keyGen.generateKeyPair();
		byte[] publick = keyPair.getPublic().getEncoded();
		String key = publick.toString();
		byte[] again = key.getBytes();
		
		

				enc(again);
	}

	public void enc(byte[] pub) throws NoSuchAlgorithmException,
			InvalidKeySpecException, InvalidKeyException,
			NoSuchPaddingException, IllegalBlockSizeException,
			BadPaddingException {

		final Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		final KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		// encrypt the plaintext using the public key
		byte[] cipherText = null;
		final EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(pub);
		final PublicKey pubKey = keyFactory.generatePublic(publicKeySpec);
		cipher.init(Cipher.ENCRYPT_MODE, pubKey);
		cipherText = cipher.doFinal("raviteja".getBytes());
		System.out.println(cipherText);
	}
	

}
