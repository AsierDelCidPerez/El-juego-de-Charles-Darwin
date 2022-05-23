package controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import application.Main;

public class AdditionalMethods {
	
	
	public static void main(String[] args) {
		try {
			System.out.println(AdditionalMethods.desencriptar("Oso/p11gBe0Q8qBw11f3BQ=="));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static String claveSecreta = "3Vcry6H$%0nBTAZ9";
	
	  private static SecretKeySpec crearClave() throws UnsupportedEncodingException, NoSuchAlgorithmException {
	        String clave = claveSecreta;
		  byte[] claveEncriptacion = clave.getBytes("UTF-8");
	        
	        MessageDigest sha = MessageDigest.getInstance("SHA-1");
	        
	        claveEncriptacion = sha.digest(claveEncriptacion);
	        claveEncriptacion = Arrays.copyOf(claveEncriptacion, 16);
	        
	        SecretKeySpec secretKey = new SecretKeySpec(claveEncriptacion, "AES");

	        return secretKey;
	    }
	
	
	  public static String encriptar(String datos) throws Exception {
	        SecretKeySpec secretKey = crearClave();
	        
	        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");        
	        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

	        byte[] datosEncriptar = datos.getBytes("UTF-8");
	        byte[] bytesEncriptados = cipher.doFinal(datosEncriptar);
	        String encriptado = Base64.getEncoder().encodeToString(bytesEncriptados);

	        return encriptado;
	    }
	  
	  
	  public static String desencriptar(String datosEncriptados) throws Exception {
	        SecretKeySpec secretKey = crearClave();

	        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
	        cipher.init(Cipher.DECRYPT_MODE, secretKey);
	        
	        byte[] bytesEncriptados = Base64.getDecoder().decode(datosEncriptados);
	        byte[] datosDesencriptados = cipher.doFinal(bytesEncriptados);
	        String datos = new String(datosDesencriptados);
	        
	        return datos;
	    }

	
}
