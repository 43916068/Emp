package com.ability.emp.util;

import java.util.UUID;

public class GenerateUUID {

	
	public static String generateUUID(){
		String uuid = UUID.randomUUID().toString();
		return uuid.replaceAll("-", "");
	}
}