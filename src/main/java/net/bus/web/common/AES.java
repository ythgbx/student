package net.bus.web.common;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * Created by sky on 16/8/3.
 */
public class AES {
    private static final String pkey = "0123456789abcdef";
    private static final String piv = "0123456789abcdef";
    private AES (){}
    // 加密
    public String Encrypt(String sSrc) throws Exception {
        if (pkey == null) {
            System.out.print("Key为空null");
            return null;
        }
        // 判断Key是否为16位
        if (pkey.length() != 16) {
            System.out.print("Key长度不是16位");
            return null;
        }
        byte[] raw = pkey.getBytes();
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");//"算法/模式/补码方式"
        IvParameterSpec iv = new IvParameterSpec(piv.getBytes());//使用CBC模式，需要一个向量iv，可增加加密算法的强度
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes());
        return new BASE64Encoder().encode(encrypted);//此处使用BAES64做转码功能，同时能起到2次加密的作用。
    }

    // 解密
    public String Decrypt(String sSrc) throws Exception {
        try {
            // 判断Key是否正确
            if (pkey == null) {
                System.out.print("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (pkey.length() != 16) {
                System.out.print("Key长度不是16位");
                return null;
            }
            byte[] raw = pkey.getBytes("ASCII");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(piv
                    .getBytes());
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);//先用bAES64解密
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original);
                return originalString;
            } catch (IllegalBlockSizeException e) {
                System.out.println(e.toString());
                return null;
            } catch (BadPaddingException e){
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
    public static AES instance = new AES();
    public static AES getAesInstance(){
        return instance;
    }
}
