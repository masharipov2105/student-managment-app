package com.masharipov2105.systems.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import com.masharipov2105.systems.exceptions.InvalidNameException;

public final class PasswordUtils{

	private static final String ALGORITHM = "SHA-256";

	private PasswordUtils(){

		throw new UnsupportedOperationException("Utility class cannot be instantiated!");
	}

	public static String hashPassword(String passwd) throws InvalidNameException{

		if (passwd == null || passwd.trim().isEmpty()){

			throw new InvalidNameException("The field cannot be empty.");
		}

		try{

			MessageDigest digest = MessageDigest.getInstance(ALGORITHM);
			byte[] hashByte = digest.digest(passwd.trim().getBytes());

			StringBuilder builder = new StringBuilder();

			for (byte b: hashByte){

				builder.append(String.format("%02x", b));
			}

			return builder.toString();
		} catch(NoSuchAlgorithmException e){

			throw new InvalidNameException("Algorithm error");
		}
	}
}
