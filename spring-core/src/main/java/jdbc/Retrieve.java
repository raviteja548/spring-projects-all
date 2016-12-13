package jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.RC2ParameterSpec;

public class Retrieve {
public static void main(String args[]) throws IOException, ClassNotFoundException, SQLException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, NoSuchProviderException, NoSuchPaddingException{
Ret r = new Ret();
r.ext();
	
}
}

class Ret{
	public void ext() throws IOException, ClassNotFoundException, SQLException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, NoSuchProviderException, NoSuchPaddingException{
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		FileInputStream fileIn = new FileInputStream("src//main//resources//rc2.ser");
	    ObjectInputStream in = new ObjectInputStream(fileIn);
	    Key cKey = (Key) in.readObject();
	    in.close();
	    fileIn.close();
	    byte[] salt = new byte[8];
	    byte[] IV = new byte[8];
	    RC2ParameterSpec rc2Spec = new RC2ParameterSpec(40, IV);
	    String data = "sai";
	    
	    Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "sai");

		PreparedStatement pst1 = con.prepareStatement("select * from keydata where assetid = '201'");
        PreparedStatement pst2 = con.prepareStatement("select * from keydata where assetid = '202'");
        
        ResultSet rs1 = pst1.executeQuery();
        ResultSet rs2 = pst2.executeQuery();
        byte[] pubdb = null;
        byte[] pvtdb = null;
        
        while(rs1.next()){
            Blob blob = rs1.getBlob(2);
            pubdb = blob.getBytes(1, (int) blob.length());
            System.out.println(pubdb);
        }
        while(rs2.next()){
            Blob blob = rs2.getBlob(2);
             pvtdb = blob.getBytes(1, (int) blob.length());
             System.out.println(pvtdb);
        }
		
        
        Cipher c1 = Cipher.getInstance("RC2/CBC/PKCS5Padding", "BC");;
        SecureRandom secRand = new SecureRandom(salt);
        c1.init(Cipher.DECRYPT_MODE, cKey, rc2Spec, secRand);
        byte[] msg1 = c1.doFinal(pubdb);
        
        Cipher c2 = Cipher.getInstance("RC2/CBC/PKCS5Padding", "BC");;
        c2.init(Cipher.DECRYPT_MODE, cKey, rc2Spec, secRand);
        byte[] msg2 = c2.doFinal(pvtdb);
        
        
        
        final KeyFactory keyFactory = KeyFactory.getInstance("RSA");

		final EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(msg1);
		final PublicKey pubKey = keyFactory.generatePublic(publicKeySpec);

        
		EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(msg2);
		PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);
System.out.println("private key is "+privateKey);
System.out.println("public key is"+pubKey);
        

Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");


cipher.init(Cipher.ENCRYPT_MODE, pubKey);
byte[] cipherText = cipher.doFinal(data.getBytes());

cipher.init(Cipher.DECRYPT_MODE, privateKey);
byte[] newPlainBytes = cipher.doFinal(cipherText);
        
        System.out.println(new String(newPlainBytes));
        
        
        
        
        
        
        
        
        
        
        
		
        
        
        System.out.println(pubdb+"\n"+pvtdb);
        
        
        
	}
}
