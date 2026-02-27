package com.mohre.middleware.security;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import org.springframework.stereotype.Component;

@Component
public class KeyLoader {

	public RSAPrivateKey getRsaPrivateKey(String privateKey) throws InvalidKeySpecException, NoSuchAlgorithmException {
		privateKey = privateKey.replace("-----BEGIN PRIVATE KEY-----", "")
		        .replace("-----END PRIVATE KEY-----", "")
		        .replaceAll("\\s+", ""); 
        byte[] decoded = Base64.getDecoder().decode(privateKey);
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(decoded);
        return (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(spec);
	}

	public RSAPublicKey getRsaPublicKey(String cbuaePublicKey) throws InvalidKeySpecException, NoSuchAlgorithmException {
		cbuaePublicKey = cbuaePublicKey.replace("-----BEGIN PUBLIC KEY-----", "")
		        .replace("-----END PUBLIC KEY-----", "")
		        .replaceAll("\\s+", ""); 
        byte[] decoded = Base64.getDecoder().decode(cbuaePublicKey);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(decoded);
        return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(spec);
	}
	
}
