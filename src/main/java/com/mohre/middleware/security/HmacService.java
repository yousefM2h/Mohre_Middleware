package com.mohre.middleware.security;

import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.springframework.stereotype.Component;
@Component
public class HmacService {

	public String getHMACMessageDigest(byte[] jsonBytes,String sharedkey) {
		
		byte[] hMACkey = sharedkey.getBytes();
		HmacUtils hmacUtils = new HmacUtils(HmacAlgorithms.HMAC_SHA_256, hMACkey);
		return hmacUtils.hmacHex(jsonBytes);
	}
	
}
