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

public class Test {
	public static void main(String... a) throws NoSuchAlgorithmException,
			ClassNotFoundException, SQLException, InvalidKeyException,
			NoSuchPaddingException, InvalidKeySpecException,
			IllegalBlockSizeException, BadPaddingException {
		DB db = new DB();
		db.dao();

	}
}

class DB {
	public void dao() throws ClassNotFoundException, SQLException,
			NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeySpecException, IllegalBlockSizeException,
			BadPaddingException, InvalidKeyException {
		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:XE", "system", "sai");

		PreparedStatement pst = con
				.prepareStatement("insert into keydata values(?,?)");
		// int n =
		// pst.executeUpdate("insert into keydata values(1, utl_raw.cast_to_raw('hello'))");
		String str = "d";

		/*
		 * Blob b = new SerialBlob(str.getBytes()); Blob blob =(Blob) new
		 * javax.sql.rowset.serial.SerialBlob(str.getBytes());
		 * 
		 * Blob blob1 = con.createBlob(); blob1.setBytes(1, str.getBytes());
		 */

		BufferedInputStream bais = new BufferedInputStream(
				new ByteArrayInputStream(str.getBytes()));
		// ps.setAsciiStream( 1, bais, bais. );//or setBinaryStream()
		// ps.executeUpdate();

		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
		keyGen.initialize(1024);
		KeyPair keyPair = keyGen.generateKeyPair();
		byte[] publick = keyPair.getPublic().getEncoded();

byte[] da=		Base64.encode(publick);
		System.out.println(da.toString());
		
		
		System.out.println("Actual " + publick);
		String k = publick.toString();
		System.out.println("string" + k);
		pst.setInt(1, 18);
		// pst.setBytes(2, publick);
		pst.setString(2, k);
		//pst.execute();

		PreparedStatement pst1 = con
				.prepareStatement("select * from keydata where assetid = 18");

		ResultSet rs1 = pst1.executeQuery();
		byte[] pub = null;
		byte[] pri = null;
		while (rs1.next()) {

			// pub = rs1.getBytes(2);
			String keydb = rs1.getString(2);
			pub = keydb.getBytes();
			System.out.println("Fetched" + pub);
			final Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			final KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			// encrypt the plaintext using the public key
			byte[] cipherText = null;
			final EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publick);
			final PublicKey pubKey = keyFactory.generatePublic(publicKeySpec);
			cipher.init(Cipher.ENCRYPT_MODE, pubKey);
			cipherText = cipher.doFinal("raviteja".getBytes());
			System.out.println(cipherText);
		}
		// enc(pub,pri);
	}

	public void enc(byte[] pub, byte[] pri) throws NoSuchAlgorithmException,
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

		Cipher cipher1 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(pri);
		PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);
		cipher1.init(Cipher.DECRYPT_MODE, privateKey);
		byte[] newPlainBytes = cipher.doFinal(cipherText);
		System.out.println(new String(newPlainBytes));
	}

}
