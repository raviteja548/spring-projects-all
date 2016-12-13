package jdbc;


import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class RC2 {
    public static void main(String args[]) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException,
            InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, IOException {
        AA1 a = new AA1();
        a.ae();
    }
}

class AA1 {
    private Cipher       cipher;
    private final String AES_ALGO_NAME  = "RC2";
    private final String AES_CBC_MODE   = "CBC";
    // private final String PADDING5Scheme = "PKCS5Padding";
    private final String PADDING7Scheme = "PKCS7Padding";
    private int          keySize        = 128;
    private String       data           = "sms";

    public void ae() throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException,
            IllegalBlockSizeException, BadPaddingException, IOException {

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
        byte[] IV = new byte[8];
        byte[] salt = new byte[8];

        RC2ParameterSpec rc2Spec = new RC2ParameterSpec(40, IV);
        Cipher c2 = Cipher.getInstance("RC2/CBC/PKCS5Padding", "BC");
        SecureRandom secRand = new SecureRandom(salt);

        c2.init(Cipher.ENCRYPT_MODE, cKey, rc2Spec, secRand);
        byte[] encryptedContent = c2.doFinal(data.getBytes());

        c2.init(Cipher.DECRYPT_MODE, cKey, rc2Spec, secRand);
        byte[] decryptedMessage = c2.doFinal(encryptedContent);
        String result = new String(decryptedMessage, "ASCII");
        System.out.println(result);
    }
}
