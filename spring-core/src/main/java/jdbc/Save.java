package jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.RC2ParameterSpec;

public class Save {
public static void main(String args[]) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, IOException, ClassNotFoundException, SQLException{
	
Trail t = new Trail();
t.storeData();

}
}

class Trail{
public void storeData() throws IOException, ClassNotFoundException, SQLException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException{
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

	KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
	keyGen.initialize(1024);
	KeyPair keyPair = keyGen.generateKeyPair();
	byte[] publick = keyPair.getPublic().getEncoded();
	byte[] prvate = keyPair.getPrivate().getEncoded();
	
	
	Cipher c2 = Cipher.getInstance("RC2/CBC/PKCS5Padding", "BC");
    SecureRandom secRand = new SecureRandom(salt);

    c2.init(Cipher.ENCRYPT_MODE, cKey, rc2Spec, secRand);
    byte[] encryptedContent1 = c2.doFinal(publick);

    Cipher c3 = Cipher.getInstance("RC2/CBC/PKCS5Padding", "BC");
    c3.init(Cipher.ENCRYPT_MODE, cKey, rc2Spec, secRand);
    byte[] encryptedContent2 = c3.doFinal(prvate);
    
    PreparedStatement pst = con.prepareStatement("insert into keydata values(?,?)");
    pst.setInt(1,201);
	pst.setBytes(2, encryptedContent1);
	boolean b = pst.execute();
	System.out.println(b);
	pst.setInt(1, 202);
	pst.setBytes(2, encryptedContent2);
	pst.execute();
	
	
	
	
}
}
