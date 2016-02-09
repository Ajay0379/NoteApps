package com.note.spring.util;

import org.apache.commons.codec.binary.Base64;

/**
 * The Class PasswordEncyrptDecryptUtil.
 */
public class PasswordEncyrptDecryptUtil {

	/**
	 * Instantiates a new password encyrpt decrypt util.
	 */
	private PasswordEncyrptDecryptUtil() {

	}

	/**
	 * Gets the encoded password.
	 *
	 * @param password the password
	 * @return the encoded password
	 */
	public static String getEncodedPassword(String password){
		byte[] passbytes = password.getBytes();
		String encodedPassword = Base64.encodeBase64String(passbytes);
		return encodedPassword;
	}

	/**
	 * Gets the decoded password.
	 *
	 * @param encodedPassword the encoded password
	 * @return the decoded password
	 */
	public static String getDecodedPassword(String encodedPassword) {
		byte[] passwordInBytes = Base64.decodeBase64(encodedPassword);
		String password = new String(passwordInBytes);
		return password;
	}
}
