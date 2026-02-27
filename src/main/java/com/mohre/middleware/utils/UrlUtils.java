package com.mohre.middleware.utils;

public class UrlUtils {
	
	public static String cleanUrl(String url) {
		String cleanUrl = url.replaceAll("[^\\x00-\\x7F]", "");
		cleanUrl = cleanUrl.replaceAll(" ", "+");
		return cleanUrl;
	}

}
