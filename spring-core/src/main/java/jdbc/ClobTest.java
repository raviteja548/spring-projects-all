package jdbc;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.security.Key;
import java.security.SecureRandom;
import java.security.Security;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.crypto.Cipher;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.util.encoders.Base64;

public class ClobTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
try{
	// DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
     Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:XE", "system", "sai");

     Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
 	FileInputStream fileIn = new FileInputStream("src//main//resources//rc2.ser");
     ObjectInputStream in = new ObjectInputStream(fileIn);
     Key cKey = (Key) in.readObject();
     String rc2Key = new String(Base64.encode(cKey.getEncoded()));
     System.out.println(rc2Key);
     in.close();
     fileIn.close();
     byte[] salt = new byte[8];
     byte[] IV = new byte[8];
     RC2ParameterSpec rc2Spec = new RC2ParameterSpec(40, IV);
     String data = "sai";
     
     
     
     
     
     
     
     
     PreparedStatement ps = conn.prepareStatement("INSERT INTO CLOBTABLE VALUES (?)");
     
     //oracle.sql.CLOB newClob = oracle.sql.CLOB.createTemporary(conn, true, oracle.sql.CLOB.DURATION_CALL);
     
     //newClob.putString(1,"This string, up to 4 gigabytes will be inserted into the CLOB");
     
     ps.setString(1, rc2Key);
     
    //int rowcnt = ps.executeUpdate();
     
    //System.out.println("Successful update of "+rowcnt+" row");
     
     
     
      ps = conn.prepareStatement("SELECT * FROM CLOBTABLE");
     ResultSet rs = ps.executeQuery();
     
     String fetched = null;
     String str = null;
     while(rs.next()){
    //	 String str = rs.getString(1);
    	// System.out.println(str+" is fetched");
    	 Clob clob=rs.getClob(1);
    	 str=(String)clob.getSubString(1,(int)clob.length());
    	 System.out.println("Clob Data is : "+str);
    	 
    	 fetched = str;
    	 
    	 
    	 
    	 
    	 
     }
     //encrypt
     
     Key rc = new SecretKeySpec(Base64.decode(fetched.getBytes()), "RC2");
     
     Cipher c2 = Cipher.getInstance("RC2/CBC/PKCS5Padding", "BC");
     SecureRandom secRand = new SecureRandom(salt);

     c2.init(Cipher.ENCRYPT_MODE, rc, rc2Spec, secRand);
     byte[] encryptedContent1 = c2.doFinal(data.getBytes());
     
     c2.init(Cipher.DECRYPT_MODE, rc,rc2Spec,secRand);
     byte[] encD = c2.doFinal(encryptedContent1);
     System.out.println(new String(encD)+" is decrypted text");
     
     
     

     
     ps.close();
     conn.close();      
}catch(Exception e){
e.printStackTrace();	
}
	}

}
