package jdbc;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Ser
{
   public static void main(String [] args) throws NoSuchAlgorithmException, NoSuchProviderException
   {
	   Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
       // keyGenerator = KeyGenerator.getInstance(AES_ALGO_NAME);
       KeyGenerator keyGenerator = KeyGenerator.getInstance("RC2", "BC");
       SecretKey secretKey = keyGenerator.generateKey();
       // get Cipher and init it for encryption
      /* Cipher cipher = Cipher.getInstance("RC2/CBC/PKCS5Padding", "BC");
       cipher.init(Cipher.ENCRYPT_MODE, secretKey);*/
       
       // byte[] cKeyBytes = new
       // sun.misc.BASE64Decoder().decodeBuffer(base64Key);
       
       byte[] cKeyBytes = secretKey.getEncoded();
       Key cKey = new SecretKeySpec(cKeyBytes, "RC2");

      try
      {
         FileOutputStream fileOut =
         new FileOutputStream("src/main/resources/rc2.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(cKey);
         out.close();
         fileOut.close();
         System.out.printf("Serialized data is saved in /tmp/employee.ser");
      }catch(IOException i)
      {
          i.printStackTrace();
      }
   }
}